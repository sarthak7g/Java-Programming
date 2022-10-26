package array;

import java.util.Arrays;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/xor-queries-of-a-subarray/">XOR Queries of a Subarray</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 *      <ul>
 *          <li>Use Prefix XOR. For each query find XOR between (0...j) and (0...i-1) to get XOR of (i...j).</li>
 *          <li>Time complexity: O(n)</li>
 *          <li>Space complexity: O(n)</li>
 *      </ul>
 */

public class XORQueriesOnSubarray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(xorQueries(new int[]{1, 2, 4, 2, 5, 3}, new int[][]{{0, 1}, {0, 4}, {2, 5}, {0, 5}})));
        System.out.println(Arrays.toString(xorQueries(new int[]{1, 3, 4, 8}, new int[][]{{0, 1}, {1, 2}, {0, 3}, {3, 3}})));
    }

    public static int[] xorQueries(int[] arr, int[][] queries) {
        int[] store = new int[arr.length + 1];
        int[] ans = new int[queries.length];


        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            total ^= arr[i];
            store[i + 1] = total;
        }

        int t = 0;
        for (int[] qr : queries) {
            ans[t++] = store[qr[1] + 1] ^ store[qr[0]];
        }

        return ans;
    }

}
