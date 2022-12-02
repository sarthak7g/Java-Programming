package array;

import java.util.ArrayList;
import java.util.List;

/**
 * <h3>Level: Medium</h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/describe-the-painting/">Describe the Painting</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Hint: Range Addition approach</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 */

public class DescribeThePainting {
    public static void main(String[] args) {
        System.out.println(splitPainting(new int[][]{{1, 4, 5}, {4, 7, 7}, {1, 7, 9}}));
        System.out.println(splitPainting(new int[][]{{1, 7, 9}, {6, 8, 15}, {8, 10, 7}}));
        System.out.println(splitPainting(new int[][]{{1, 4, 5}, {1, 4, 7}, {4, 7, 1}, {4, 7, 11}}));
    }

    public static List<List<Long>> splitPainting(int[][] segments) {
        long[][] arr = new long[100001][2];
        for (int[] seg : segments) {
            arr[seg[0]][0] += seg[2];
            arr[seg[0]][1] = 1;
            arr[seg[1]][0] -= seg[2];
            arr[seg[1]][1] = 1;
        }

        long prev_sum = 0, sum = 0, start = 0;

        List<List<Long>> ans = new ArrayList<>();

        for (int i = 1; i < arr.length; i++) {
            sum += arr[i][0];
            if (arr[i][1] == 1) {
                if (start != 0 && prev_sum != 0) {
                    List<Long> temp = new ArrayList<>();
                    temp.add(start);
                    temp.add((long) i);
                    temp.add(prev_sum);
                    ans.add(temp);
                }
                start = i;
            }
            prev_sum = sum;
        }

        return ans;
    }

}
