package array;

import java.util.ArrayList;
import java.util.List;

/**
 * <h3>Level: Medium</h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/find-good-days-to-rob-the-bank/">Good Days to Rob the Bank</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Hint: Calculate the fwd and bwd points for local minima.</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 */

public class GoodDaysToRobTheBank {
    public static void main(String[] args) {
        System.out.println(goodDaysToRobBank(new int[]{5, 3, 3, 3, 5, 6, 2}, 2));
        System.out.println(goodDaysToRobBank(new int[]{5, 3, 3, 3, 5, 6, 2}, 3));
        System.out.println(goodDaysToRobBank(new int[]{1, 1, 1, 1, 1, 1}, 0));
    }

    public static List<Integer> goodDaysToRobBank(int[] sec, int time) {
        List<Integer> ans = new ArrayList<>();
        int n = sec.length;

        if (time == 0) {
            for (int i = 0; i < n; i++) {
                ans.add(i);
            }
            return ans;
        }

        int[] arr = new int[n], bwd = new int[n];
        for (int i = 1; i < n - 1; i++) {
            if (sec[i] <= sec[i - 1]) {
                arr[i] = arr[i - 1] + 1;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (sec[i] <= sec[i + 1]) {
                bwd[i] = bwd[i + 1] + 1;
            }

            if (Math.min(arr[i], bwd[i]) >= time) {
                ans.add(i);
            }
        }

        return ans;
    }
}
