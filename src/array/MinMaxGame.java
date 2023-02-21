package array;

/**
 * <h3>Level: Easy </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/min-max-game/description/">Min Max Game</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Time complexity: O(log(n))</li>
 *      <li>Space complexity: O(log(n))</li>
 * </ul>
 * </body>
 */

public class MinMaxGame {
    public static void main(String[] args) {
        System.out.println(minMaxGame(new int[]{1, 3, 5, 2, 4, 8, 2, 2}));
        System.out.println(minMaxGame(new int[]{3}));
    }

    public static int minMaxGame(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] arr = new int[nums.length / 2];
        int i = 0;
        for (int j = 0; j < nums.length / 2; j++) {
            if (i % 2 == 0)
                arr[j] = Math.min(nums[2 * i], nums[2 * i + 1]);
            else arr[j] = Math.max(nums[2 * i], nums[2 * i + 1]);
            i++;
        }
        return minMaxGame(arr);
    }
}
