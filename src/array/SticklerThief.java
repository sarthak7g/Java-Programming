package array;

import java.util.HashMap;
import java.util.Map;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://practice.geeksforgeeks.org/problems/stickler-theif-1587115621/1">Stickler Thief</a>
 * <br/>
 * <br/>
 * <b>Approach 1:</b>
 * <ul>
 *      <li>At each position we can either include the element in max sum or we do not include it.</li>
 *      <li>While using dp, we will only store the sum from index i till n.</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 *
 */

public class SticklerThief {

    public static void main(String[] args) {
        System.out.println(findMaxSum(new int[] {5,5,10,100,10,5}));
        System.out.println(findMaxSum(new int[] {5,500,10,100,10,5,100}));
    }

    public static int findMaxSum(int[] arr)
    {
        Map<Integer, Integer> map = new HashMap<>();
        return find(arr, 0, 0, map);
    }

    public static int find(int[] arr, int index, int sum, Map<Integer, Integer> map) {
        if(index >= arr.length) return sum;
        if(map.containsKey(index)) return map.get(index)+sum;

        int ans = Math.max(find(arr, index+2, sum+arr[index], map), find(arr, index+1, sum, map));
        map.put(index, ans-sum);

        return ans;
    }
}
