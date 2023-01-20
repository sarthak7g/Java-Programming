package array;

import java.util.Stack;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/shortest-unsorted-continuous-subarray/description/">Shortest Unsorted Continuous Subarray</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Hint: MS</li>
 *      <li>Start from RHS, check if each element can be 3 in 132 pattern.</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 */

public class ShortestUnsortedContinuousSubarray {
    public static void main(String[] args) {
        System.out.println(findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
        System.out.println(findUnsortedSubarray(new int[]{1, 2, 3, 4}));
        System.out.println(findUnsortedSubarray(new int[]{1}));
        System.out.println(findUnsortedSubarray(new int[]{1, 3, 5, 2, 4}));
    }

    public static int findUnsortedSubarray(int[] arr) {
        Stack<Integer> s = new Stack<>();
        int n = arr.length, low = n - 1, high = 0, curr = 0, min = arr[n - 1];
        for (int j = n - 1; j >= 0; j--) {
            min = Math.min(min, arr[j]);
            while (!s.empty() && arr[j] > arr[s.peek()]) {
                curr = s.pop();
            }
            high = Math.max(high, curr);
            if (arr[j] > min) low = j;
            s.push(j);
            // System.out.println(j + " " + low + " " + high);
        }
        if (s.size() == n) return 0;
        return high - low + 1;
    }
}
