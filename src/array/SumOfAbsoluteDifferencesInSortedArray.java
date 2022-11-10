package array;

import java.util.Arrays;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/submissions/">Sum of Absolute Differences in a Sorted Array</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *     <li>Hint: Try to deduce mathematical expression.</li>
 *     <li>Time complexity: O(n)</li>
 *     <li>Space complexity: O(1)</li>
 * </ul>
 */

public class SumOfAbsoluteDifferencesInSortedArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getSumAbsoluteDifferences(new int[]{2, 3, 5})));
        System.out.println(Arrays.toString(getSumAbsoluteDifferences(new int[]{1, 4, 6, 8, 10})));
    }

    public static int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n], ans = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            arr[i] = sum;
        }

        ans[0] = arr[n - 1] - arr[0] - nums[0] * (n - 1);
        for (int i = 1; i < n; i++) {
            ans[i] = (nums[i] * i) - arr[i - 1] +
                    arr[n - 1] - arr[i] - (nums[i] * (n - 1 - i));
        }

        return ans;
    }
}
