/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://practice.geeksforgeeks.org/problems/split-the-binary-string-into-substrings-with-equal-number-of-0s-and-1s/1">Split Binary String into Substring With Equal 0 and 1s</a>
 * <br/>
 *  Approach:
 *      <ul>
 *          <li>Iterative</li>
 *          <li>Time complexity: O(n)</li>
 *      </ul>
 * </body>
 */

public class SplitSubstringWithEqual01 {
    public static void main(String[] args) {
        System.out.println(maxSubStr("01111000100"));
        System.out.println(maxSubStr("011110001"));
        System.out.println(maxSubStr("0111100010"));
    }
    public static int maxSubStr(String str) {
        //Write your code here
        int ans=0, i=0;
        while(i<str.length()) {
            int count0=0, count1=0;
            do{
                if(str.charAt(i) == '0'){
                    count0 += 1;
                }else count1 += 1;
                i++;
            }while(i<str.length() && count0!=count1);
            //   System.out.println(count0 + " " + count1);
            if(count0 != count1) return -1;
            ans += 1;
        }
        return ans;
    }
}
