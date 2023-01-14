package array;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/remove-duplicate-letters/">Remove Duplicate Letters</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Hint: Monotonic Stack, refer <a href="https://leetcode.com/problems/remove-duplicate-letters/solutions/362468/remove-duplicate-letters/">solution</a></li>
 *      <li>Intuition: At the most significant point you should be having the smallest letter</li>
 *      <li>So, you delete a character from stack top if</li>
 *      <ul>
 *          <li>it is greater than curr character and</li>
 *          <li>it occurs later in the string</li>
 *      </ul>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 * </body>
 */

public class RemoveDuplicateLetters {
    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("bcabc"));
        System.out.println(removeDuplicateLetters("cbacdcbc"));
        System.out.println(removeDuplicateLetters("bcac"));
        System.out.println(removeDuplicateLetters("abacb"));
    }

    public static String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        Set<Character> seen = new HashSet<>();
        char c, temp;
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            count[c - 'a'] += 1;
        }

        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            count[c - 'a'] -= 1;
            if (!seen.contains(c)) {
                while (!stack.empty() && stack.peek() > c &&
                        count[stack.peek() - 'a'] != 0) {
                    temp = stack.pop();
                    seen.remove(temp);
                }
                stack.push(c);
                seen.add(c);
            }
        }

        StringBuilder ans = new StringBuilder();
        while (!stack.empty()) {
            c = stack.pop();
            ans.append(c);
        }
        return ans.reverse().toString();
    }
}
