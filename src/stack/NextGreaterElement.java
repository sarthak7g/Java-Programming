package stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://practice.geeksforgeeks.org/problems/next-larger-element-1587115620/1/">Next Greater Element</a>
 * <br/>
 *  Approach:
 *      <ul>
 *          <li>Start traversing from the last</li>
 *          <li>Push when the current element is smaller than the stack top</li>
 *          <li>Pop all the elements from the stack until the current element becomes smaller than stack top</li>
 *          <li>Time complexity: O(n)</li>
 *          <li>Space complexity: O(n)</li>
 *      </ul>
 * </body>
 */

public class NextGreaterElement {

    public static void main(String[] args) {
        long [] ans = nextLargerElement(new long[]{12, 12, 12, 12, 1, 2, 3, 10, 19}, 9);
        System.out.println(Arrays.toString(ans));
    }

    public static long[] nextLargerElement(long[] arr, int n)
    {
        Stack<Integer> st = new Stack<>();
        st.push(0);


        for(int i=1; i<n; i++) {
            while(st.size()>0 && arr[st.peek()] < arr[i]) {
                arr[st.pop()] = arr[i];
            }
            st.push(i);
        }

        while(st.size()>0){
            arr[st.pop()] = -1;
        }
        return arr;
    }
}
