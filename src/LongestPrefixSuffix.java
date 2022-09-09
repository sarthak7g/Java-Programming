/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://practice.geeksforgeeks.org/problems/longest-prefix-suffix2527/1">Longest Prefix Suffix</a>
 * <br/>
 *  Approach 1:
 *      <ul>
 *          <li>two pointers i=0, j=1</li>
 *          <l1>when s[i] == s[j], increment i, j and count</l1>
 *          <l1>if s[i] != s[j] && count!=0, change i=0, j=j-count+1, count=0</l1>
 *          <l1>else if s[i] != s[j] && count ==0, increment j</l1>
 *          <li>Time complexity: O(n^2)</li>
 *      </ul>
 * </body>
 */

public class LongestPrefixSuffix {
    public static void main(String[] args) {
        System.out.println(lps("abcccaccabcccab"));
        System.out.println(lps("aaaaaaaa"));
    }
    static int lps(String s) {
        if(s.length() == 1) return 0;

        int i=0, j=1, count=0;

        while(j<s.length()) {
            if(s.charAt(i) == s.charAt(j)) {
                i++;
                j++;
                count++;
            }
            else if(i==0) {
                j++;
            }else {
                i = 0;
                j = j-count+1;
                count = 0;
            }
            // System.out.print(count + " ");
        }

        return count;
    }
}

