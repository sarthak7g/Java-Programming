package dp.lcs.variations;

import static dp.lcs.variations.PrintLCS.findLCS;

/**
 * <h3>Level: Hard </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/shortest-common-supersequence/">Shortest Common Super Sequence</a>
 * <br/>
 *  Approach 1:
 *      <ul>
 *          <li>Find LCS string</li>
 *          <li>Then, add non-LCS characters by comparing all three strings together</li>
 *          <li>Time complexity: O(n^2)</li>
 *      </ul>
 * </body>
 */

public class ShortestSuperSubsequence {
    public static void main(String[] args) {
        System.out.println(shortestCommonSupersequence("saransh","sarthak"));
        System.out.println(shortestCommonSupersequence("bbbaaaba","bbabbbb"));
    }
    static String shortestCommonSupersequence(String str1, String str2) {
        String common = findLCS(str1, str2);
        // System.out.println(common);

        StringBuilder ans = new StringBuilder();
        int i=0, j=0, k=0;
        while(i<str1.length() && j<str2.length() && k<common.length()) {
            if(str1.charAt(i) == str2.charAt(j) && str2.charAt(j) == common.charAt(k)) {
                ans.append(str1.charAt(i));
                i++; j++; k++;
            }
            else if(str1.charAt(i) != common.charAt(k)) {
                ans.append(str1.charAt(i++));
            }
            else if(str2.charAt(j) != common.charAt(k)) {
                ans.append(str2.charAt(j++));
            }
            // System.out.println(ans);
        }

        while(i<str1.length()) {
            ans.append(str1.charAt(i++));
        }
        while(j<str2.length()) {
            ans.append(str2.charAt(j++));
        }

        return ans.toString();
    }

}
