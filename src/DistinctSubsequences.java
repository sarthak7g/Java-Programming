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
 *  Approach 2:
 *      <ul>
 *          <li>Iterative DP, using matrix</li>
 *          <li>Two cases char(t)=char(s)  </li>
 *          <li>char(t)!=char(s), arr[i][j] = arr[i][j-1], i.e, all combinations excluding char(s)</li>
 *          <li>char(t)==char(s), arr[i][j] = arr[i][j-1] + arr[i-1][j-1], i.e, sum of all combinations excluding char(s) and all excluding char(s) & char(t)</li>
 *          <li>Time complexity: O(n^2)</li>
 *      </ul>
 * </body>
 */

public class DistinctSubsequences {
    public static void main(String[] args) {
        System.out.println(numDistinct("babgbag", "bag"));
        System.out.println(numDistinctDP("babgbag", "bag"));
        System.out.println(numDistinct("babbbit", "bit"));
        System.out.println(numDistinctDP("babbbit", "bit"));
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

    public static int numDistinctDP(String s, String t) {
        int[][] arr = new int[t.length() + 1][s.length() + 1];

        for(int i=0; i<=t.length(); i++) {
            arr[i][0] = 0;
        }

        for(int i=0; i<=s.length(); i++) {
            arr[0][i] = 1;
        }

        for(int i=1; i<=t.length(); i++) {
            for(int j=1; j<=s.length(); j++) {
                if(t.charAt(i-1) == s.charAt(j-1)) {
                    arr[i][j] = arr[i][j-1] + arr[i-1][j-1];
                }else {
                    arr[i][j] = arr[i][j-1];
                }
            }
        }

        // print(arr);
        return arr[t.length()][s.length()];
    }

    private void print(int[][] arr) {
        for (int[] ints : arr) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();

        }
    }
}
