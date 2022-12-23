package array;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/minimum-amount-of-time-to-collect-garbage/">Minimum Amount of Time to Collect Garbage</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Hint: Calculate the last position of type of garbage separately</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 * </body>
 */

public class MinimumAmountOfTimeToCollectGarbage {
    public static void main(String[] args) {
        System.out.println(garbageCollection(new String[]{"G", "P", "GP", "GG"}, new int[]{2, 4, 3}));
        System.out.println(garbageCollection(new String[]{"MMM", "PGM", "GP"}, new int[]{3, 10}));
    }

    public static int garbageCollection(String[] garbage, int[] travel) {
        int m = 0, p = 0, g = 0, ans = garbage[0].length();
        int[] sum = new int[travel.length + 1];
        char ch;

        for (int j = 1; j < garbage.length; j++) {
            ans += garbage[j].length();
            for (int i = 0; i < garbage[j].length(); i++) {
                ch = garbage[j].charAt(i);
                if (ch == 'P') {
                    p = j;
                } else if (ch == 'G') {
                    g = j;
                } else {
                    m = j;
                }
            }
        }

        for (int i = 0; i < travel.length; i++) {
            sum[i + 1] = sum[i] + travel[i];
        }

        ans += sum[p] + sum[g] + sum[m];
        return ans;
    }
}
