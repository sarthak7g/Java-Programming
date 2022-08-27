package stack;

import java.util.Stack;

/**
 * <h3>Level: Easy </h3>
 * <body>
 * refer to: <a href="https://practice.geeksforgeeks.org/problems/parenthesis-checker2744/1">Parenthesis Checker</a>
 * <br/>
 *  Approach:
 *      <ul>
 *          <li>Push into stack when open braces else pop when matching closed braces is found</li>
 *          <li>Time complexity: O(n)</li>
 *          <li>Space complexity: O(n)</li>
 *      </ul>
 * </body>
 */

public class BalanceParenthesis {
    public static void main(String[] args) {
        System.out.println(ispar("{([])}"));
    }
    static boolean ispar(String str)
    {
        char[] arr = str.toCharArray();
        Stack<Character> st = new Stack<>();
        for(char x : arr) {
            if(x == '(' || x == '{' || x == '[') {
                st.push(x);
            }
            else if(!st.empty() && (x == ']') && (st.peek() == '[')) {
                st.pop();
            }
            else if(!st.empty() && (x == '}') && (st.peek() == '{')) {
                st.pop();
            }
            else if(!st.empty() && (x == ')') && (st.peek() == '(')) {
                st.pop();
            }
            else return false;
        }
        return st.empty();
    }
}
