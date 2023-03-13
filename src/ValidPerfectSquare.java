/**
 * <h3>Level: Easy </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/valid-perfect-square/description/">Valid Perfect Square</a>
 * <br/>
 * <br/>
 * <b>Approach 1:</b>
 * <ul>
 *      <li>Iterative increment</li>
 *      <li>Time complexity: O(log(n))</li>
 *      <li>Space complexity: O(1)</li>
 * </ul>
 * <b>Approach 2:</b>
 * <ul>
 *      <li>Binary Search</li>
 *      <li>Time complexity: O(log(n))</li>
 *      <li>Space complexity: O(1)</li>
 * </ul>
 * <b>Approach 3:</b>
 * <ul>
 *      <li>Newton's seed formula</li>
 *      <li>Time complexity: O(log(n))</li>
 *      <li>Space complexity: O(1)</li>
 * </ul>
 * </body>
 */

public class ValidPerfectSquare {
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(16));
        System.out.println(isPerfectSquare(216));
        System.out.println(isPerfectSquare(17));
        System.out.println();
        System.out.println(isPerfectSquare2(16));
        System.out.println(isPerfectSquare2(216));
        System.out.println(isPerfectSquare2(17));
        System.out.println();
        System.out.println(isPerfectSquare3(16));
        System.out.println(isPerfectSquare3(216));
        System.out.println(isPerfectSquare3(17));
    }

    public static boolean isPerfectSquare(int num) {
        int k = num, i = 1;
        while (i <= k) {
            if (num % i == 0 && num / i == i) {
                return true;
            }
            k = num / i;
            i += 1;
        }
        return false;
    }

    public static boolean isPerfectSquare2(int num) {
        if (num == 1) return true;
        long end = num, start = 2, mid, val;
        while (start <= end) {
            mid = start + (end - start) / 2;
            val = mid * mid;
            if (val == num) return true;
            else if (val < num) start = mid + 1;
            else end = mid - 1;
        }
        return false;
    }

    public static boolean isPerfectSquare3(int num) {
        // SEED METHOD
        if (num < 2) return true;
        long seed = num / 2;
        while (seed * seed > num) {
            seed = (seed + (num / seed)) / 2;
        }
        return seed * seed == num;
    }
}
