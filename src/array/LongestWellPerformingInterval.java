package array;

import java.util.HashMap;
import java.util.Map;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/longest-well-performing-interval/">Longest Well-Performing Interval</a>
 * <br/>
 * <br/>
 * <b>Approach I:</b>
 *      <ul>
 *          <li>Maintain a variable sum, whenever arr[i] > 8, sum+=1 else sum-=1. If overall sum>0 then, whole array is the longest well performing interval.</li>
 *          <li>If you see the lowest sum then, record its index into the map.</li>
 *          <li>Otherwise at each point update ans, by comparing the first position of sum-1 with curr position(i).</li>
 *          <li>Time complexity: O(n)</li>
 *          <li>Space complexity: O(n)</li>
 *      </ul>
 */

public class LongestWellPerformingInterval {
    public static void main(String[] args) {
        System.out.println(longestWPI(new int[]{9,9,0,9,0,6,9,9}));
        System.out.println(longestWPI(new int[]{9,0,0,9,0,6,9,9}));
    }

    public static int longestWPI(int[] hours) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int sum=0, ans=0, min=0;
        for(int i=0; i<hours.length; i++) {
            if(hours[i] > 8) {
                sum += 1;
            }else {
                sum -= 1;
            }

            if(sum < min) {
                min = sum;
                map.put(min, i);
                continue;
            }

            if(map.containsKey(sum-1)){
                ans = Math.max(ans, i-map.get(sum-1));
            }
        }
        // System.out.println(map);
        if(sum > 0) return hours.length;
        return ans;
    }
}
