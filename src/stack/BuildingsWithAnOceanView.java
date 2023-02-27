package stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/buildings-with-an-ocean-view/description/">Buildings With an Ocean View</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Hint: MS</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 * </body>
 */

public class BuildingsWithAnOceanView {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findBuildings(new int[]{4, 2, 3, 1})));
        System.out.println(Arrays.toString(findBuildings(new int[]{4, 3, 2, 1})));
        System.out.println(Arrays.toString(findBuildings(new int[]{1, 3, 2, 4})));
    }

    public static int[] findBuildings(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = arr.length, j;
        int[] ans;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] >= arr[stack.getFirst()]) {
                stack.remove();
            }
            stack.addFirst(i);
        }
        j = stack.size();
        ans = new int[j];
        while (!stack.isEmpty()) {
            ans[--j] = stack.remove();
        }
        return ans;
    }
}
