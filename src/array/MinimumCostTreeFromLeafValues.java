package array;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/description/">Minimum Cost Tree From Leaf Values</a>
 * <br/>
 * <br/>
 * <b>Approach 1:</b>
 * <ul>
 *      <li>Hint: Use Dp to explore all paths. Refer <a href="https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/solutions/474188/i-think-i-able-to-explain-it-to-myself-and-to-you-java-dp-complexity-is-in-the-question/">solution</a></li>
 *      <li>Time complexity: O(n^2)</li>
 *      <li>Space complexity: O(n^2)</li>
 * </ul>
 * </body>
 */

public class MinimumCostTreeFromLeafValues {
    public static void main(String[] args) {
        System.out.println(mctFromLeafValues(new int[]{6, 2, 4}));
        System.out.println(mctFromLeafValues(new int[]{6, 2, 4, 5}));
    }

    static int[][] dp, max;

    public static int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        dp = new int[n][n];
        max = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
                max[i][j] = -1;
            }
        }
        return solve(arr, 0, n - 1);
    }

    public static int solve(int[] arr, int i, int j) {
        if (i > j) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        if (i == j) {
            max[i][j] = arr[i];
            dp[i][j] = 0;
            return 0;
        }

        int ans = Integer.MAX_VALUE, temp;
        for (int k = i; k < j; k++) {
            temp = solve(arr, i, k) + solve(arr, k + 1, j);
            temp += max[i][k] * max[k + 1][j];
            max[i][j] = Math.max(max[i][j], Math.max(max[i][k], max[k + 1][j]));
            ans = Math.min(ans, temp);
        }

        dp[i][j] = ans;
        // System.out.println(i + " " + j + " " + ans);
        return ans;
    }
}
