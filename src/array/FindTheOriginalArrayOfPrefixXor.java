package array;

import java.util.Arrays;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/find-the-original-array-of-prefix-xor/description/">Find The Original Array of Prefix Xor</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Xor curr_index to prev_index</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(1)</li>
 * </ul>
 */

public class FindTheOriginalArrayOfPrefixXor {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findArray(new int[] {5,2,0,3,1})));
        System.out.println(Arrays.toString(findArray(new int[] {1,0,0,1})));
    }

    public static int[] findArray(int[] pref) {
        int[] ans = new int[pref.length];
        ans[0] = pref[0];
        for(int i=1; i<pref.length; i++) {
            ans[i] = pref[i-1] ^ pref[i];
        }
        return ans;
    }
}
