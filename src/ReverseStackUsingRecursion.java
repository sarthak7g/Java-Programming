import java.util.Stack;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://practice.geeksforgeeks.org/problems/reverse-a-stack/1/">Reverse Stack Using Recursion</a>
 * <br/>
 *  Approach:
 *      <ul>
 *          <li>Put the top element into the new result stack</li>
 *          <li>then, call recursion on it</li>
 *          <li>Time complexity: O(n)</li>
 *      </ul>
 * </body>
 */

public class ReverseStackUsingRecursion {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < 7; i++) {
            st.add(i);
        }

        Stack<Integer> ans = new Stack<>();
        System.out.println(st);
        reverseStackUsingRecursion(st, ans);
        System.out.println(ans);
    }

    static void reverseStackUsingRecursion(Stack<Integer> st, Stack<Integer> ans) {
        if(st.empty()) {
            return;
        }
        ans.add(st.pop());
        reverseStackUsingRecursion(st, ans);
    }
}
