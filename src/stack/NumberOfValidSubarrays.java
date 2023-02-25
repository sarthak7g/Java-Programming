package stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <h3>Level: Hard </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/number-of-valid-subarrays/description/">Number of Valid Subarrays</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Hint: Non-decreasing MS</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 * </body>
 */

public class NumberOfValidSubarrays {
    public static void main(String[] args) {
        System.out.println(validSubarrays(new int[]{1, 4, 2, 5, 3}));
        System.out.println(validSubarrays(new int[]{3, 2, 1}));
        System.out.println(validSubarrays(new int[]{2, 2, 2}));
    }

    public static int validSubarrays(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = nums.length, ans = 0;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[i] < nums[stack.getFirst()]) {
                ans += i - stack.remove();
            }
            stack.addFirst(i);
        }
        while (!stack.isEmpty()) {
            ans += n - stack.remove();
        }
        return ans;
    }
}
