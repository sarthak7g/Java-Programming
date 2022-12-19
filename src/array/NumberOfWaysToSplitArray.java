package array;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/number-of-ways-to-split-array/">Number of Ways to Split Array</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Hint : Use prefix sum and find mathematical equation.</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 */

public class NumberOfWaysToSplitArray {
    public static void main(String[] args) {
        System.out.println(waysToSplitArray(new int[]{2, 5, 3, 9, 5, 3}));
        System.out.println(waysToSplitArray(new int[]{10, 4, -8, 7}));
    }

    public static int waysToSplitArray(int[] nums) {
        int n = nums.length, ans = 0;
        long[] arr = new long[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i + 1] = arr[i] + nums[i];
        }

        for (int i = 0; i < n - 1; i++) {
            if (arr[i + 1] >= (arr[n] - arr[i + 1]))
                ans += 1;
        }

        return ans;
    }
}
