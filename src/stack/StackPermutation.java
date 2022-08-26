package stack;

import java.util.Stack;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://practice.geeksforgeeks.org/problems/stack-permutations/1">Stack Permutation</a>
 * <br/>
 *  Approach:
 *      <ul>
 *          <li>Use stack to push the element when not equal</li>
 *          <li>Time complexity: O(n)</li>
 *          <li>Auxiliary Space: O(n)</li>
 *      </ul>
 * </body>
 */

public class StackPermutation {
    public static void main(String[] args) {
        int[] arr1 = {8, 81, 35, 65, 91};
        int[] arr2 = {81, 65, 35, 8, 91};
//
//        int[] arr1 = {2, 4, 3, 1};
//        int[] arr2 = {4, 3, 1, 2};

//        int[] arr1 = {2, 3};
//        int[] arr2 = {15, 2};

        System.out.println(isStackPermutation(arr1.length, arr1, arr2));
    }

    public static int isStackPermutation(int n, int[] ip, int[] op) {
        Stack<Integer> st = new Stack<>();
        int i=0, j=0, el;
        while(i<n && j<n) {
            if(!st.empty() && st.peek()==op[j]) {
                st.pop();
                j++;
            } else {
                while(i<n && op[j] != ip[i]) {
                    st.push(ip[i]);
                    i++;
                }
                if(i!=n) {
                    i++;
                    j++;
                }

            }

        }
        while(j<n && !st.empty()) {
            el = st.pop();
            if(op[j] == el) {
                j++;
            }
        }
        if(j<op.length || !st.empty()) return 0;
        return 1;
    }
}
