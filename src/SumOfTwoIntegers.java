/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/sum-of-two-integers/description/">Sum of Two Integers</a>
 * <br/>
 * <br/>
 * <b>Approach 1:</b>
 * <ul>
 *      <li>Refer <a href="https://leetcode.com/problems/sum-of-two-integers/editorial/">solution</a></li>
 *      <li>Time complexity: O(1)</li>
 *      <li>Space complexity: O(1)</li>
 * </ul>
 * <b>Approach 2:</b>
 * <ul>
 *      <li>Hint: Use log property</li>
 *      <li>Time complexity: O(1)</li>
 *      <li>Space complexity: O(1)</li>
 * </ul>
 * </body>
 */

public class SumOfTwoIntegers {
    public static void main(String[] args) {
        System.out.println(getSum(1, 2));
        System.out.println(getSum(2, 3));
        System.out.println(getSum(17, 13));
        System.out.println(getSum(15, 5));
        System.out.println();
        System.out.println(getSum2(1, 2));
        System.out.println(getSum2(2, 3));
        System.out.println(getSum2(17, 13));
        System.out.println(getSum2(15, 5));
    }

    public static int getSum(int a, int b) {
        int temp;
        while (b != 0) {
            temp = (a & b) << 1;
            a = a ^ b;
            b = temp;
        }
        return a;
    }

    public static int getSum2(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        return (int) Math.round(Math.log(Math.exp(a) * Math.exp(b)));
    }
}
