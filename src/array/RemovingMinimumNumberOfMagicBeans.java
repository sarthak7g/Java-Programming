package array;

import java.util.Arrays;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/removing-minimum-number-of-magic-beans/description/">Removing Minimum Number of Magic Beans</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Hint: Try with O(n^2) solution.</li>
 *      <li>Sort the array. Then, find the mathematical formula.</li>
 *      <li>Time complexity: O(n*log(n))</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 */

public class RemovingMinimumNumberOfMagicBeans {
    public static void main(String[] args) {
        System.out.println(minimumRemoval(new int[] {4,1,6,5}));
        System.out.println(minimumRemoval(new int[] {2,10,3,2}));
    }

    public static long minimumRemoval(int[] arr) {
        int n = arr.length;
        long[] pref = new long[n+1];
        Arrays.sort(arr);

        for(int i=0; i<n; i++) {
            pref[i+1] = pref[i] + arr[i];
        }

        long ans = Long.MAX_VALUE, temp;
        for(int i=0; i<n; i++) {
            temp = pref[i] + pref[n] - pref[i+1] - arr[i] * (long)(n-i-1);
            // System.out.println(arr[i] + " " + temp);
            ans = Math.min(ans, temp);
        }

        return ans;
    }
}
