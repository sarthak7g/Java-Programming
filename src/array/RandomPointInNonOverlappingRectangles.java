package array;

import java.util.Arrays;
import java.util.Random;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/random-point-in-non-overlapping-rectangles/">Random Point in Non-overlapping Rectangles</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Approach is similar to {@link RandomPickWithWeight} solution.</li>
 *      <li>Select a rectangle and the probability of selecting a rectangle should be according to the number of points it contains.</li>
 *      <li>Then, randomly pick a point.</li>
 *      <li>Time complexity: O(log n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 */

public class RandomPointInNonOverlappingRectangles {

    int[] arr;
    int[][] rects;
    Random rand = new Random();

    public RandomPointInNonOverlappingRectangles(int[][] rects) {
        this.rects = rects;
        arr = new int[rects.length];
        int i = 0, sum = 0;

        for (int[] rect : rects) {
            sum += (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
            arr[i++] = sum;
        }
    }

    public int[] pick() {
        int val = rand.nextInt(arr[arr.length - 1]) + 1;
        int index = findBinarySearch(val);

        int[] rect = rects[index];

        int cols = rect[2] - rect[0] + 1;
        int rows = rect[3] - rect[1] + 1;

        return new int[]{rect[0] + rand.nextInt(cols), rect[1] + rand.nextInt(rows)};
    }

    private int findBinarySearch(int x) {
        int start = 0, end = arr.length - 1, mid;

        while (start <= end) {
            mid = (start + end) / 2;

            if (arr[mid] == x) {
                return mid;
            } else if (x > arr[mid]) {
                start = mid + 1;
            } else end = mid - 1;
        }

        return start;
    }

    public static void main(String[] args) {
        RandomPointInNonOverlappingRectangles obj = new RandomPointInNonOverlappingRectangles(new int[][]{new int[]{-2, -2, 1, 1}, new int[]{2, 2, 4, 6}});
        for (int i = 0; i < 10; i++) {
            System.out.println(Arrays.toString(obj.pick()));
        }
    }
}
