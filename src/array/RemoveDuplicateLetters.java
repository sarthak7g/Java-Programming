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
 *      <li>Hint: Monotonic Stack</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(1)</li>
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
        char c;

        for (int i = s.length() - 1; i >= 0; i--) {
            c = s.charAt(i);
            if (!seen.contains(c) || c < stack.peek()) {
                stack.push(c);
                seen.add(c);
            }
        }

        StringBuilder ans = new StringBuilder();
        while (!stack.empty()) {
            c = stack.pop();
            if (seen.contains(c)) {
                ans.append(c);
                seen.remove(c);
            }
        }
        return ans.toString();
    }
}
