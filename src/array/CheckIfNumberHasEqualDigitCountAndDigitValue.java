package array;

/**
 * <h3>Level: Easy </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/check-if-number-has-equal-digit-count-and-digit-value/description/">Check if Number Has Equal Digit Count and Digit Value</a>
 * <br/>
 * <br/>
 * <b>Approach 1:</b>
 * <ul>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(1)</li>
 * </ul>
 * </body>
 */


public class CheckIfNumberHasEqualDigitCountAndDigitValue {
    public static void main(String[] args) {
        System.out.println(digitCount("1210"));
        System.out.println(digitCount("030"));
    }

    public static boolean digitCount(String num) {
        int[] arr = new int[10];
        for(int i=0; i<num.length(); i++) {
            arr[num.charAt(i)-48] += 1;
        }

        for(int i=0; i<num.length(); i++) {
            if(arr[i] != num.charAt(i)-48) return false;
        }

        return true;

    }
}
