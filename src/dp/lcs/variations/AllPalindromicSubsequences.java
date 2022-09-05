package dp.lcs.variations;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://practice.geeksforgeeks.org/problems/count-palindromic-subsequences/1">All Palindromic Subsequences</a>
 * <br/>
 *  Approach:
 *      <ul>
 *          <li>Expanding around centers like in 2nd approach of Longest Palindromic Substring</li>
 *          <li>Time complexity: O(n^2)</li>
 *      </ul>
 * </body>
 */

public class AllPalindromicSubsequences {
    public static void main(String[] args) {
        System.out.println(countPS("abababa"));
    }

    static long countPS(String s)
    {
        // expandAroundTheCenters
        long ans = 0;
        for(int i=0; i<s.length(); i++){
            ans += find(s, i, i);
            ans += find(s, i, i+1);
        }

        return (long)(ans % (Math.pow(10, 9) + 7));
    }

    static long find(String str, int i, int j) {
        int count=0;
        while(i>=0 && j<str.length()) {
            if(str.charAt(i) == str.charAt(j)){
                if(i==j) {
                    count += 1;
                }else count += 2;
                i--;
                j++;
            }
            else break;
        }
        return count;
    }
}
