package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/plates-between-candles/description/">Plates Between Candles</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Use an array to store count of plates at each index. Also, a hashMap for the number of plates at first index</li>
 *      <li>Now, we need to find the first and the last plates between the substring.</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 * </body>
 */

public class PlatesBetweenCandles {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(platesBetweenCandles("**|**|***|", new int[][]{{2, 5}, {5, 9}})));
        System.out.println(Arrays.toString(platesBetweenCandles("***|**|*****|**||**|*", new int[][]{{1, 17}, {4, 5}, {14, 17}, {5, 11}, {15, 16}})));
    }

    public static int[] platesBetweenCandles(String s, int[][] queries) {
        int[] arr = new int[s.length() + 1], ans = new int[queries.length];
        Map<Integer, Integer> map = new HashMap<>();
        int i, j, k = 0;

        for (i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '|') {
                arr[i + 1] = arr[i] + 1;
                map.put(arr[i + 1], i + 1);
            } else arr[i + 1] = arr[i];

        }

        for (int[] q : queries) {
            i = map.getOrDefault(arr[q[0]] + 1, s.length());
            j = map.getOrDefault(arr[q[1] + 1], 0);

            if (i <= q[1] && arr[j] >= arr[i] + 1) {
                ans[k] = (j - i + 1) - (arr[j] - arr[i - 1]);
            }
            k++;
        }
        return ans;
    }
}
