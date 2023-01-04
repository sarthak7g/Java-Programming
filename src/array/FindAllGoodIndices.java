package array;

import java.util.ArrayList;
import java.util.List;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/find-all-good-indices/description/">Find All Good Indices</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Hint: Two prefix array with sum</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 * </body>
 */

public class FindAllGoodIndices {
    public static void main(String[] args) {
        System.out.println(goodIndices(new int[]{2, 1, 1, 2}, 2));
        System.out.println(goodIndices(new int[]{2, 1, 1, 1, 3, 4, 4, 1}, 2));
        System.out.println(goodIndices(new int[]{2, 1, 1, 1, 3, 4, 4, 1}, 1));
        System.out.println(goodIndices(new int[]{2, 1, 1, 1, 3, 4, 4, 1}, 3));
    }

    public static List<Integer> goodIndices(int[] nums, int k) {
        int n = nums.length, temp = k, left, right;
        int[] down = new int[n], up = new int[n];

        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1]) {
                down[i] = down[i - 1] + 1;
                up[i] = up[i - 1] + 1;
            } else if (nums[i] < nums[i - 1]) {
                down[i] = down[i - 1] + 1;
                up[i] = up[i - 1];
            } else {
                down[i] = down[i - 1];
                up[i] = up[i - 1] + 1;
            }
        }

        while (temp < n - k) {
            left = down[temp - 1] - down[temp - k];
            right = up[temp + k] - up[temp + 1];
            if (left == k - 1 && right == k - 1) ans.add(temp);

            temp++;
        }
        return ans;
    }
}
