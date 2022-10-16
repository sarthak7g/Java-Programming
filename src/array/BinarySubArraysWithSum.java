package array;

import java.util.HashMap;
import java.util.Map;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/binary-subarrays-with-sum/">Binary SubArrays With Sum</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>While iterating the array, maintain the frequency of prefix sum at each index and also calculate the number of sub arrays i.e., equal to sum-goal.</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 *
 */

public class BinarySubArraysWithSum {

    public static void main(String[] args) {
        System.out.println(numSubarraysWithSum(new int[] {1,1,1,1,0,0,0,1,0,0,1,0}, 2));
        System.out.println(numSubarraysWithSum(new int[] {1,1,1,1,0,0,0,1,0,0,1,0}, 3));
        System.out.println(numSubarraysWithSum(new int[] {0,0,0,0,0}, 0));
    }

    public static int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum=0, ans=0;
        for(int val : nums) {
            sum += val;

            ans += map.getOrDefault(sum-goal, 0);

            map.put(sum, map.getOrDefault(sum, 0)+1);
        }

        return ans;

    }
}
