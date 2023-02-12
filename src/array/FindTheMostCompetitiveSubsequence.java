package array;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * <h3>Level: Medium</h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/find-the-most-competitive-subsequence/description/">Find the Most Competitive Subsequence</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Hint: Try to get the smallest value at left-most index while considering the number of elements left in an array before popping the greater element from the stack.</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 * </body>
 */

public class FindTheMostCompetitiveSubsequence {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(mostCompetitive(new int[]{3, 5, 2, 6}, 2)));
        System.out.println(Arrays.toString(mostCompetitive(new int[]{2, 4, 3, 3, 5, 4, 9, 6}, 4)));
        System.out.println(Arrays.toString(mostCompetitive(new int[]{5, 4, 9, 6, 2, 4, 3}, 4)));
    }

    public static int[] mostCompetitive(int[] nums, int k) {
        int[] ans = new int[k];
        int n = nums.length, j = k - 1;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && k - stack.size() < n - i && nums[i] < stack.getFirst()) {
                stack.remove();
            }
            if (stack.size() < k)
                stack.addFirst(nums[i]);
        }
        while (!stack.isEmpty()) {
            ans[j--] = stack.remove();
        }
        return ans;
    }
}
