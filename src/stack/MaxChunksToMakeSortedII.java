package stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <h3>Level: Hard </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/max-chunks-to-make-sorted-ii/description/">Max Chunks To Make Sorted II</a>
 * <br/>
 * <br/>
 * <b>Approach 1:</b>
 * <ul>
 *      <li>Hint: MS and max variable. Whenever arr[i] is lower than stack top pop it, and at last insert the max.</li>
 *      <li>In the end the stack will have max value for all chunks and the size will be the answer.</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 * </body>
 */

public class MaxChunksToMakeSortedII {
    public static void main(String[] args) {
        System.out.println(maxChunksToSorted(new int[]{5, 4, 3, 2, 1}));
        System.out.println(maxChunksToSorted(new int[]{2, 1, 3, 4, 4}));
        System.out.println(maxChunksToSorted(new int[]{5, 3, 2, 2, 4, 7, 8, 6}));
        System.out.println(maxChunksToSorted(new int[]{2, 1, 1, 3, 2, 2, 3, 8, 5, 5, 4}));
    }

    public static int maxChunksToSorted(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        int max = 0;
        for (int j : arr) {
            max = Math.max(max, j);
            while (!stack.isEmpty() && j < stack.getFirst()) stack.remove();
            stack.addFirst(max);
        }
        return stack.size();
    }
}
