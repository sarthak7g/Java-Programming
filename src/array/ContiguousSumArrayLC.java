package array;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/continuous-subarray-sum/">Contiguous Sum Array</a>
 * <br/>
 * Approach:
 * <ul>
 *     <li>Maintain sum in a set</li>
 *     <li>Time complexity: O(n^2)</li>
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
        if (nums.length == 1) return false;
        if (k == 1) return true;
        Set<Integer> set = new HashSet<>();
        int value = nums[0] % k;
        set.add(value);
        if (value == 0) set.add(k);
        for (int i = 1; i < nums.length; i++) {
            int val = nums[i] % k;

            if (set.contains(k - val)) {
                return true;
            }

            set = set.stream().map(x -> (x + val) % k).collect(Collectors.toSet());
            set.add(val);
            if (val == 0) set.add(k);
            // System.out.println(set);
        }
        return false;
    }
}
