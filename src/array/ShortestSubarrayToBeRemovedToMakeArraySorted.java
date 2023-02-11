package array;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted/description/">Shortest Subarray to be Removed to Make Array Sorted</a>
 * <br/>
 * <br/>
 * <b>Approach 1:</b>
 * <ul>
 *      <li>Hint: The longest non-decreasing array would either start from the start or end at last of array respectively. Remove all middle bullshit.</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 * </body>
 */

public class ShortestSubarrayToBeRemovedToMakeArraySorted {
    public static void main(String[] args) {
        System.out.println(findLengthOfShortestSubarray(new int[]{1, 2, 3, 10, 4, 2, 3, 5}));
        System.out.println(findLengthOfShortestSubarray(new int[]{1, 2, 3, 10, 4, 2, 11, 12}));
        System.out.println(findLengthOfShortestSubarray(new int[]{5, 4, 3, 2, 1}));
        System.out.println(findLengthOfShortestSubarray(new int[]{1, 2, 3}));
        System.out.println(findLengthOfShortestSubarray(new int[]{16, 10, 0, 3, 22, 1, 14, 7, 1, 12, 15}));
    }

    public static int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length, i = 0, j = n - 1, ptr = n - 1, ans;
        while (i < n - 1 && arr[i] <= arr[i + 1]) i++;
        while (j >= 1 && arr[j] >= arr[j - 1]) j--;

        ans = Math.min(n - i - 1, j);
        if (i == n - 1 || j == 0) return 0;

        while (i >= 0 && ptr >= j) {
            if (arr[ptr] >= arr[i]) ptr--;
            else {
                ans = Math.min(ans, ptr - i);
                i--;
            }
        }

        ans = Math.min(ans, ptr - i);
        return ans;

    }
}
