package array;

import java.util.HashMap;
import java.util.Map;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/subarray-sum-equals-k/">Subarray Sum Equals K</a>
 * <br/>
 * Approach:
 *      <ul>
 *          <li>Use prefix sum and hashmap with it.</li>
 *          <li>Time complexity: O(n)</li>
 *          <li>Space complexity: O(n)</li>
 *      </ul>
 */

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1,2,3,-3,2}, 2));
        System.out.println(subarraySum(new int[]{1,2,3,-3,2}, 0));
    }

    public static int subarraySum(int[] nums, int k) {
        int sum=0, count=0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            count += map.getOrDefault(sum - k, 0);
            int val = map.getOrDefault(sum, 0);
            map.put(sum, val + 1);

        }

        return count;
    }

}
