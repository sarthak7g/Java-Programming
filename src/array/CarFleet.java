package array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/car-fleet/description/">Car Fleet</a>
 * <br/>
 * <br/>
 * <b>Approach 1:</b>
 * <ul>
 *      <li>Find the time taken to reach target for each car. Sort the array based on position. refer <a href="https://leetcode.com/problems/car-fleet/solutions/139850/c-java-python-straight-forward/">solution 1</a></li>
 *      <li>Also <a href="https://leetcode.com/problems/car-fleet/solutions/255589/python-code-with-explanations-and-visualization-beats-95/">refer</a> for diagram: </li>
 *      <li>Start from the car at most advanced position, now we will maintain a slowest variable which we will store the min time to reach to the fleet.</li>
 *      <li>A faster car having slower time will catchup with current fleet. But if we have a slowest car, that will be the leading car of new fleet.</li>
 *      <li>Time complexity: O(n(log(n)))</li>
 *      <li>Space complexity: O(1)</li>
 * </ul>
 * </body>
 */

public class CarFleet {
    public static void main(String[] args) {
        System.out.println(carFleet(12, new int[]{10, 8, 0, 5, 3, 6}, new int[]{2, 4, 1, 1, 3, 2}));
        System.out.println(carFleet(10, new int[]{3}, new int[]{3}));
        System.out.println(carFleet(100, new int[]{0, 2, 4}, new int[]{4, 2, 1}));
        System.out.println(carFleet(100, new int[]{4, 18}, new int[]{2, 1}));
    }

    public static int carFleet(int target, int[] pos, int[] speed) {
        int n = pos.length, ans = 0;
        double[][] cars = new double[n][2];
        for (int i = 0; i < pos.length; i++) {
            cars[i][0] = pos[i];
            cars[i][1] = (double) (target - pos[i]) / speed[i];
        }

        double slowest = 0;
        Arrays.sort(cars, Comparator.comparingDouble(a -> a[0]));
        for (int i = n - 1; i >= 0; i--) {
            if (cars[i][1] > slowest) {
                slowest = cars[i][1];
                ans++;
            }
        }

        return ans;
    }
}
