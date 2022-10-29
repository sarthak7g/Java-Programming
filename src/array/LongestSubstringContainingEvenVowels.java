package array;

import java.util.HashMap;
import java.util.Map;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/">Longest Substring Containing Vowels in Even Counts</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li><a href="https://leetcode.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/discuss/534135/C%2B%2BJava-with-picture">Refer to solution in discussion</a> </li>
 *      <li>We are only concerned about count % 2 of each character in "aeiou", not about actual count. So, 5 characters and 5 flags, hence 32 combinations.</li>
 *      <li>Now, at each point check if the XOR sum is already seen or not and update the answer accordingly.</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(2^m) where m is number of characters. In this case 5 characters so O(32).</li>
 * </ul>
 */

public class LongestSubstringContainingEvenVowels {
    public static void main(String[] args) {
        System.out.println(findTheLongestSubstring("eleetminicoworoep"));
        System.out.println(findTheLongestSubstring("leetcodeisgreat"));
        System.out.println(findTheLongestSubstring("bcbcbc"));
    }

    public static int findTheLongestSubstring(String s) {
        Map<Character, Integer> dict = new HashMap<>();
        dict.put('a', 0);
        dict.put('e', 1);
        dict.put('i', 2);
        dict.put('o', 3);
        dict.put('u', 4);

        int sum=0, ans=0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for(int i=0; i<s.length(); i++) {
            if(dict.containsKey(s.charAt(i))) {
                sum ^= 1<<dict.get(s.charAt(i));
            }

            // System.out.println(sum);

            if(map.containsKey(sum)) {
                ans = Math.max(ans, i-map.get(sum));
            }else map.put(sum, i);
        }

        return ans;
    }
}
