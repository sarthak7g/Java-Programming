package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.ArrayDeque;
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
 * <b>Approach 2:</b>
 * <ul>
 *      <li>Intuition: While traversing from right, and maintain a stack of cars ordered by the time(decreasing).</li>
 *      <li>We will also use the time taken by the next car to meet car ahead of it, i.e. ans[j], cz after that time(ans[j]), it becomes a part of new fleet and the speed will change.</li>
 *      <li>Refer <a href="https://leetcode.com/problems/car-fleet-ii/solutions/1085987/java-c-python-o-n-stack-solution/">solution</a></li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 * </body>
 */

public class CarFleetII {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getCollisionTimes(new int[][]{{1, 2}, {2, 1}, {4, 3}, {7, 2}})));
        System.out.println(Arrays.toString(getCollisionTimes(new int[][]{{3, 4}, {5, 4}, {6, 3}, {9, 1}})));
        System.out.println(Arrays.toString(getCollisionTimes(new int[][]{{1, 4}, {4, 5}, {7, 1}, {13, 4}, {14, 3}, {15, 2}, {16, 5}, {19, 1}})));
        System.out.println(Arrays.toString(getCollisionTimes(new int[][]{{2, 2}, {4, 5}, {5, 5}, {8, 1}, {9, 3}, {10, 1}, {11, 4}, {12, 1}, {17, 4}, {20, 2}})));
        System.out.println();
        System.out.println(Arrays.toString(getCollisionTimes2(new int[][]{{1, 2}, {2, 1}, {4, 3}, {7, 2}})));
        System.out.println(Arrays.toString(getCollisionTimes2(new int[][]{{3, 4}, {5, 4}, {6, 3}, {9, 1}})));
        System.out.println(Arrays.toString(getCollisionTimes2(new int[][]{{1, 4}, {4, 5}, {7, 1}, {13, 4}, {14, 3}, {15, 2}, {16, 5}, {19, 1}})));
        System.out.println(Arrays.toString(getCollisionTimes2(new int[][]{{2, 2}, {4, 5}, {5, 5}, {8, 1}, {9, 3}, {10, 1}, {11, 4}, {12, 1}, {17, 4}, {20, 2}})));
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
            for (int j = tmp.size() - 1; j >= 0; j--) {
                curr = tmp.get(j);
                if (time != -1 && dist <= curr.get(0)) {
                    break;
                }
                if (arr[i][1] <= curr.get(1)) continue;
                time = (curr.get(0) - arr[i][0] - (arr[i][1] * curr.get(2))) / (arr[i][1] - curr.get(1));
                time += curr.get(2);
                dist = (arr[i][0] + arr[i][1] * time);
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

    public static double[] getCollisionTimes2(int[][] arr) {
        int l = arr.length, p, s, dist, speed;
        Deque<Integer> stack = new ArrayDeque<>();
        double[] ans = new double[l];

        for (int i = l - 1; i >= 0; i--) {
            ans[i] = -1.0;
            dist = arr[i][0];
            speed = arr[i][1];
            while (!stack.isEmpty()) {
                int j = stack.getFirst();
                p = arr[j][0];
                s = arr[j][1];
                if (speed <= s || 1.0 * (p - dist) / (speed - s) >= ans[j] && ans[j] > 0) {
                    stack.remove();
                } else break;
            }
            if (!stack.isEmpty()) {
                int j = stack.getFirst();
                p = arr[j][0];
                s = arr[j][1];
                ans[i] = 1.0 * (p - dist) / (speed - s);
            }
            stack.addFirst(i);
        }

        return ans;
    }
}
