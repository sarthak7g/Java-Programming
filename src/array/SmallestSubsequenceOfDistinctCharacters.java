package array;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/description/">Smallest Subsequence of Distinct Characters</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Hint: Maintain a count of all characters, a seen array and use a stack which will hold characters sorted lexicographically.</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(1)</li>
 * </ul>
 * </body>
 */

public class SmallestSubsequenceOfDistinctCharacters {
    public static void main(String[] args) {
        System.out.println(smallestSubsequence("bcabc"));
        System.out.println(smallestSubsequence("cbacdcbc"));
        System.out.println(smallestSubsequence("bcbcbcababa"));
    }

    public static String smallestSubsequence(String s) {
        Deque<Character> st = new ArrayDeque<>();
        int[] count = new int[26], seen = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a'] += 1;
        }

        char temp;
        int val;
        for (int i = 0; i < s.length(); i++) {
            val = s.charAt(i) - 'a';
            if (seen[val] == 1) {
                count[val] -= 1;
                continue;
            }
            while (!st.isEmpty() && s.charAt(i) <= st.getFirst() &&
                    count[st.getFirst() - 'a'] > 0) {
                temp = st.removeFirst();
                seen[temp - 'a'] = 0;
            }
            st.addFirst(s.charAt(i));
            seen[val] = 1;
            count[val] -= 1;
        }

        StringBuilder str = new StringBuilder();
        while (!st.isEmpty()) {
            str.append(st.removeLast());
        }
        return str.toString();
    }
}
