package array;

import java.util.Arrays;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/count-submatrices-with-all-ones/description/">Count Submatrices With All Ones</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Brute force. Just try to find out solution for a 1d array and then compress each possible 2d array into a 1d array. Refer <a href="https://leetcode.com/problems/count-submatrices-with-all-ones/solutions/720265/java-detailed-explanation-from-o-mnm-to-o-mn-by-using-stack/">solution</a></li>
 *      <li>Time complexity: O(n^3)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 * </body>
 */

public class CountSubmatricesWithAllOnes {
    public static void main(String[] args) {
        System.out.println(numSubmat(new int[][]{{1, 0, 1}, {1, 1, 0}, {1, 1, 0}}));
        System.out.println(numSubmat(new int[][]{{0, 1, 1, 0}, {0, 1, 1, 1}, {1, 1, 1, 0}}));
    }

    public static int numSubmat(int[][] mat) {
        int n = mat.length, m = mat[0].length, ans = 0;
        int[] arr = new int[m];
        for (int up = 0; up < n; up++) {
            Arrays.fill(arr, 1);
            for (int down = up; down < n; down++) {
                for (int col = 0; col < m; col++) {
                    arr[col] &= mat[down][col];
                }
                ans += solve(arr);
            }
        }
        return ans;
    }

    public static int solve(int[] arr) {
        int sum = 0, res = 0;
        for (int j : arr) {
            sum = j == 0 ? 0 : sum + 1;
            res += sum;
        }
        return res;
    }
}
