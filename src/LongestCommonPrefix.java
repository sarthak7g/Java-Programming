/**
 * <h3>Level: Easy </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/longest-common-prefix/">Longest Common Prefix</a>
 * <br/>
 *  Approach 1:
 *      <ul>
 *          <li>use divide and conquer approach</li>
 *          <li>Time complexity: O(n*log(n))</li>
 *      </ul>
 * </body>
 */

public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flow", "fluid", "flower", "fly"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        return find(strs, 0, strs.length-1);
    }

    static String find(String[] arr, int i, int j) {
        if(i == j) return arr[i];

        if(j == i+1) return compare(arr[i], arr[j]);

        int mid = (i+j)/2;
        String str1 = find(arr, i, mid);
        String str2 = find(arr, mid+1, j);

        return compare(str1, str2);

    }

    static String compare(String s1, String s2) {
        int i=0, j=0;
        while(i<s1.length() && j<s2.length()) {
            if(s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            }else break;
        }

        return s1.substring(0, i);
    }
}
