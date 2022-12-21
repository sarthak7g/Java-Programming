package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/range-product-queries-of-powers/description/">Range Product Queries of Powers</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Hint: Find all the powers using log and then use prefix sum.</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 * </body>
 */

public class RangeProductQueriesOfPowers {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productQueries(15, new int[][]{{0, 1}, {2, 2}, {0, 3}})));
        System.out.println(Arrays.toString(productQueries(2, new int[][]{{0, 0}})));
        System.out.println(Arrays.toString(productQueries(14, new int[][]{{0, 2}})));
    }

    public static int[] productQueries(int n, int[][] queries) {
        int l = queries.length, power, k = 0;
        int[] ans = new int[l], arr;

        List<Integer> al = new ArrayList<>();

        while (n > 0) {
            power = (int) (Math.log(n) / Math.log(2));
            al.add(power);
            n -= (int) Math.pow(2, power);
        }

        Collections.reverse(al);

        arr = new int[al.size() + 1];
        for (int i = 0; i < al.size(); i++) {
            arr[i + 1] = arr[i] + al.get(i);
        }

        long mod = 1000000007;
        for (int[] q : queries) {
            power = arr[q[1] + 1] - arr[q[0]];
            ans[k++] = (int) (Math.pow(2, power) % mod);
        }

        return ans;
    }
}
