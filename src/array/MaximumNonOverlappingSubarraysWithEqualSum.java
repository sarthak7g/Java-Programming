package array;

import java.util.HashMap;
import java.util.Map;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/maximum-number-of-non-overlapping-subarrays-with-sum-equals-target/">Maximum Number of Non-Overlapping Sub-arrays With Sum Equals Target</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Use hashmap to store the prefix sum.</li>
 *      <li>Now, to check the array is overlapping just check the sum-target is greater or equal to the last index of last subarray.</li>
 *      <li>And to always get the best answer, we'll put the rightmost index of any prefix sum in the map.</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 */

public class MaximumNonOverlappingSubarraysWithEqualSum {
    public static void main(String[] args) {
        System.out.println(maxNonOverlapping(new int[]{1, 1, 1, 1, 1}, 2));
        System.out.println(maxNonOverlapping(new int[]{1, 1, 1, 1, 1}, 0));
        System.out.println(maxNonOverlapping(new int[]{-1, 3, 5, 1, 4, 2, -9}, 6));
        System.out.println(maxNonOverlapping(new int[]{1, 3, -4, 8, 7, 3, -2, 3}, 4));
    }

    public static int maxNonOverlapping(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0, idx = -1, ans = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (map.containsKey(sum - target) && map.get(sum - target) >= idx) {
                ans += 1;
                idx = i;
            }
            map.put(sum, i);

        }
        return ans;

    }
}
