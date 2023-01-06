package array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/maximum-white-tiles-covered-by-a-carpet/description/">Maximum White Tiles Covered by a Carpet</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Hint: Sorting and prefix array. refer <a href="https://leetcode.com/problems/maximum-white-tiles-covered-by-a-carpet/solutions/2038674/python-explanation-with-pictures-sliding-window/">solution</a></li>
 *      <li>Time complexity: O(n log(n))</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 * </body>
 */

public class MaximumWhiteTilesCoveredByACarpet {
    public static void main(String[] args) {
        System.out.println(maximumWhiteTiles(new int[][]{{1, 5}, {10, 11}, {12, 18}, {20, 25}, {30, 32}}, 10));
        System.out.println(maximumWhiteTiles(new int[][]{{10, 11}, {1, 1}}, 2));
    }

    public static int maximumWhiteTiles(int[][] tiles, int cl) {
        Arrays.sort(tiles, Comparator.comparingInt(a -> a[0]));
        int n = tiles.length, sum, left, right, max = 0, j = 0;
        int[] prefix_arr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix_arr[i + 1] = prefix_arr[i] + tiles[i][1] - tiles[i][0] + 1;
        }

        for (int i = 0; i < n; i++) {
            left = tiles[i][0];
            right = left + cl - 1;

            while (j < n && right > tiles[j][1]) {
                j++;
            }

            if (j == n) {
                sum = prefix_arr[n] - prefix_arr[i];
                max = Math.max(max, sum);
                break;
            }

            if (right < tiles[j][0]) {
                sum = prefix_arr[j] - prefix_arr[i];
            } else {
                sum = prefix_arr[j + 1] - prefix_arr[i] - (tiles[j][1] - right);
            }

            max = Math.max(max, sum);
        }

        return max;
    }
}
