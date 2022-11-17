package array;

import java.util.Arrays;

/**
 * <h3>Level: Easy</h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/running-sum-of-1d-array/submissions/">Running Sum</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Hint: Prefix Sum</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(1)</li>
 * </ul>
 */

public class RunningSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(runningSum(new int[]{1, 2, 3, 23, 256, 0})));
        System.out.println(Arrays.toString(runningSum(new int[]{1, 0, 5, 6})));
    }

    public static int[] runningSum(int[] nums) {
        int[] ans = new int[nums.length];
        int sum = 0, i = 0;
        for (int el : nums) {
            sum += el;
            ans[i++] = sum;
        }

        return ans;
    }

}
