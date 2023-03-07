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
 * </body>
 */

public class ValidPerfectSquare {
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(16));
        System.out.println(isPerfectSquare(216));
        System.out.println(isPerfectSquare(17));
    }

    public static boolean isPerfectSquare(int num) {
        int k=num, i=1;
        while(i<=k) {
            if(num%i == 0 && num/i == i) {
                return true;
            }
            k = num/i;
            i += 1;
        }
        return false;
    }
}
