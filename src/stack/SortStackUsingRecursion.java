package stack;

import java.util.Stack;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://practice.geeksforgeeks.org/problems/sort-a-stack/1">Sort Stack Using Recursion</a>
 * <br/>
 *  Approach:
 *      <ul>
 *          <li>recursively call the sort function while popping the top element of stack</li>
 *          <li>and when the stack is empty, start inserting the element in the stack</li>
 *          <li>Now, to insert-at-element use another recursive function, which will check the right place to insert it</li>
 *          <li>Time complexity: O(n^2)</li>
 *          <li>Auxiliary Space: O(n)</li>
 *      </ul>
 * </body>
 */

public class SortStackUsingRecursion {
    public static void main(String[] args) {

        Stack<Integer> st = new Stack<>();
        st.push(9);
        st.push(8);
        st.push(1);
        st.push(5);
        st.push(4);
        System.out.println(st);
        sort(st);
        System.out.println(st);

    }

    private static void sort(Stack<Integer> st) {
        if(st.empty()) {
            return;
        }
        int el = st.pop();
        sort(st);
        insert(st, el);

    }

    private static void insert(Stack<Integer> st, int el) {
        if(!st.empty() && st.peek()<el) {
            int val = st.pop();
            insert(st, el);
            st.push(val);
        }else {
            st.push(el);
        }
    }

}
