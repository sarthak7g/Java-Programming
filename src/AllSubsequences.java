import java.util.ArrayList;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://www.codingninjas.com/codestudio/problems/subsequences-of-string_985087?leftPanelTab=0">All Subsequences</a>
 * <br/>
 * Approach:
 *      <ul>
 *          <li>Recursive, find solution for substr and then, add</li>
 *          <li>Time complexity: O(n * 2^n), where n is length of string</li>
 *      </ul>
 *  <br/>
 */

public class AllSubsequences {
    public static void main(String[] args) {
        System.out.println(subsequences("abc"));
    }
    public static ArrayList<String> subsequences(String str) {
        if(str.length() == 0){
            return new ArrayList<>();
        }

        ArrayList<String> sub =
                subsequences(str.substring(0, str.length()-1));
        ArrayList<String> ans = new ArrayList<>();
        char c = str.charAt(str.length()-1);
        for(String st : sub) {
            ans.add(st);
            ans.add(st + c);
        }
        ans.add(str.substring(str.length()-1));
        return ans;
    }
}
