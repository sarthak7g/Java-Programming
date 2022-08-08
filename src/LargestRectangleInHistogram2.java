import java.util.Stack;

/**
 * <h3>Level: Hard </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/largest-rectangle-in-histogram/">Largest Rectangle in Histogram</a>
 * <br/>
 * Approach 2:
 *      <ul>
 *          <li>Our purpose is to find the maximum rectangle area with each bar as a smallest bar.</li>
 *          <li>Use stack to store the indexes of elements of array</li>
 *          <li>Whenever a bar smaller than stack top comes, pop() and find the max area for the stack top, i.e., </li>
 *          <li>max = Math.max((i-1 - elem_just_smaller_than_stack_top) * arr[stack[top]], max)</li>
 *      </ul>
 * <br/>
 * Time complexity: O(n)
 * Space complexity: O(n)
 * </body>
 */

public class LargestRectangleInHistogram2 {
    public static void main(String[] args) {
        int arr[] = {6, 2, 5, 4, 5, 1, 6};
        System.out.println(largestRectangleArea(arr));
    }

    public static int largestRectangleArea(int[] arr) {
        Stack<Integer> st = new Stack();
        int i = 0, max = 0, currIndex, prevIndex;
        while (i <= arr.length) {
            while (!st.isEmpty() && (i == arr.length || arr[i] < arr[st.peek()])) {
                currIndex = st.pop();
                prevIndex = st.isEmpty() ? -1 : st.peek();
                max = Math.max(arr[currIndex] * (i - 1 - prevIndex), max);
            }
            st.push(i);
            i++;
        }

        return max;

    }
}
