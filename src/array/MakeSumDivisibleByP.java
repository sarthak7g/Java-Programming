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
 *      <li>Use hashmap to store the prefix sum.</li>
 *      <li>Now, to check the array is overlapping just check the sum-target is greater or equal to the last index of last subarray.</li>
 *      <li>And to always get the best answer, we'll put the rightmost index of any prefix sum in the map.</li>
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
        long sum=0, target;
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, -1);

        for(int el: nums) {
            sum += el;
        }
//        System.out.println(sum);

        target = sum % p;
//        System.out.println(target);

        if(target == 0) return 0;

        sum=0;
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            if(map.containsKey(sum-target)) {
                ans = Math.min(ans, i-map.get(sum-target));
            }
            map.put(sum, i);
        }

        if(ans == nums.length) return -1;
        return ans;

    }
}
