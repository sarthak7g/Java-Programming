package array;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/shifting-letters-ii/description/">Shifting Letters II</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Hint: Range addition approach</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 * </body>
 */

public class ShiftingLettersII {
    public static void main(String[] args) {
        System.out.println(shiftingLetters("abc", new int[][]{{0, 1, 0}, {1, 2, 1}, {0, 2, 1}}));
        System.out.println(shiftingLetters("dztz", new int[][]{{0, 0, 0}, {1, 1, 1}}));
    }

    public static String shiftingLetters(String s, int[][] shifts) {
        int n = s.length(), sum = 0, pos;
        int[] arr = new int[n + 1];
        StringBuilder str = new StringBuilder();

        for (int[] m : shifts) {
            if (m[2] == 0) {
                arr[m[0]] -= 1;
                arr[m[1] + 1] += 1;
            } else {
                arr[m[0]] += 1;
                arr[m[1] + 1] -= 1;
            }
        }

        for (int i = 0; i < n; i++) {
            sum = (sum + arr[i]) % 26;

            pos = (s.charAt(i) - 'a' + sum + 26) % 26;
            pos += 97;
            str.append((char) pos);
        }

        return str.toString();
    }
}
