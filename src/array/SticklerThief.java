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
 * <b>Approach 2:</b>
 * <ul>
 *      <li>Initialise a 2d array, dp[n][2]. Dp[i][0] will store max sum till ith index excluding arr[i] while dp[i][1] will store max sum including arr[i].</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 * <b>Approach 3:</b>
 * <ul>
 *      <li>Instead of using a 2d array, we can just use two variables, incl and excl.</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(1)</li>
 * </ul>
 */

public class SticklerThief {

    public static void main(String[] args) {
        System.out.println(findMaxSum(new int[] {5,5,10,100,10,5}));
        System.out.println(findMaxSum(new int[] {5,500,10,100,10,5,100}));

        System.out.println(findMaxSum2(new int[] {5,5,10,100,10,5}));
        System.out.println(findMaxSum2(new int[] {5,500,10,100,10,5,100}));

        System.out.println(findMaxSum3(new int[] {5,5,10,100,10,5}));
        System.out.println(findMaxSum3(new int[] {5,500,10,100,10,5,100}));
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

    public static int findMaxSum2(int[] arr)
    {
        int n = arr.length;
        int[][] dp = new int[n][2];
        dp[0][1] = arr[0];
        for(int i=1; i<n; i++) {
            dp[i][1] = arr[i] + dp[i-1][0];
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
        }

        return Math.max(dp[n-1][0], dp[n-1][1]);
    }


    public static int findMaxSum3(int[] arr)
    {
        int incl=0, excl=0, newIncl;
        for(int num : arr) {
            newIncl = num + excl;
            excl = Math.max(incl, excl);
            incl = newIncl;
        }

        // System.out.println(incl + " " + excl);
        return Math.max(incl, excl);
    }
}
