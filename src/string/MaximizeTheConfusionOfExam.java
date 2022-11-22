package string;

/**
 * <h3>Level: Medium</h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/maximize-the-confusion-of-an-exam/">Maximize the Confusion of an Exam</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Sliding window approach</li>
 *      <li>Iterate twice through the string choosing one character at a time.</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(1)</li>
 * </ul>
 */

public class MaximizeTheConfusionOfExam {
    public static void main(String[] args) {
        System.out.println(maxConsecutiveAnswers("TTFTFTFTTFFFTF", 4));
        System.out.println(maxConsecutiveAnswers("TTFTFTFTT", 2));
    }
    public static int maxConsecutiveAnswers(String str, int k) {
        return Math.max(check(str, 'T', k), check(str, 'F', k));
    }

    static int check(String str, char sign, int k) {
        int l=0, n=str.length(), ans=0;
        for(int r=0; r<n; r++) {
            if(str.charAt(r) != sign) {
                k--;
            }
            if(k<0) {
                while(str.charAt(l) == sign) {
                    l++;
                }
                l++;
                k++;
            }
            ans = Math.max(r-l+1, ans);
        }
        return ans;
    }

}
