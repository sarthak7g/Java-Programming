package array;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * refer to: <a href="https://leetcode.com/problems/sum-of-subarray-ranges/description/">Sum of Subarray Ranges</a>
 * <h3>Level: Medium</h3>
 * <body>
 * <br/>
 * <br/>
 * <b>Approach 1:</b>
 * <ul>
 *      <li>Hint: Element's contribution approach. 4 loops. Refer {@link SumOfSubarrayMinimums}</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 * <b>Approach 2:</b>
 * <ul>
 *      <li>Similar to 1st approach. But in this case we will use 2 loops from 0 to n.</li>
 *      <li>Idea is that when we insert an element the top of stack is left_boundary and when we pop an element the curr element will become the right_boundary for a popped element.</li>
 *      <li>All we needed is to find the left and the right boundary where an element is smaller and larger.</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 * </body>
 */

public class SumOfSubarrayRanges {
    public static void main(String[] args) {
        System.out.println(subArrayRanges(new int[]{1, 2, 3}));
        System.out.println(subArrayRanges(new int[]{1, 3, 3}));
        System.out.println(subArrayRanges(new int[]{4, -2, -3, 4, 1}));
        System.out.println();
        System.out.println(subArrayRanges2(new int[]{1, 2, 3}));
        System.out.println(subArrayRanges2(new int[]{1, 3, 3}));
        System.out.println(subArrayRanges2(new int[]{4, -2, -3, 4, 1}));
    }

    public static long subArrayRanges(int[] arr) {
        // Element's contribution approach
        int n = arr.length, val;
        long sum = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        // Next smaller element
        int[] temp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.getFirst()]) {
                stack.remove();
            }
            if (stack.isEmpty()) {
                temp[i] = n;
            } else temp[i] = stack.getFirst();
            stack.addFirst(i);
        }

        stack.clear();
        // Previous smaller element
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.getFirst()]) {
                stack.remove();
            }
            if (stack.isEmpty()) {
                val = (i + 1) * (temp[i] - i);
            } else {
                val = (i - stack.getFirst()) * (temp[i] - i);
            }
            sum -= (arr[i] * (long) val);
            stack.addFirst(i);
        }

        stack.clear();
        // Next Larger element
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] >= arr[stack.getFirst()]) {
                stack.remove();
            }
            if (stack.isEmpty()) {
                temp[i] = n;
            } else temp[i] = stack.getFirst();
            stack.addFirst(i);
        }

        stack.clear();
        // Previous larger element
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] > arr[stack.getFirst()]) {
                stack.remove();
            }
            if (stack.isEmpty()) {
                val = (i + 1) * (temp[i] - i);
            } else {
                val = (i - stack.getFirst()) * (temp[i] - i);
            }
            sum += (arr[i] * (long) val);
            stack.addFirst(i);
        }

        return sum;
    }

    public static long subArrayRanges2(int[] arr) {
        // Element's contribution approach
        int n = arr.length, el;
        long sum = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] temp = new int[n];

        // As a smaller element
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.getFirst()]) {
                el = stack.remove();
                sum -= ((el - temp[el]) * (i - el) * (long) arr[el]);
            }
            if (stack.isEmpty()) {
                temp[i] = -1;
            } else {
                temp[i] = stack.getFirst();
            }
            stack.addFirst(i);
        }
        while (!stack.isEmpty()) {
            el = stack.remove();
            sum -= ((el - temp[el]) * (n - el) * (long) arr[el]);
        }

        // As a larger element
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] >= arr[stack.getFirst()]) {
                el = stack.remove();
                sum += ((el - temp[el]) * (i - el) * (long) arr[el]);
            }
            if (stack.isEmpty()) {
                temp[i] = -1;
            } else {
                temp[i] = stack.getFirst();
            }
            stack.addFirst(i);
        }
        while (!stack.isEmpty()) {
            el = stack.remove();
            sum += ((el - temp[el]) * (n - el) * (long) arr[el]);
        }

        return sum;
    }
}
