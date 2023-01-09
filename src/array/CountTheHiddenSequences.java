package array;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/count-the-hidden-sequences/description/">Count the Hidden Sequences</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Hint: Assume the first element as x and now start taking the prefix sum which will eventually help to find out the actual range of x./li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(1)</li>
 * </ul>
 * </body>
 */

public class CountTheHiddenSequences {
    public static void main(String[] args) {
        System.out.println(numberOfArrays(new int[]{1, -3, 4}, 1, 6));
        System.out.println(numberOfArrays(new int[]{3, -4, 5, 1, -2}, -4, 5));
        System.out.println(numberOfArrays(new int[]{-40}, -46, 53));
    }

    public static int numberOfArrays(int[] arr, int lower, int upper) {
        long max = Long.MIN_VALUE, min = Long.MAX_VALUE, sum = 0;

        for (int val : arr) {
            min = Math.min(min, sum);
            max = Math.max(max, sum);
            sum += val;
        }
        min = Math.min(min, sum);
        max = Math.max(max, sum);

        return (int) Math.max((upper - max) - (lower - min) + 1, 0);
    }
}
