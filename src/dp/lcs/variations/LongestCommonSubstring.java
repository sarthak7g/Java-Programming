package dp.lcs.variations;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://practice.geeksforgeeks.org/problems/longest-common-substring1452/1">Longest Common Substring</a>
 * <br/>
 *  Approach 1:
 *      <ul>
 *          <li>Iterative DP, using matrix</li>
 *          <li>Two cases char(t)=char(s)  </li>
 *          <li>char(t)==char(s), arr[i][j] = arr[i-1][j-1] + 1 </li>
 *          <li>char(t)!=char(s), arr[i][j] = 0 </li>
 *          <li>Time complexity: O(n^2)</li>
 *      </ul>
 * </body>
 */

public class LongestCommonSubstring {
    public static void main(String[] args) {
        System.out.println(longestCommonSubstr("abchdk", "rcabdd"));
    }
    static int longestCommonSubstr(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        int max = 0;
        int[][] arr = new int[n+1][m+1];
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    arr[i][j] = 1+arr[i-1][j-1];
                    max = Math.max(arr[i][j], max);
                }
            }
        }
        return max;
    }
}
