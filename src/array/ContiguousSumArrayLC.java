package array;

import java.util.HashMap;
import java.util.Map;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/continuous-subarray-sum/">Contiguous Sum Array</a>
 * <br/>
 * Approach:
 * <ul>
 *     <li>Use prefix sum concept and whenever prefix sum modulo k is same at two positions, i.e., we have a multiple of k in between</li>
 *     <li>for the constraint of subarray with at least two elements, check the position of same key - which should be 1 less than current position</li>
 *     <li>Time complexity: O(n)</li>
 *     <li>Space complexity: O(n)</li>
 * </ul>
 */

public class ContiguousSumArrayLC {

    public static void main(String[] args) {
        System.out.println(checkSubarraySum(new int[]{1, 0}, 2));
        System.out.println(checkSubarraySum(new int[]{1}, 1));
        System.out.println(checkSubarraySum(new int[]{5, 0, 0, 0}, 3));
        System.out.println(checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6));
        System.out.println(checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 5));
        System.out.println(checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 7));
    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        int sum=0;

        for(int i=0; i<nums.length; i++) {
            sum += nums[i];

            if(!map.containsKey(sum%k)) {
                map.put(sum%k, i+1);
            }

            if(map.get(sum%k) < i)
                return true;

        }
        return false;
    }
}
