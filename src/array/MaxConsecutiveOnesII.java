package array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <h3>Level: Medium </h3>
 * <h4>LC PREMIUM</h4>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/max-consecutive-ones-ii/">Max Consecutive Ones II</a>
 * <br/>
 * <br/>
 * <b>Question:</b>
 * <ul>
 *     <li>Given a binary array nums, return the maximum number of consecutive 1's in the array if you can flip at most one 0.</li>
 * </ul>
 *
 * <b>Example:</b>
 * <ul>
 *      <li><b>Input:</b> nums = [1,0,1,1,0]</li>
 *      <li><b>Output:</b> 4</li>
 *      <li><b>Explanation:</b> If we flip the first zero, nums becomes [1,1,1,1,0] and we have 4 consecutive ones.</li>
 * </ul>
 *
 * <b>Approach:</b>
 * <ul>
 *      <li>We will maintain a queue and add prefix sum to the queue when an element is zero.</li>
 *      <li>Now, find a diff b/w every two elements leaving one element in between(ex- 1-3, 2-4, 3-5,..so on) in the queuel.</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 */

public class MaxConsecutiveOnesII {
    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[] {1,1,1,1}));
        System.out.println(findMaxConsecutiveOnes(new int[] {0,0,0,0,0}));
        System.out.println(findMaxConsecutiveOnes(new int[] {0,0,1,1,0,0,1,0,1,1,0,1,0}));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int ans=0, sum=0;
        Queue<Integer> q = new LinkedList<>();

        for(int val : nums) {
            if(val == 0) {
                q.add(sum);
            }
            else sum += val;
        }

        if(q.size() == 0) return sum;

        int start=0, end;
        int next = q.remove();
        while(q.size() > 0) {
            end = q.remove();
            ans = Math.max(ans, end-start+1);
            start = next;
            next = end;
        }

        ans = Math.max(ans, sum-start+1);
        return ans;

    }
}
