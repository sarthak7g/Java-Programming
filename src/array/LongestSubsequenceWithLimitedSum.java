package array;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * <h3>Level: Easy </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/longest-subsequence-with-limited-sum/">Longest Subsequence With Limited Sum</a>
 * <br/>
 * <br/>
 * <b>Approach 1:</b>
 *      <ul>
 *          <li>Hint: Use TreeMap</li>
 *          <li>Time complexity: O(n log n)</li>
 *          <li>Space complexity: O(n)</li>
 *      </ul>
 */

public class LongestSubsequenceWithLimitedSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(answerQueries(new int[]{736411, 184882, 914641, 37925, 214915}, new int[]{331244, 273144, 118983, 118252, 305688, 718089, 665450})));
        System.out.println(Arrays.toString(answerQueries(new int[]{4, 5, 2, 1}, new int[]{3, 10, 21})));
    }

    public static int[] answerQueries(int[] nums, int[] queries) {
        int[] ans = new int[queries.length];
        int j = 0, sum = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            map.put(sum, i);
        }
        for (int q : queries) {
            // ans[j++] = solve(nums, q);
            Integer key = map.floorKey(q);
            if (key != null) {
                ans[j++] = map.get(key) + 1;
            } else ans[j++] = 0;
        }

        return ans;
    }
}
