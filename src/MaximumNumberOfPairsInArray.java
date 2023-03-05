import java.util.Arrays;

/**
 * <h3>Level: Easy </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/maximum-number-of-pairs-in-array/description/">Maximum Number of Pairs in Array</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Hint: HashMap</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 * </body>
 */

public class MaximumNumberOfPairsInArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(numberOfPairs(new int[]{1, 3, 2, 1, 3, 2, 2})));
        System.out.println(Arrays.toString(numberOfPairs(new int[]{1, 1})));
        System.out.println(Arrays.toString(numberOfPairs(new int[]{0})));
    }

    public static int[] numberOfPairs(int[] nums) {
        int[] arr = new int[101];
        for (int num : nums) {
            arr[num] += 1;
        }

        int[] ans = new int[2];
        for (int i = 0; i < 101; i++) {
            ans[1] += (arr[i] % 2);
            ans[0] += (arr[i] / 2);
        }
        return ans;
    }
}
