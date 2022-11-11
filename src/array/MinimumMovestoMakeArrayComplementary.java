package array;

import java.util.Arrays;

/**
 * <h3>Level: Medium but Hard</h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/minimum-moves-to-make-array-complementary/">Minimum Moves to Make Array Complementary</a>
 * <br/>
 * <a href="https://leetcode.com/problems/minimum-moves-to-make-array-complementary/discuss/953078/Prefix-sum-O(n-%2B-limit)-with-detailed-examples-and-pseudocode">Solution</a>
 */

public class MinimumMovestoMakeArrayComplementary {
    public static void main(String[] args) {
        System.out.println(minMoves(new int[]{1,2,4,3}, 4));
        System.out.println(minMoves(new int[]{1,2,2,1}, 2));
        System.out.println(minMoves(new int[]{2, 3, 4, 1, 2, 2, 2, 2}, 4));
    }

    public static int minMoves(int[] nums, int limit) {
        int[] arr = new int[2 * limit + 2];
        Arrays.fill(arr, 0);

        int l, r, lo, just, hi, n = nums.length, ans = n, sum = n;
        for (int i = 0; i < n / 2; i++) {
            l = nums[i];
            r = nums[n - 1 - i];

            lo = Math.min(l, r) + 1;
            just = l + r;
            hi = Math.max(l, r) + limit;

            arr[lo] -= 1;
            arr[just] -= 1;
            arr[just + 1] += 1;
            arr[hi + 1] += 1;
        }

        for (int el : arr) {
            sum += el;
            ans = Math.min(ans, sum);
        }
        return ans;
    }

}
