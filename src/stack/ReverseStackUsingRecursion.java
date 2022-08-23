package stack;

import java.util.Stack;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://practice.geeksforgeeks.org/problems/reverse-a-stack/1/">Reverse Stack Using Recursion</a>
 * <br/>
 *  Approach:
 *      <ul>
 *          <li>recursively call the reverse function while popping the top element of stack</li>
 *          <li>and when the stack is empty, start inserting the element at the bottom of stack</li>
 *          <li>Now, to insert-at-bottom use another recursive function</li>
 *          <li>Time complexity: O(n^2)</li>
 *          <li>Auxiliary Space: O(n)</li>
 *      </ul>
 * </body>
 */

public class ReverseStackUsingRecursion {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < 5; i++) {
            st.add(i);
        }
        System.out.println(st);
        reverseStackUsingRecursion(st);
        System.out.println(st);
    }

    static void reverseStackUsingRecursion(Stack<Integer> st) {
        if(st.empty()) {
            return;
        }
        int val = st.pop();
        reverseStackUsingRecursion(st);
        insert_at_bottom(st, val);
    }

    private static void insert_at_bottom(Stack<Integer> st, int val) {
        if(st.empty()) {
            st.push(val);
            return;
        }
        int top = st.pop();
        insert_at_bottom(st, val);
        st.push(top);
    }
}
