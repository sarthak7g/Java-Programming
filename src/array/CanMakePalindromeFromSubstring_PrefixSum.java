package array;

import java.util.ArrayList;
import java.util.List;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/can-make-palindrome-from-substring/">Can Make Palindrome from Substring</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 *      <ul>
 *          <li>Intuition is that for any given range, number of characters of odd frequencies divide by 2 should be less than or equal to query[2].</li>
 *          <li>Therefore, for each query we need to know how many characters of odd frequencies we have between substring s[qr[0]...qr[1]].</li>
 *          <li>To do this we must store the frequencies of each character at each index of a string, (total 26 chars) so we will use an array of 26 integers.</li>
 *          <li>Time complexity: O(n * 26)</li>
 *          <li>Space complexity: O(n * 26)</li>
 *      </ul>
 */

public class CanMakePalindromeFromSubstring_PrefixSum {
    public static void main(String[] args) {
        System.out.println(canMakePaliQueries("abcda", new int[][]{{3, 3, 0}, {1, 2, 0}, {0, 3, 1}, {0, 3, 2}, {0, 4, 1}}));
        System.out.println(canMakePaliQueries("abbebabbccda", new int[][]{{3, 5, 1}, {1, 4, 0}, {0, 3, 1}, {0, 5, 2}, {3, 7, 1}, {2, 8, 3}}));
    }

    public static List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int[][] arr = new int[s.length()][26];
        List<Boolean> ans = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (i > 0) arr[i] = arr[i - 1].clone();
            arr[i][s.charAt(i) - 'a']++;
        }

        for (int[] qr : queries) {
            int sum = 0;
            for (int i = 0; i < 26; i++) {
                sum += qr[0] > 0 ? (arr[qr[1]][i] - arr[qr[0] - 1][i]) % 2 : arr[qr[1]][i] % 2;
            }

            ans.add(sum / 2 <= qr[2]);
        }

        return ans;
    }

}
