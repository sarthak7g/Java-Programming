package array;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/number-of-wonderful-substrings/description/">Number of Wonderful Substrings</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Hint: Bit mask approach./li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 * </body>
 */

public class NumberOfWonderfulSubstrings {
    public static void main(String[] args) {
        System.out.println(wonderfulSubstrings("aba"));
        System.out.println(wonderfulSubstrings("ababccb"));
        System.out.println(wonderfulSubstrings("aabb"));
        System.out.println(wonderfulSubstrings("aacbb"));
    }

    public static long wonderfulSubstrings(String word) {
        long[] count = new long[1024];
        count[0] = 1;

        int mask = 0, idx, tmp;
        long ans = 0;
        for(int i=0; i<word.length(); i++) {
            idx = word.charAt(i) - 'a';
            mask ^= (1 << idx);
            ans += count[mask];

            // This step checks for only one odd char
            // We will flick one switch at each pos to see if the mask exists previously
            for(int j=0; j<10; j++) {
                tmp = mask ^ (1 << j);
                ans += count[tmp];
            }

            count[mask] += 1;
        }

        return ans;
    }
}
