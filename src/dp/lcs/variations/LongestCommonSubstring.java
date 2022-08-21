package dp.lcs.variations;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://practice.geeksforgeeks.org/problems/longest-common-substring1452/1">Longest Common Substring</a>
 * <br/>
 *  Approach 1:
 *      <ul>
 *          <li>Iterative DP, using matrix</li>
 *          <li>Two cases, </li>
 *          <li>char(t)==char(s), arr[i][j] = arr[i-1][j-1] + 1 </li>
 *          <li>char(t)!=char(s), arr[i][j] = 0 </li>
 *          <li>Time complexity: O(n^2)</li>
 *      </ul>
 *  Approach 2:
 *      <ul>
 *          <li>Recursive without dp</li>
 *          <li>Two cases, </li>
 *          <li>char(t)==char(s), f(i,j, count) = max(count, f(i+1, j+1, count+1), f(i+1, j, 0), f(i, j+1, 0)) </li>
 *          <li>char(t)!=char(s), f(i,j, count) = max(count, f(i+1, j, 0), f(i, j+1, 0)) </li>
 *          <li>Time complexity: O(2^n)</li>
 *      </ul>
 * </body>
 */

public class LongestCommonSubstring {
    public static void main(String[] args) {
        System.out.println(longestCommonSubstr("abchdk", "rcabdd"));
        System.out.println(longestCommonSubstrRecursion("abchdk", "rcabdd", 0, 0, 0));
        System.out.println(longestCommonSubstrRecursion("abcdxyz", "xyzabcd", 0, 0, 0));
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
    static int longestCommonSubstrRecursion(String a, String b, int i, int j, int count) {
        // base case
        if(i==a.length() || j==b.length()) {
            return count;
        }

        int max = count;
        // subproblem
        if(a.charAt(i) == b.charAt(j)) {
            max = Math.max(max, longestCommonSubstrRecursion(a, b, i+1, j+1, count+1));
        }
        return max(max, longestCommonSubstrRecursion(a, b, i+1, j, 0), longestCommonSubstrRecursion(a, b, i, j+1, 0));
    }

    static int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
}
