package stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * <h3>Level: Hard </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/number-of-visible-people-in-a-queue/description/">Number of Visible People in a Queue</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>MS: Traverse from back and maintain a non-increasing stack. The number of stack elements each element in an array can pop will give the answer.</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 * </body>
 */

public class NumberOfVisiblePeopleInQueue {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(canSeePersonsCount(new int[]{10, 6, 8, 5, 11, 9})));
        System.out.println(Arrays.toString(canSeePersonsCount(new int[]{5, 1, 2, 3, 10})));
    }

    public static int[] canSeePersonsCount(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.add(arr[n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] > stack.getFirst()) {
                ans[i] += 1;
                stack.remove();
            }
            ans[i] = stack.isEmpty() ? ans[i] : ans[i] + 1;
            stack.addFirst(arr[i]);
        }
        return ans;
    }
}
