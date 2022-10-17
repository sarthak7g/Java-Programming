package array;

import java.util.HashMap;
import java.util.Map;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/subarray-sums-divisible-by-k/">Subarray Sums Divisible by K</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>While iterating the array, maintain a hashmap with keys as modulo. For a negative modulus we need to add k to modulo.</li>
 *      <li>For ex: when k=6, and modulo is -2, then modulo = modulo + k, i.e., 4 in this case.</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 *
 */

public class SubarraySumsDivisibleByK {

    public static void main(String[] args) {
        System.out.println(subarraysDivByK(new int[] {2,-2,2,-4, -6 ,-12, 0}, 6));
        System.out.println(subarraysDivByK(new int[] {-1, 2, 9}, 2));
        System.out.println(subarraysDivByK(new int[] {2,-2,2,-4, -6 ,-12}, 6));
    }

    public static int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum=0, ans=0, modulo, temp;
        for(int val : nums) {
            sum += val;
            modulo = sum % k;
            modulo = modulo < 0 ? modulo+k : modulo;

            temp = map.getOrDefault(modulo, 0);
            ans += temp;

            map.put(modulo, temp+1);
        }

        return ans;
    }
}
