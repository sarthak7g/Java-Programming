package array;

import java.util.Map;
import java.util.TreeMap;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/car-pooling/">Car Pooling</a>
 * <br/>
 * Approach:
 *      <ul>
 *          <li>{@link RangeAddition} approach</li>
 *          <li>Use treemap to store the elements, and whenever sum is greater than capacity, return false.</li>
 *          <li>Time complexity: O(n * log n) in worst case when at each interval there is boarding and un-boarding.</li>
 *          <li>Space complexity: O(26)</li>
 *      </ul>
 */

public class CarPooling {

    public static void main(String[] args) {
        System.out.println(carPooling(new int[][]{{2,1,5},{3,3,7}}, 4));
        System.out.println(carPooling(new int[][]{{2,1,5},{3,3,7}}, 5));
        System.out.println(carPooling(new int[][]{{2,1,5},{3,5,7}}, 3));
    }

    public static boolean carPooling(int[][] trips, int capacity) {
        Map<Integer, Integer> map = new TreeMap<>();

        for(int[] trip : trips) {
            map.put(trip[1], map.getOrDefault(trip[1], 0)+trip[0]);
            map.put(trip[2], map.getOrDefault(trip[2], 0)-trip[0]);
        }

        int sum=0;
        // System.out.println(map);
        for(Integer val : map.values()){
            sum += val;
            if(sum > capacity) return false;
        }

        return true;
    }
}
