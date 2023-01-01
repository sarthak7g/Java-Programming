package array;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/divide-intervals-into-minimum-number-of-groups/description/">Divide Intervals Into Minimum Number of Groups</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Hint: Range addition formula</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 * </body>
 */

public class DivideIntervalsIntoMinimumNumberOfGroups {
    public static void main(String[] args) {
        System.out.println(minGroups(new int[][]{{5, 10}, {6, 8}, {1, 5}, {2, 3}, {1, 10}}));
        System.out.println(minGroups(new int[][]{{1, 3}, {5, 6}, {8, 10}, {12, 13}}));
        System.out.println(minGroups(new int[][]{{1, 3}, {1, 3}}));
    }

    public static int minGroups(int[][] intervals) {
        int n = 0, sum = 0;
        for (int[] arr : intervals) {
            n = Math.max(n, arr[1]);
        }

        int[] arr = new int[n + 2];
        for (int[] range : intervals) {
            arr[range[0]] += 1;
            arr[range[1] + 1] -= 1;
        }

        n = 0;
        for (int val : arr) {
            sum += val;
            n = Math.max(n, sum);
        }

        return n;
    }
}
