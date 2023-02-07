package array;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

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
 * <b>Approach 2:</b>
 * <ul>
 *      <li>Hint: Bottom-up approach. Build tree using the smallest element in the array. Refer <a href="https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/solutions/478708/rz-summary-of-all-the-solutions-i-have-learned-from-discuss-in-python/">solution</a></li>
 *      <li>Time complexity: O(n^2)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 * <b>Approach 3:</b>
 * <ul>
 *      <li>Hint: Monotonic Stack. Refer <a href="https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/solutions/478708/rz-summary-of-all-the-solutions-i-have-learned-from-discuss-in-python/">solution</a></li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 * </body>
 */

public class MinimumCostTreeFromLeafValues {
    public static void main(String[] args) {
        System.out.println(mctFromLeafValues(new int[]{6, 2, 4}));
        System.out.println(mctFromLeafValues(new int[]{6, 2, 4, 5}));
        System.out.println();
        System.out.println(mctFromLeafValues2(new int[]{6, 2, 4}));
        System.out.println(mctFromLeafValues2(new int[]{6, 2, 4, 5}));
        System.out.println();
        System.out.println(mctFromLeafValues3(new int[]{6, 2, 4}));
        System.out.println(mctFromLeafValues3(new int[]{6, 2, 4, 5}));
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

    public static int mctFromLeafValues2(int[] arr) {
        int idx, res = 0;
        List<Integer> al = new ArrayList<>();
        for (int j : arr) {
            al.add(j);
        }

        while (al.size() > 1) {
            idx = min(al);

            if (idx > 0 && idx < al.size() - 1) {
                res += al.get(idx) * (Math.min(al.get(idx + 1), al.get(idx - 1)));
            } else {
                res += al.get(idx) * (idx == 0 ? al.get(idx + 1) : al.get(idx - 1));
            }
            al.remove(idx);
        }
        return res;
    }

    public static int min(List<Integer> arr) {
        int min = arr.get(0), idx = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) < min) {
                min = arr.get(i);
                idx = i;
            }
        }
        return idx;
    }

    public static int mctFromLeafValues3(int[] arr) {
        int curr, res = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int j : arr) {
            while (!stack.isEmpty() && stack.getFirst() <= j) {
                curr = stack.remove();
                if (stack.isEmpty()) {
                    res += j * curr;
                } else res += curr * (Math.min(j, stack.getFirst()));
            }
            stack.addFirst(j);
        }

        while (stack.size() > 1) {
            curr = stack.remove();
            res += curr * stack.getFirst();
        }

        return res;

    }
}