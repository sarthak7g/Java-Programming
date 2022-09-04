package stack;

import java.util.Stack;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://practice.geeksforgeeks.org/problems/count-the-reversals0401/1">Count the reversals</a>
 * <br/>
 *  Approach:
 *      <ul>
 *          <li>When open braces push into the stack</li>
 *          <li>When close braces and stack is empty, push open brace into the stack while incrementing the count</li>
 *          <li>When close braces and stack is not empty, pop</li>
 *          <li>After iterating through the string, add increment count by half the size of stack</li>
 *          <li>Time complexity: O(n)</li>
 *          <li>Space complexity: O(n)</li>
 *      </ul>
 * </body>
 */

public class CountTheReversals {
    public static void main(String[] args) {
        System.out.println(countRev("}{{}}{{{"));
        System.out.println(countRev("{{}{{{}{{}}{{"));
        System.out.println(countRev("}}}}}}}}"));
    }
    static int countRev(String s)
    {
        if(s.length() % 2 == 1)
            return -1;

        Stack<Character> st = new Stack<>();
        int count=0, i=0;
        while(i<s.length()) {
            if(!st.empty() && s.charAt(i) == '}') {
                st.pop();
                i++;
                continue;
            }

            if(s.charAt(i) == '}')
            {
                count += 1;
            }
            st.add('{');
            i++;
        }

        count += st.size()/2;
        return count;
    }
}
