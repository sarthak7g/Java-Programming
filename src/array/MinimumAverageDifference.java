package array;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/minimum-average-difference/description/">Minimum Average Difference</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Hint : Use prefix sum and find mathematical equation.</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 */

public class MinimumAverageDifference {
    public static void main(String[] args) {
        System.out.println(minimumAverageDifference(new int[] {2,5,3,9,5,3}));
        System.out.println(minimumAverageDifference(new int[] {0}));
    }
    public static int minimumAverageDifference(int[] nums) {
        int n = nums.length, min = Integer.MAX_VALUE, temp, ans = -1;
        long[] arr = new long[n+1];
        for(int i=0; i<n; i++) {
            arr[i+1] = arr[i] + nums[i];
        }

        for(int i=0; i<n-1; i++) {
            temp = (int)Math.abs(arr[i+1]/(i+1) - (arr[n]-arr[i+1])/(n-i-1));
            if(temp < min) {
                min = temp;
                ans = i;
            }
        }

        temp = (int)Math.abs(arr[n]/n);
        if(temp < min) {
            ans = n-1;
        }
        return ans;
    }
}
