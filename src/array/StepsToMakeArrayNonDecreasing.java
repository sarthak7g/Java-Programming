package array;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <h3>Level: Easy </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/steps-to-make-array-non-decreasing/description/">Steps to Make Array Non-decreasing</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Refer <a href="https://leetcode.com/problems/steps-to-make-array-non-decreasing/solutions/2085967/python-explanation-with-pictures-stack/">solution</a></li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 * </body>
 */

public class StepsToMakeArrayNonDecreasing {
    public static void main(String[] args) {
        System.out.println(totalSteps(new int[]{5, 3, 4, 4, 7, 3, 6, 11, 8, 5, 11}));
        System.out.println(totalSteps(new int[]{4, 5, 7, 7, 13}));
        System.out.println(totalSteps(new int[]{7, 14, 4, 14, 13, 2, 6, 13}));
    }

    public static int totalSteps(int[] nums) {
        int ans = 0, el;
        int[] dp = new int[nums.length];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addFirst(0);
        for(int i=1; i<nums.length; i++) {
            while(!stack.isEmpty() && nums[i] >= nums[stack.getFirst()]) {
                el = stack.remove();
                dp[i] = Math.max(dp[i], dp[el]+1);
            }
            if(stack.isEmpty()) dp[i] = 0;
            else if(nums[i] < nums[i-1]) {
                dp[i] = 1;
            }
            stack.addFirst(i);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
