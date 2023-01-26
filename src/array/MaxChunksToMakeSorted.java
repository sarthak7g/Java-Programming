package array;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/max-chunks-to-make-sorted/description/">Max Chunks To Make Sorted</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>LC Hint: The first chunk can be found as the smallest k for which A[:k+1] == [0, 1, 2, ...k]; then we repeat this process.</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(1)</li>
 * </ul>
 * </body>
 */

public class MaxChunksToMakeSorted {
    public static void main(String[] args) {
        System.out.println(maxChunksToSorted(new int[]{4, 3, 2, 1, 0}));
        System.out.println(maxChunksToSorted(new int[]{1, 0, 2, 3, 4}));
        System.out.println(maxChunksToSorted(new int[]{6, 5, 4, 1, 3, 2, 0, 7}));
        System.out.println(maxChunksToSorted(new int[]{2, 0, 1}));
        System.out.println(maxChunksToSorted(new int[]{0, 4, 5, 2, 1, 3}));
        System.out.println(maxChunksToSorted(new int[]{0, 1, 2, 3, 4}));
    }

    public static int maxChunksToSorted(int[] arr) {
        int n = arr.length, max = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
            if (i == max) ans += 1;
        }

        return ans;
    }
}
