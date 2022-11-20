package array;

import java.util.Stack;

/**
 * <h3>Level: Medium</h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/maximum-subarray-min-product/">Maximum Subarray Min-Product</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Hint: Use stacks. Idea is to push when greater elements come and pop when smaller comes and while popping calculate ans. Try pushing indexes instead of integers.</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(1)</li>
 * </ul>
 */

public class MaximumSubarrayMinProduct {
    public static void main(String[] args) {
        System.out.println(maxSumMinProduct(new int[] {3,1,5,6,4,2}));
        System.out.println(maxSumMinProduct(new int[] {3,7,3,1,4,2,3,1,6}));
    }

    public static int maxSumMinProduct(int[] nums) {
        int n=nums.length, top;
        long ans=0, temp;
        Stack<Integer> st = new Stack<>();

        long[] sum = new long[n+1];
        for(int i=0; i<n; i++) {
            sum[i+1] = sum[i] + nums[i];
        }

        for(int i=0; i<n; i++) {
            while(!st.isEmpty() && nums[i] <= nums[st.peek()]) {
                top = nums[st.pop()];
                temp = st.isEmpty() ? 0 : sum[st.peek()+1];
                ans = Math.max(ans, top * (sum[i]-temp));
            }
            st.push(i);
        }

        while(!st.isEmpty()) {
            top = nums[st.pop()];
            temp = st.isEmpty() ? 0 : sum[st.peek()+1];
            ans = Math.max(ans, top * (sum[n]-temp));
        }

        return (int)(ans % 1000000007);
    }
}
