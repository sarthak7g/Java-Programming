package dp.lcs.variations;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://practice.geeksforgeeks.org/problems/longest-repeating-subsequence2004/1">Longest Repeating Subsequence</a>
 * <br/>
 * Approach:
 *      <ul>
 *          <li>Iterative DP, using matrix</li>
 *          <li>Similar to LCS just check if the indices are different when the chars are same</li>
 *          <li>Time complexity: O(n^2)</li>
 *      </ul>
 *  <br/>
 * </body>
 */

public class LongestRepeatingSubsequences {
    public static void main(String[] args) {
        System.out.println(LongestRepeatingSubsequence("ahrkrpmdcnigorkdcnigpmo"));
    }
    public static int LongestRepeatingSubsequence(String str)
    {
        int n = str.length();
        int[][] arr = new int[n+1][n+1];
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(i!=j && str.charAt(i-1)==str.charAt(j-1)) {
                    arr[i][j] = arr[i-1][j-1]+1;
                }else {
                    arr[i][j] = Math.max(arr[i-1][j], arr[i][j-1]);
                }
            }
        }
        return arr[n][n];
    }
}
