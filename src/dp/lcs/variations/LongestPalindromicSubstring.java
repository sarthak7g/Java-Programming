package dp.lcs.variations;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/longest-palindromic-substring/">Longest Palindromic Substring</a>
 * <br/>
 * Approach 1:
 *      <ul>
 *          <li>Iterative DP, using matrix</li>
 *          <li>Use Longest Common Substring where str2 will be reverse of str1</li>
 *          <li>At each step check whether the substring formed is palindromic or not</li>
 *          <li>Time complexity: O(n^3)</li>
 *      </ul>
 *  <br/>
 * Approach 2:
 *      <ul>
 *          <li>Expanding around the centers, There are total 2n-1 centers instead of n centers</li>
 *          <li>2n-1 = n centers of each characters + n-1 centers with 2 consecutive characters taken together</li>
 *          <li>Time complexity: O(n^2)</li>
 *      </ul>
 * </body>
 */

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("aaaabbaa"));
        System.out.println(longestPalindrome2("aaaabbaa"));
        System.out.println(longestPalindrome("abacdfgdcaba"));
        System.out.println(longestPalindrome2("abacdfgdcaba"));
        System.out.println(longestPalindrome(""));
        System.out.println(longestPalindrome2(""));
        System.out.println(longestPalindrome2("a"));
        System.out.println(longestPalindrome2("a"));
    }
    public static String longestPalindrome(String s) {
        StringBuilder str = new StringBuilder(s);
        str.reverse();
        String s2 = str.toString();

        int n=s.length() + 1;
        int[][] arr = new int[n][n];

        String ans = "";
        for(int i=1; i<n; i++) {
            for(int j=1; j<n; j++) {
                if(s.charAt(j-1) == s2.charAt(i-1)) {
                    arr[i][j] = arr[i-1][j-1] + 1;
                    if(arr[i][j]>ans.length()) {
                        // check palindromic
                        String temp = s2.substring(i-arr[i][j], i);
                        if(check(temp)) {
                            ans = temp;
                        }
                    }
                }
            }
        }
        // Arrays.stream(arr).forEach(x -> System.out.println(Arrays.toString(x)));
        return ans;
    }

    static boolean check(String str) {
        int i=0, j=str.length()-1;
        while(i<j && str.charAt(i) == str.charAt(j)){
            i++;
            j--;
        }
        return i>=j;
    }

    public static String longestPalindrome2(String s) {
        if(s.length() <= 1)
            return s;
        String result = "";
        for (int i = 0; i < s.length()-1; i++) {
            String ans1 = expandAroundCenters(s, i, i);
            String ans2 = expandAroundCenters(s, i, i+1);
            if(ans1.length() > result.length()) {
                result = ans1;
            }
            if(ans2.length() > result.length()) {
                result = ans2;
            }
        }

        return result;
    }

    private static String expandAroundCenters(String s, int i, int j) {
        int left=i, right=j;
        while(left>=0 && right<s.length()) {
            if(s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }else break;
        }
        return s.substring(left+1,right);
    }
}
