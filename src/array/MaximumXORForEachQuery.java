package array;

import java.util.Arrays;

/**
 * <h3>Level: Medium</h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/maximum-xor-for-each-query/">Maximum XOR for Each Query</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Hint: Prefix XOR</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(1)</li>
 * </ul>
 */

public class MaximumXORForEachQuery {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getMaximumXor(new int[]{0, 1, 2, 2, 5, 7}, 3)));
        System.out.println(Arrays.toString(getMaximumXor(new int[]{0, 1, 1, 3}, 2)));
    }

    public static int[] getMaximumXor(int[] nums, int mb) {
        int n = nums.length, curr = 0, max = (int) Math.pow(2, mb) - 1;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            curr ^= nums[i];
            ans[n - 1 - i] = max ^ curr;
        }

        return ans;
    }
}
