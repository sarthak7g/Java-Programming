package array;

import java.util.HashSet;
import java.util.Set;

/**
 * <h3>Level: Easy </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/find-the-town-judge/description/">Find the Town Judge</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 * </body>
 */

public class FindTheTownJudge {
    public static void main(String[] args) {
        System.out.println(findJudge(2, new int[][]{{1, 2}}));
        System.out.println(findJudge(3, new int[][]{{1, 3}, {2, 3}}));
        System.out.println(findJudge(3, new int[][]{{1, 3}, {2, 3}, {3, 1}}));
        System.out.println(findJudge(3, new int[][]{{1, 3}, {1, 2}, {2, 3}, {2, 1}}));
    }

    public static int findJudge(int n, int[][] trust) {
        int[] arr = new int[n + 1];
        Set<Integer> set = new HashSet<>();
        for (int[] t : trust) {
            arr[t[1]] += 1;
            set.add(t[0]);
        }

        for (int i = 1; i <= n; i++) {
            if (arr[i] == n - 1 && !set.contains(i)) return i;
        }

        return -1;
    }
}
