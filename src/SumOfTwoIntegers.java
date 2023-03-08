/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/sum-of-two-integers/description/">Sum of Two Integers</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Hint: Convert to bits and then XOR with carry.</li>
 *      <li>Time complexity: O(log(n))</li>
 *      <li>Space complexity: O(log(n))</li>
 * </ul>
 * </body>
 */

public class SumOfTwoIntegers {
    public static void main(String[] args) {
        System.out.println(getSum(1, 2));
        System.out.println(getSum(2, 3));
        System.out.println(getSum(17, 13));
        System.out.println(getSum(15, 5));
    }

    public static int getSum(int a, int b) {
        StringBuilder s1 = convertToBits(a), s2 = convertToBits(b), temp, res = new StringBuilder();
        // System.out.println(s1 + " " + s2);
        if (s1.length() < s2.length()) {
            temp = s1;
            s1 = s2;
            s2 = temp;
        }
        int i = 0, j = 0, c1, c2, carry = 0, ans = 0;
        while (i < s1.length() && j < s2.length()) {
            c1 = s1.charAt(i) == '0' ? 0 : 1;
            c2 = s2.charAt(j) == '0' ? 0 : 1;
            res.append(c1 ^ c2 ^ carry);
            if ((c1 == c2 && c1 == 1) || (c1 == carry && c1 == 1) || (c2 == carry && c2 == 1)) {
                carry = 1;
            } else carry = 0;
            i += 1;
            j += 1;
        }
        while (i < s1.length()) {
            c1 = s1.charAt(i) == '0' ? 0 : 1;
            res.append(c1 ^ carry);
            if (c1 != carry) {
                carry = 0;
            }
            i++;
        }
        if (carry == 1) res.append(1);
        // System.out.println(res);
        for (int k = res.length() - 1; k >= 0; k--) {
            c1 = res.charAt(k) == '0' ? 0 : 1;
            ans = ans * 2 + c1;
        }

        return ans;
    }

    public static StringBuilder convertToBits(int n) {
        StringBuilder str = new StringBuilder();
        while (n > 0) {
            str.append(n % 2);
            n /= 2;
        }
        return str;
    }
}
