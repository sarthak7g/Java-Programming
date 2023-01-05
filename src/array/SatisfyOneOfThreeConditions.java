package array;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/change-minimum-characters-to-satisfy-one-of-three-conditions/description/">Change Minimum Characters to Satisfy One of Three Conditions</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Hint: Use Two Character array and two prefix sum array</li>
 *      <li>A tricky question. Intuition is- we will traverse each character and find the solution and compare it with previous solutions.</li>
 *      <li>At each character we will calculate how many moves are required to move all lesser chars of string 'a' and to move all greater chars of string 'b'.</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(1)</li>
 * </ul>
 * </body>
 */

public class SatisfyOneOfThreeConditions {

    public static void main(String[] args) {
        System.out.println(minCharacters("aba", "caa"));
        System.out.println(minCharacters("dabadd", "cda"));
        System.out.println(minCharacters("dabadd", "cdaf"));
        System.out.println(minCharacters("dabadde", "cdaeee"));
        System.out.println(minCharacters("a", "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"));
        System.out.println(minCharacters("aaa", "aba"));
    }

    public static int minCharacters(String a, String b) {
        int[][] char_arr = new int[2][26];
        int[][] prefix_arr = new int[2][27];

        int val, min = a.length() + b.length(), temp;
        for (int i = 0; i < a.length(); i++) {
            val = (int) a.charAt(i) - 97;
            char_arr[0][val]++;
        }

        for (int i = 0; i < b.length(); i++) {
            val = (int) b.charAt(i) - 97;
            char_arr[1][val]++;
        }

        // System.out.println(Arrays.toString(char_arr[1]));
        for (int i = 0; i < 26; i++) {
            prefix_arr[0][i + 1] = prefix_arr[0][i] + char_arr[0][i];
            prefix_arr[1][i + 1] = prefix_arr[1][i] + char_arr[1][i];
        }

        // System.out.println(Arrays.toString(prefix_arr[0]));
        // System.out.println(Arrays.toString(prefix_arr[1]));

        for (int i = 25; i > 0; i--) {
            // shift every letter less than curr letter of string 'a' to curr char
            // and all letters greather than or equal to curr letter of string 'b'
            // to letter less than curr letter
            temp = prefix_arr[0][i] + prefix_arr[1][26] - prefix_arr[1][i];
            min = Math.min(min, temp);

            temp = prefix_arr[1][i] + prefix_arr[0][26] - prefix_arr[0][i];
            min = Math.min(min, temp);

            // both strings have only one distinct characters
            temp = prefix_arr[0][26] - char_arr[0][i] +
                    prefix_arr[1][26] - char_arr[1][i];
            min = Math.min(min, temp);

        }
        // check third condition for i=0
        temp = prefix_arr[0][26] - char_arr[0][0] +
                prefix_arr[1][26] - char_arr[1][0];
        min = Math.min(min, temp);


        return min;
    }
}
