package array;

import java.util.Arrays;
import java.util.Stack;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/next-greater-element-ii/description/">Next Greater Element II</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Hint: Monotonic Stack (double pass)</li>
 *      <li>Insert backwards from n-1th till 0th index into stack, then start from n-1th index again.</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 * </body>
 */

public class NextGreaterElementII {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1, 2, 1})));
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1, 2, 3, 4, 3})));
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1, 2, 3, 4, 5, 6, 5, 4, 5, 1, 2, 3})));
    }

    public static int[] nextGreaterElements(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.empty() && arr[i] >= arr[stack.peek()]) {
                stack.pop();
            }
            if (!stack.empty()) ans[i] = arr[stack.peek()];
            stack.push(i);
        }

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.empty() && stack.peek() != i && arr[i] >= arr[stack.peek()])
                stack.pop();
            if (!stack.empty() && stack.peek() != i) {
                ans[i] = arr[stack.peek()];
            } else {
                ans[i] = -1;
            }
            stack.push(i);

        }
        return ans;
    }
}
