package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/unique-length-3-palindromic-subsequences/">Unique Length-3 Palindromic Subsequences</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Hint : For every possible outer characters, try to find all possible middle characters. Use Binary Search.</li>
 *      <li><a href="https://leetcode.com/problems/unique-length-3-palindromic-subsequences/solutions/2915686/java-o-n-with-hashmap-and-binarysearch/">Explanation</a></li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 */

public class UniqueLength3PalindromicSubsequences {
    public static void main(String[] args) {
        System.out.println(countPalindromicSubsequence("aabca"));
        System.out.println(countPalindromicSubsequence("adc"));
        System.out.println(countPalindromicSubsequence("bbcbaba"));
        System.out.println(countPalindromicSubsequence("bbcbaca"));
    }

    public static int countPalindromicSubsequence(String s) {
        Map<Character, List<Integer>> map = new HashMap<>();
        List<Integer> l;
        for(int i=0; i<s.length(); i++) {
            l = map.getOrDefault(s.charAt(i), new ArrayList<Integer>());
            l.add(i);
            map.put(s.charAt(i), l);
        }

        int ans = 0;
        for(Character c : map.keySet()) {
            ans += solve(c, map);
        }
        return ans;
    }

    public static int solve(Character ch, Map<Character, List<Integer>> map) {
        List<Integer> list = map.get(ch), temp;
        int n = list.size();
        if(n < 2 || list.get(n-1) - list.get(0) < 2)
            return 0;

        int st = list.get(0)+1, end = list.get(n-1)-1, ans=0;
        for(Character c : map.keySet()) {
            temp = map.get(c);
            int pos = Collections.binarySearch(temp, st);
            if(pos < 0) {
                pos = -1 * (pos + 1);
                if(pos < temp.size() && temp.get(pos) <= end) ans += 1;
            }else ans += 1;
        }
        return ans;
    }

}
