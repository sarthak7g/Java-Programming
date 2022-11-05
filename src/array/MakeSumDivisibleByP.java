package array;

import java.util.HashMap;
import java.util.Map;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/make-sum-divisible-by-p/">Make Sum Divisible by P</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Know that (a+b)%p = a%p + b%p.</li>
 *      <li>Find the target = sum%p. Now, the question will become, find the subarray with sum % p = target. Here's how: <br/>
 *          (sum[0..n] - sum[i..j]) % p = 0 <br/>
 *          sum[0..n] % p = sum[i..j] % p <br/>
 *          target = sum[i..j] % p
 *      </li>
 *      <li>In hashmap store the prefix_sum % p at each index. And also check, if (prefix_sum - target) % p exists or not.</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 */

public class MakeSumDivisibleByP {
    public static void main(String[] args) {
        System.out.println(minSubarray(new int[] {26,19,11,14,18,4,7,1,30,23,19,8,10,6,26,3}, 26));
        System.out.println(minSubarray(new int[] {3,1,4,2}, 6));
        System.out.println(minSubarray(new int[] {3,1,2}, 3));
    }
    public static int minSubarray(int[] nums, int p) {
        int ans=nums.length;
        int sum=0, target, temp;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for(int el: nums) {
            sum += el;
            sum %= p;
        }
        target = sum % p;
        if(target == 0) return 0;

        sum=0;
        for(int i=0; i<nums.length; i++) {
            sum = (sum + nums[i])%p;
            temp = sum-target < 0 ? sum-target+p: sum-target;

            if(map.containsKey(temp)) {
                ans = Math.min(ans, i-map.get(temp));
            }

            map.put(sum, i);
        }
        // System.out.println(map);

        if(ans == nums.length) return -1;
        return ans;
    }
}
