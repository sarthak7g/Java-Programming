package array;

/**
 * <h3>Level: Medium</h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/the-number-of-weak-characters-in-the-game/description/">The Number of Weak Characters in the Game</a>
 * <br/>
 * <br/>
 * <b>Approach 1:</b>
 * <ul>
 *      <li>Recursive solution</li>
 *      <li>Time complexity: O(n^2)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 * </body>
 */

public class VerifyPreorderSequenceInBinarySearchTree {
    public static void main(String[] args) {
        System.out.println(verifyPreorder(new int[]{5, 2, 1, 3, 6}));
        System.out.println(verifyPreorder(new int[]{5, 2, 6, 1, 3}));
    }

    public static boolean verifyPreorder(int[] pre) {
        return solve(pre, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, pre.length - 1);
    }

    public static boolean solve(int[] arr, int min, int max, int left, int right) {
        if (left > right) return true;
        if (arr[left] < min || arr[left] > max) return false;

        int i = left + 1;
        while (i <= right && arr[i] < arr[left] && arr[i] > min) i++;

        if (i <= right && arr[i] < min) return false;

        if (!solve(arr, min, arr[left], left + 1, i - 1)) return false;
        return solve(arr, arr[left], max, i, right);

    }
}
