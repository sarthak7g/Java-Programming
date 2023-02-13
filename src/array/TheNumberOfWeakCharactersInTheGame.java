package array;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * <h3>Level: Medium</h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/the-number-of-weak-characters-in-the-game/description/">The Number of Weak Characters in the Game</a>
 * <br/>
 * <br/>
 * <b>Approach 1:</b>
 * <ul>
 *      <li>MS: Sort the array based on attack(inc order) then sort by defense(dec order). This way we can easily use MS while traversing from backwards.</li>
 *      <li>Time complexity: O(n*log(n))</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 * </body>
 */

public class TheNumberOfWeakCharactersInTheGame {
    public static void main(String[] args) {
        System.out.println(numberOfWeakCharacters(new int[][]{{5, 5}, {6, 3}, {3, 6}}));
        System.out.println(numberOfWeakCharacters(new int[][]{{2, 2}, {3, 3}}));
        System.out.println(numberOfWeakCharacters(new int[][]{{1, 5}, {10, 4}, {4, 3}}));
        System.out.println(numberOfWeakCharacters(new int[][]{{1, 1}, {2, 1}, {2, 2}, {1, 2}}));
    }

    public static int numberOfWeakCharacters(int[][] arr) {
        int count = 0;
        Arrays.sort(arr, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i][1] >= stack.getFirst()) {
                stack.remove();
            }
            if (!stack.isEmpty()) count++;
            stack.addFirst(arr[i][1]);
        }
        return count;
    }
}
