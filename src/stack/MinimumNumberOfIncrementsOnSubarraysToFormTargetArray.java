package stack;

/**
 * <h3>Level: Hard </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array/description/">Minimum Number of Increments on Subarrays to Form a Target Array</a>
 * <br/>
 * <br/>
 * <b>Approach 1:</b>
 * <ul>
 *      <li>Hint: Ultimately the problem will come down to adding all local maxima and subtracting all local minima.</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(1)</li>
 * </ul>
 * <b>Approach 2:</b>
 * <ul>
 *      <li>Refer <a href="https://leetcode.com/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array/solutions/754623/detailed-explanation/">solution</a></li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(1)</li>
 * </ul>
 * </body>
 */

public class MinimumNumberOfIncrementsOnSubarraysToFormTargetArray {
    public static void main(String[] args) {
        System.out.println(minNumberOperations(new int[]{1, 2, 3, 2, 1}));
        System.out.println(minNumberOperations(new int[]{3, 1, 1, 2}));
        System.out.println(minNumberOperations(new int[]{3, 1, 5, 4, 2}));
        System.out.println(minNumberOperations(new int[]{15, 14, 13, 5, 7, 9, 6, 3, 12}));
        System.out.println(minNumberOperations(new int[]{15, 14, 13, 5, 7, 9, 6, 8, 12}));
        System.out.println();
        System.out.println(minNumberOperations2(new int[]{1, 2, 3, 2, 1}));
        System.out.println(minNumberOperations2(new int[]{3, 1, 1, 2}));
        System.out.println(minNumberOperations2(new int[]{3, 1, 5, 4, 2}));
        System.out.println(minNumberOperations2(new int[]{15, 14, 13, 5, 7, 9, 6, 3, 12}));
        System.out.println(minNumberOperations2(new int[]{15, 14, 13, 5, 7, 9, 6, 8, 12}));
    }

    public static int minNumberOperations(int[] arr) {
        int n=arr.length, i=1, ans=0;
        while(i<n) {
            while(i<n && arr[i] >= arr[i-1]) i++;
            ans += arr[i-1];

            while(i<n && arr[i] <= arr[i-1]) i++;
            if(i<n)
                ans -= arr[i-1];
        }
        return ans;
    }

    public static int minNumberOperations2(int[] arr) {
        int n=arr.length, ans=arr[0];
        for(int i=1; i<n; i++) {
            if(arr[i] > arr[i-1]) {
                ans += arr[i] - arr[i-1];
            }
        }
        return ans;
    }
}
