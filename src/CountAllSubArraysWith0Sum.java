import java.util.HashMap;
import java.util.Map;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://practice.geeksforgeeks.org/problems/zero-sum-subarrays1825/1">Count all Sub arrays with 0 sum</a>
 * <br/>
 * Approach:
 *      <ul>
 *          <li>take a variable sum, which will add each element when iterating through the array</li>
 *          <li>add sum frequency to hashmap, whenever a sum repeats more than 1 times, we got a subarray with 0 sum</li>
 *          <li>Time complexity: O(n)</li>
 *          <li>Space complexity: O(n)</li>
 *      </ul>
 */

public class CountAllSubArraysWith0Sum {
    public static void main(String[] args) {
        System.out.println(findSubarray(new long[]{6,-1,-3,4,-2,2,4,6,-12,-7})) ;
        System.out.println(findSubarray(new long[]{0,0,5,5,0,0,-5,-5,5,-5,-5,5})) ;
    }
    public static long findSubarray(long[] arr)
    {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, 1);
        for (long l : arr) {
            sum += l;
            if (map.containsKey(sum)) {
                map.put(sum, map.get(sum) + 1);
            } else map.put(sum, 1);
        }

        // System.out.println(map);
        int ans = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() > 1){
                int val = entry.getValue();
                ans += (val*(val-1))/2;
            }
        }

        return ans;

    }
}
