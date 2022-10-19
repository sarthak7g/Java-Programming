package array;

import java.util.ArrayList;
import java.util.List;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/max-consecutive-ones-iii/">Max Consecutive Ones III</a>
 * <br/>
 * <br/>
 * <b>Approach 1:</b>
 * <ul>
 *      <li>Use sliding window with two pointers, left and right. In a window you can have maximum of k zeros according to that we shift left and right.</li>
 *      <li>Use an array to record index of zeros and everytime window>k, shift left to next index having zero.</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(k)</li>
 * </ul>
 * <b>Approach 2:</b>
 * <ul>
 *      <li>Same approach instead of using array we will linearly increment left until next zero is found.</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(1)</li>
 * </ul>
 */

public class MaxConsecutiveOnesIII {

    public static void main(String[] args) {
        System.out.println(longestOnes(new int[] {1,1,1,0,0,0,1,1,1,1}, 2));
        System.out.println(longestOnes(new int[] {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 2));
        System.out.println(longestOnes(new int[] {0,0,0,1}, 4));
        System.out.println(longestOnes2(new int[] {1,1,1,0,0,0,1,1,1,1}, 2));
        System.out.println(longestOnes2(new int[] {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 2));
        System.out.println(longestOnes2(new int[] {0,0,0,1}, 4));
    }
    public static int longestOnes(int[] nums, int k) {

        int left=-1, right=0, ans=0, window=0, t=0;
        List<Integer> al = new ArrayList<>();
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 1) {
                ans = Math.max(ans, right-left);
                right += 1;
                continue;
            }

            al.add(i);

            if(window < k) {
                window += 1;
            }

            else {
                left = al.get(t++);
            }

            ans = Math.max(ans, right-left);
            right += 1;

        }

        return ans;
    }

    public static int longestOnes2(int[] nums, int k) {
        int left=-1, right=0, ans=0, window=0;

        for (int num : nums) {
            if (num == 1) {
                ans = Math.max(ans, right - left);
                right += 1;
                continue;
            }

            if (window < k) {
                window += 1;
            } else while (nums[++left] == 1) ;

            ans = Math.max(ans, right - left);
            right += 1;

        }


        return ans;
    }
}
