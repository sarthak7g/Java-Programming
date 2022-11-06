package array;

import java.util.Arrays;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/maximum-sum-obtained-of-any-permutation/">Maximum Sum Obtained of Any Permutation</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Count the frequency at each index.</li>
 *      <li>Highest number will be at the index having highest frequency.</li>
 *      <li>Time complexity: O(n*log(n))</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 */

public class MaximumSumObtainedOfAnyPermutation {
    public static void main(String[] args) {
        System.out.println(maxSumRangeQuery(new int[]{2, 1, 3, 4, 5}, new int[][]{{1, 3}, {0, 1}}));
        System.out.println(maxSumRangeQuery(new int[]{2, 1, 3, 4, 5, 10}, new int[][]{{1, 3}, {1, 1}, {0, 2}}));
    }

    public static int maxSumRangeQuery(int[] nums, int[][] requests) {
        int sum = 0;
        int[] arr = new int[nums.length];
        for (int[] req : requests) {
            arr[req[0]] += 1;
            if (req[1] < nums.length - 1)
                arr[req[1] + 1] -= 1;
        }
        for (int i = 0; i < nums.length; i++) {
            sum += arr[i];
            arr[i] = sum;
        }
        Arrays.sort(nums);
        Arrays.sort(arr);
        long ans = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] <= 0) break;
            ans += (long) arr[i] * nums[i];
        }
        return (int) (ans % 1000000007);
    }
}
