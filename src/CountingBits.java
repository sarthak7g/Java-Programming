import java.util.Arrays;

/**
 * <h3>Level: Easy </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/counting-bits/description/">Counting Bits</a>
 * <br/>
 * <br/>
 * <b>Approach 1:</b>
 * <ul>
 *      <li>Hint: For each value in n, divide it by 2^32 until 2^0 to get the answer. Total 32 iterations.</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(1)</li>
 * </ul>
 * </body>
 */

public class CountingBits {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(2)));
        System.out.println(Arrays.toString(countBits(5)));
        System.out.println(Arrays.toString(countBits(34)));
    }

    public static int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = n; i >= 0; i--) {
            ans[i] = ones(i);
        }
        return ans;
    }

    public static int ones(int n) {
        if (n == 0 || n == 1) return n;
        int pow = 31, ans = 0, div;
        while (pow >= 0) {
            div = (int) Math.pow(2, pow);
            ans += n / div;
            n %= div;
            pow -= 1;
        }
        return ans;
    }
}
