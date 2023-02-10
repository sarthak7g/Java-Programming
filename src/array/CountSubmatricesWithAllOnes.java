package array;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/count-submatrices-with-all-ones/description/">Count Submatrices With All Ones</a>
 * <br/>
 * <br/>
 * <b>Approach 1:</b>
 * <ul>
 *      <li>Brute force. Just try to find out solution for a 1d array and then compress each possible 2d array into a 1d array. Refer <a href="https://leetcode.com/problems/count-submatrices-with-all-ones/solutions/720265/java-detailed-explanation-from-o-mnm-to-o-mn-by-using-stack/">solution</a></li>
 *      <li>Time complexity: O(n^3)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 * <b>Approach 2:</b>
 * <ul>
 *      <li>MS: Increasing stack. Refer <a href="https://leetcode.com/problems/count-submatrices-with-all-ones/solutions/720265/java-detailed-explanation-from-o-mnm-to-o-mn-by-using-stack/">solution</a></li>
 *      <li>Time complexity: O(n^2)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 * </body>
 */

public class CountSubmatricesWithAllOnes {
    public static void main(String[] args) {
        System.out.println(numSubmat(new int[][]{{1, 0, 1}, {1, 1, 0}, {1, 1, 0}}));
        System.out.println(numSubmat(new int[][]{{0, 1, 1, 0}, {0, 1, 1, 1}, {1, 1, 1, 0}}));
        System.out.println();
        System.out.println(numSubmat2(new int[][]{{1, 0, 1}, {1, 1, 0}, {1, 1, 0}}));
        System.out.println(numSubmat2(new int[][]{{0, 1, 1, 0}, {0, 1, 1, 1}, {1, 1, 1, 0}}));
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

    public static int numSubmat2(int[][] mat) {
        int m = mat[0].length, ans = 0;
        int[] arr = new int[m];
        for (int[] ints : mat) {
            for (int col = 0; col < m; col++) {
                arr[col] = ints[col] == 0 ? 0 : arr[col] + 1;
            }
            ans += find(arr);
        }
        return ans;
    }

    public static int find(int[] arr) {
        int res = 0, temp;
        int[] sum = new int[arr.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.getFirst()] > arr[i])
                stack.remove();

            if (stack.isEmpty()) {
                sum[i] += arr[i] * (i + 1);
            } else {
                temp = stack.getFirst();
                sum[i] = sum[temp] + arr[i] * (i - temp);
            }
            stack.addFirst(i);
        }
        for (int s : sum) res += s;
        return res;
    }
}
