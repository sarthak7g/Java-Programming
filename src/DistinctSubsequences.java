/**
 * <h3>Level: Hard </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/distinct-subsequences/">Distinct Subsequences</a>
 * <br/>
 * Approach 1:
 *      <ul>
 *          <li>Recursive, find solution including the current index and find solution excluding the current index</li>
 *          <li>Time complexity: O(2^n)</li>
 *          <li>Need to optimize further</li>
 *      </ul>
 *  <br/>
 * </body>
 */

public class DistinctSubsequences {
    public static void main(String[] args) {
        System.out.println(numDistinct("babgbag", "bag"));
    }
    public static int numDistinct(String s, String t) {
        if(t.isEmpty()) {
            return 1;
        }

        char first = t.charAt(0);
        int i=0;

        while(i<s.length() && s.charAt(i)!=first) {
            i++;
        }

        if(i==s.length()){
            return 0;
        }

        return numDistinct(s.substring(i+1), t.substring(1)) +
                numDistinct(s.substring(i+1), t);
    }
}
