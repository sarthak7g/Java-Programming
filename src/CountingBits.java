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
 * <b>Approach 2:</b>
 * <ul>
 *      <li>Dp + MSB. Refer <a href="https://leetcode.com/problems/counting-bits/submissions/919010797/">solution</a></li>
 *      <li>Intuition: For each i in n, find the MSB(1) of i and then use already computed answer to get ans[i].</li>
 *      <li>Example: for i=13, MSB is 3. So, the ans[i] = ans[i-2^3] + 1.</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(1)</li>
 * </ul>
 * <b>Approach 3:</b>
 * <ul>
 *      <li>Dp + LSB. Refer <a href="https://leetcode.com/problems/counting-bits/submissions/919010797/">solution</a></li>
 *      <li>ans[i] = ans[i/2] + i%2.</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(1)</li>
 * </ul>
 * <b>Approach 4:</b>
 * <ul>
 *      <li>Dp + Last Set Bit. Refer <a href="https://leetcode.com/problems/counting-bits/submissions/919010797/">solution</a></li>
 *      <li>ans[i] = ans[i&(i-1)] + 1. Example for i=15: ans[15] = ans[14] + 1, and for i=16: ans[16] = ans[0] + 1.</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(1)</li>
 * </ul>
 * </body>
 */

public class CountingBits {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(2)));
        System.out.println(Arrays.toString(countBits2(2)));
        System.out.println(Arrays.toString(countBits3(2)));
        System.out.println(Arrays.toString(countBits4(2)));
        System.out.println(Arrays.toString(countBits(5)));
        System.out.println(Arrays.toString(countBits2(5)));
        System.out.println(Arrays.toString(countBits3(5)));
        System.out.println(Arrays.toString(countBits4(5)));
        System.out.println(Arrays.toString(countBits(34)));
        System.out.println(Arrays.toString(countBits2(34)));
        System.out.println(Arrays.toString(countBits3(34)));
        System.out.println(Arrays.toString(countBits4(34)));
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

    public static int[] countBits2(int n) {
        int[] ans = new int[n + 1];
        if (n == 0) return ans;
        int j = 1, temp, prev;
        ans[1] = 1;
        for (int i = 2; i <= n; i++) {
            temp = (int) Math.pow(2, j);
            if (i == temp) {
                j += 1;
                ans[i] = 1;
            } else {
                prev = temp / 2;
                ans[i] = ans[i - prev] + 1;
            }
        }
        return ans;
    }

    public static int[] countBits3(int n) {
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i / 2] + i % 2;
        }
        return ans;
    }

    public static int[] countBits4(int n) {
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i & (i - 1)] + 1;
        }
        return ans;
    }

}
