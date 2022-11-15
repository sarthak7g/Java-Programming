package array;

/**
 * <h3>Level: Easy </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/check-if-all-the-integers-in-a-range-are-covered/">Check if All the Integers in a Range Are Covered</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>{@link RangeAddition} approach</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(1)</li>
 * </ul>
 *
 */

public class CheckIntegerRange {

    public static void main(String[] args) {
        System.out.println(isCovered(new int[][]{{1, 5}, {2, 4}, {7, 8}}, 3, 6));
        System.out.println(isCovered(new int[][]{{1, 10}, {11, 20}, {7, 8}}, 21, 21));
    }

    public static boolean isCovered(int[][] ranges, int left, int right) {
        int[] arr = new int[52];
        for (int[] range : ranges) {
            arr[range[0]] += 1;
            arr[range[1] + 1] -= 1;
        }
        int sum = 0;
        for (int i = 1; i < 51; i++) {
            sum += arr[i];
            if (sum == 0 && i >= left && i <= right) return false;
        }

        return true;
    }
}
