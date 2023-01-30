package array;

import java.util.ArrayList;
import java.util.List;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/maximum-width-ramp/">Maximum Width Ramp</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Hint: Use an array list to store decreasing integer values and traverse backwards linearly.</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 * </body>
 */
public class MaximumWidthRamp {
    public static void main(String[] args) {
        System.out.println(maxWidthRamp(new int[]{6, 0, 8, 2, 1, 5}));
        System.out.println(maxWidthRamp(new int[]{9, 8, 1, 0, 1, 9, 4, 0, 4, 1}));
        System.out.println(maxWidthRamp(new int[]{1, 2, 1}));
    }

    public static int maxWidthRamp(int[] nums) {
        int n = nums.length, max = nums[0], ans = 0, curr;
        List<Integer> l = new ArrayList<>();
        l.add(0);
        for (int i = 1; i < n; i++) {
            if (nums[i] >= max) {
                max = nums[i];
                ans = Math.max(i, ans);
                continue;
            }
            curr = l.size() - 1;
            if (nums[i] < nums[l.get(curr)]) {
                l.add(i);
                continue;
            }
            while (curr >= 0 && nums[i] >= nums[l.get(curr)]) {
                curr--;
            }
            curr += 1;
            ans = Math.max(i - l.get(curr), ans);
        }

        return ans;
    }


}
