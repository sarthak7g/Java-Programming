package array;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/minimize-maximum-of-array/description/">Minimize Maximum of Array</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Intuition: We actually move the value of A[i] to A[i - 1] by 1. The prefix sum will always going to be same.</li>
 *      <li>Take avg at each point to find the best result. refer <a href="https://leetcode.com/problems/minimize-maximum-of-array/solutions/2706521/java-c-python-prefix-sum-average-o-n/">solution</a></li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(1)</li>
 * </ul>
 * </body>
 */

public class MinimizeMaximumOfArray {
    public static void main(String[] args) {
        System.out.println(minimizeArrayValue(new int[]{3, 7, 1, 6}));
        System.out.println(minimizeArrayValue(new int[]{10, 1}));
    }

    public static int minimizeArrayValue(int[] nums) {
        long ans = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            ans = Math.max(ans, (sum + i) / (i + 1));
        }
        return (int) ans;
    }

}


