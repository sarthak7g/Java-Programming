package array;

import java.util.ArrayDeque;
import java.util.Deque;

public class StepsToMakeArrayNonDecreasing {
    public static void main(String[] args) {
        System.out.println(totalSteps(new int[]{5, 3, 4, 4, 7, 3, 6, 11, 8, 5, 11}));
        System.out.println(totalSteps(new int[]{4, 5, 7, 7, 13}));
        System.out.println(totalSteps(new int[]{7, 14, 4, 14, 13, 2, 6, 13}));
    }

    public static int totalSteps(int[] nums) {
        int ans = 0, el = -1;
        int[] dp = new int[nums.length];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addFirst(0);
        for(int i=1; i<nums.length; i++) {
            while(!stack.isEmpty() && nums[i] >= nums[stack.getFirst()]) {
                el = stack.remove();
            }
            if(!stack.isEmpty()) {
                dp[i] =  el != -1 ? dp[el] + 1 : 1;
            }
            stack.addFirst(i);
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}
