package dp.lcs.variations;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/longest-palindromic-subsequence/">Longest Palindromic Subsequence</a>
 * <br/>
 *  Approach:
 *      <ul>
 *          <li>Reverse string and then, LCS</li>
 *          <li>Time complexity: O(n^2)</li>
 *      </ul>
 */

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("abacrfbgbf"));
    }
    static int longestPalindromeSubseq(String s) {
        StringBuilder str=new StringBuilder(s);
        str.reverse();
        String s2 = str.toString();
        int[][] dp = new int[s.length()+1][s.length()+1];

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(s.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[s.length()][s.length()];
    }
}
