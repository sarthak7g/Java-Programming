package array;

/**
 * <h3>Level: Easy </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/three-divisors/description/">Three Divisors</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Time complexity: O(log n)</li>
 *      <li>Space complexity: O(1)</li>
 * </ul>
 * </body>
 */

public class ThreeDivisors {
    public static void main(String[] args) {
        System.out.println(isThree(2));
        System.out.println(isThree(81));
        System.out.println(isThree(9));
        System.out.println(isThree(11));
    }

    public static boolean isThree(int n) {

        boolean flag = false;
        int k = n;
        for (int i = 2; i < k; i++) {
            k = n / i;
            if (n % i == 0 && k == i) {
                flag = true;
            } else if (n % i == 0) return false;
        }

        return flag;
    }
}
