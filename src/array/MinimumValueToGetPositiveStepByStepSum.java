package array;

/**
 * <h3>Level: Easy </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/">Minimum Value to Get Positive Step by Step Sum</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Hint: Find the min prefix_sum.</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(1)</li>
 * </ul>
 */

public class MinimumValueToGetPositiveStepByStepSum {
    public static void main(String[] args) {
        System.out.println(minStartValue(new int[] {-3,2,-3,4,2}));
        System.out.println(minStartValue(new int[] {1,2}));
    }
    public static int minStartValue(int[] nums) {
        int min=101, sum=0;
        for(int el : nums) {
            sum += el;
            min = Math.min(sum, min);
        }
        return min>0 ? 1: Math.abs(min)+1;
    }
}
