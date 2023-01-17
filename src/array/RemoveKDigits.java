package array;

import java.util.Stack;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/remove-k-digits/description/">Remove K Digits</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Hint: Monotonic Stack</li>
 *      <li>Insert from the start, remove the stack top when stack[top]>nums[i].</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 * </body>
 */

public class RemoveKDigits {
    public static void main(String[] args) {
        System.out.println(removeKdigits("1432219", 3));
        System.out.println(removeKdigits("10200", 1));
        System.out.println(removeKdigits("10", 2));
    }

    public static String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        for(int i=0; i<num.length(); i++) {
            while(!st.empty() && st.peek()>num.charAt(i) && k>0) {
                st.pop();
                k--;
            }
            if(st.empty() && num.charAt(i)=='0') continue;
            st.push(num.charAt(i));
        }
        char tmp;
        StringBuilder str = new StringBuilder();
        while(!st.empty()) {
            tmp = st.pop();
            if(k>0) {
                k--;
            } else {
                str.append(tmp);
            }
        }

        if(str.length()==0) return "0";
        return str.reverse().toString();
    }
}
