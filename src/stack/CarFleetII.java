package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <h3>Level: Hard </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/car-fleet-ii/description/">Car Fleet II</a>
 * <br/>
 * <br/>
 * <b>Approach 1:</b>
 * <ul>
 *      <li>Hint: Traverse from back. Think of the speed-time graph from <a href="https://leetcode.com/problems/car-fleet/solutions/255589/python-code-with-explanations-and-visualization-beats-95/">solution</a></li>
 *      <li>Time complexity: O(n^2)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 * </body>
 */

public class CarFleetII {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getCollisionTimes(new int[][]{{1, 2}, {2, 1}, {4, 3}, {7, 2}})));
        System.out.println(Arrays.toString(getCollisionTimes(new int[][]{{3, 4}, {5, 4}, {6, 3}, {9, 1}})));
    }

    public static double[] getCollisionTimes(int[][] arr) {
        int l = arr.length;
        double time, speed = -1, dist = -1;
        double[] ans = new double[l];
        ans[l - 1] = -1;
        List<List<Double>> tmp = new ArrayList<>();
        List<Double> curr;

        for (int i = l - 2; i >= 0; i--) {
            time = -1;
            if (arr[i][1] > arr[i + 1][1]) {
                time = (double) (arr[i + 1][0] - arr[i][0]) / (arr[i][1] - arr[i + 1][1]);
                dist = (arr[i][0] + arr[i][1] * time);
                speed = arr[i + 1][1];
            }
            // System.out.println(i + " " + dist + " " + speed + " " + time);
            for (int j = 0; j < tmp.size(); j++) {
                curr = tmp.get(j);
                if (time != -1 && dist <= curr.get(0)) {
                    break;
                }
                if (arr[i][1] < curr.get(1)) continue;
                time = (curr.get(0) - arr[i][0] - (arr[i][1] * curr.get(2))) / (arr[i][1] - curr.get(1));
                dist = (arr[i][0] + arr[i][1] * curr.get(2) + arr[i][1] * time);
                speed = curr.get(1);
            }
            if (time != -1) {
                List<Double> al = new ArrayList<>();
                al.add(dist);
                al.add(speed);
                al.add(time);
                tmp.add(al);
            }
            // System.out.println(tmp);
            ans[i] = time;
        }

        return ans;
    }
}
