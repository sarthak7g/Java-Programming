package array;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/intervals-between-identical-elements/description/">Intervals Between Identical Elements</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Hint: Group indexes with arr[i] using hashMap. Now, for every list corresponding to a key in hashMap find the formula.</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 */

public class IntervalsBetweenIdenticalElements {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getDistances(new int[]{2,1,3,1,2,3,3})));
        System.out.println(Arrays.toString(getDistances(new int[]{10,5,10,10})));
        System.out.println(Arrays.toString(getDistances(new int[]{1,2,1,2,1,3,1,2,1,3,1,2,3,3})));
    }

    public static long[] getDistances(int[] arr) {
        int n = arr.length;
        long[] ans = new long[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            List<Integer> l;
            if(map.containsKey(arr[i])) {
                l = map.get(arr[i]);
            }
            else l = new ArrayList<>();
            l.add(i);
            map.put(arr[i], l);
        }
        // System.out.println(map);

        for(Integer key : map.keySet()) {
            solve(map.get(key), ans);
        }

        return ans;
    }

    public static void solve(List<Integer> list, long[] ans) {
        int n = list.size();
        long[] arr = new long[n+1];

        for(int i=0; i<n; i++) {
            arr[i+1] = arr[i] + list.get(i);
        }

        for(int i=0; i<n; i++) {
            int el = list.get(i);
            ans[el] = el * (2L*i + 1 - n) - arr[i] + arr[n] - arr[i+1];
        }
    }
}
