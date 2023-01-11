package array;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/maximum-trailing-zeros-in-a-cornered-path/description/">Maximum Trailing Zeros in a Cornered Path</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Intuition: To find trailing zeros we have to find the number of two's and five's in the path.</li>
 *      <li>Considering each cell a corner, in all 4 directions, find the two's and five's. For that we require prefix sum.</li>
 *      <li>Time complexity: O(n^2)</li>
 *      <li>Space complexity: O(n^2)</li>
 * </ul>
 * </body>
 */

public class MaximumTrailingZerosInACorneredPath {
    public static void main(String[] args) {
        System.out.println(maxTrailingZeros(new int[][]{{23, 17, 15, 3, 20}, {8, 1, 20, 27, 11}, {9, 4, 6, 2, 21}, {40, 9, 1, 10, 6}, {22, 7, 4, 5, 3}}));
        System.out.println(maxTrailingZeros(new int[][]{{4, 3, 2}, {7, 6, 1}, {8, 8, 8}}));
    }

    public static int maxTrailingZeros(int[][] grid) {
        int n = grid.length, m = grid[0].length, two, five, sum_two, sum_five, ans = 0;
        int[][] arr_two = new int[n + 1][m + 1], arr_five = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            sum_two = 0;
            sum_five = 0;
            for (int j = 0; j < m; j++) {
                two = findFactors(grid[i][j], 2);
                five = findFactors(grid[i][j], 5);
                sum_two += two;
                sum_five += five;
                arr_two[i + 1][j + 1] = arr_two[i][j + 1] + sum_two;
                arr_five[i + 1][j + 1] = arr_five[i][j + 1] + sum_five;
            }
        }

        int up_two, left_two, down_two, right_two, up_five, left_five, right_five, down_five;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                up_two = arr_two[i + 1][j + 1] - arr_two[i + 1][j];
                down_two = arr_two[n][j + 1] - arr_two[n][j] - up_two + findFactors(grid[i][j], 2);
                left_two = arr_two[i + 1][j] - arr_two[i][j];
                right_two = arr_two[i + 1][m] - arr_two[i][m] - left_two - findFactors(grid[i][j], 2);

                up_five = arr_five[i + 1][j + 1] - arr_five[i + 1][j];
                down_five = arr_five[n][j + 1] - arr_five[n][j] - up_five + findFactors(grid[i][j], 5);
                left_five = arr_five[i + 1][j] - arr_five[i][j];
                right_five = arr_five[i + 1][m] - arr_five[i][m] - left_five - findFactors(grid[i][j], 5);

                ans = Math.max(ans, Math.min(up_two + left_two, up_five + left_five));
                ans = Math.max(ans, Math.min(up_two + right_two, up_five + right_five));
                ans = Math.max(ans, Math.min(down_two + left_two, down_five + left_five));
                ans = Math.max(ans, Math.min(down_two + right_two, down_five + right_five));

            }
        }
        return ans;
    }

    public static int findFactors(int val, int of) {
        int count = 0;
        while (val % of == 0) {
            val /= of;
            count++;
        }
        return count;
    }

}
