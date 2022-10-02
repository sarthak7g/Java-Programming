package array;

import java.util.Arrays;

/**
 * <h3>Level: Medium </h3>
 * <h4>LC PREMIUM</h4>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/range-addition/">Range Addition</a>
 * <br/>
 * <br/>
 * <b>Question:</b>
 * <ul>
 *     <li>You are given an integer length and an array updates where updates[i] = [startIdxi, endIdxi, inci].</li>
 *     <li>You have an array arr of length <b><i>length</i></b> with all zeros, and you have some operation to apply on arr. In the ith operation, you should increment all the elements arr[startIdxi], arr[startIdxi + 1], ..., arr[endIdxi] by inci.</li>
 *     <li>Return arr after applying all the updates.</li>
 * </ul>
 *
 * <b>Example:</b>
 * <ul>
 *      <li>length = 5, updates = [[1,3,2],[2,4,3],[0,2,-2]]</li>
 *      <li>[0,0,0,0,0] => [0,2,2,2,0] => [0,2,5,5,3] => [-2,0,3,5,3]</li>
 * </ul>
 *
 * <b>Approach:</b>
 * <ul>
 *      <li>We will increment all the values starting from startIndex by inc and decrement all the values after endIndex by inc, s.t. arr[i] = arr[i]+inc, for all i>=startIndex, and arr[j] = arr[j]+inc-inc for all j>endIndex.</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 *
 *
 */


public class RangeAddition {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getModifiedArray(5, new int[][]{{1,3,2},{2,4,3},{0,2,-2}})));
    }
    public static int[] getModifiedArray(int n, int[][] updates) {
        int[] ans = new int[n];
        for(int[] arr : updates) {
            ans[arr[0]] += arr[2];

            if(arr[1]<n-1) {
                ans[arr[1]+1] -= arr[2];
            }
        }
        // System.out.println(Arrays.toString(ans));
        for(int i=1; i<n; i++) {
            ans[i] += ans[i-1];
        }

        return ans;
    }
}
