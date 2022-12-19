package array;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/minimum-penalty-for-a-shop/description/">Minimum Penalty for a Shop</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Hint : Use prefix sum and find mathematical equation.</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 */

public class MinimumPenaltyForAShop {
    public static void main(String[] args) {
        System.out.println(bestClosingTime("YYNY"));
        System.out.println(bestClosingTime("YYYY"));
        System.out.println(bestClosingTime("NYNYNNYYYN"));
        System.out.println(bestClosingTime("NNNNN"));
    }

    public static int bestClosingTime(String s) {
        int n = s.length();
        int[] arr = new int[n+1];
        for(int i=0; i<n; i++) {
            arr[i+1] = arr[i] + (s.charAt(i) == 'Y' ? 1 : 0);
        }

        int idx=0, min=n, val;
        for(int i=0; i<=n; i++) {
            val = arr[n]-arr[i] + i-arr[i];
            if(val < min) {
                min = val;
                idx = i;
            }
        }
        return idx;
    }
}
