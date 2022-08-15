/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/count-and-say/">Count and Say Problem</a>
 * <br/>
 * Time complexity: O(n^2) <br/>
 * </body>
 */

public class CountAndSay {
    public static void main(String[] args) {
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(10));
    }
    public static String countAndSay(int n) {
        if(n == 1)
            return "1";

        String subAns = countAndSay(n-1);
        char[] arr = subAns.toCharArray();
        StringBuilder sbr = new StringBuilder();
        int i=1, count=1;

        while(i<arr.length) {
            if(arr[i] == arr[i-1])
                count++;
            else {
                sbr.append(count);
                sbr.append(arr[i-1]);
                count = 1;
            }
            i++;
        }
        sbr.append(count);
        sbr.append(arr[i-1]);
        // System.out.println(sbr);
        return sbr.toString();
    }
}
