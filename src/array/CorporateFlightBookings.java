package array;

import java.util.Arrays;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/corporate-flight-bookings/">Corporate Flight Bookings</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 *      <ul>
 *          <li>{@link RangeAddition} approach</li>
 *          <li>Time complexity: O(n)</li>
 *          <li>Space complexity: O(n)</li>
 *      </ul>
 */

public class CorporateFlightBookings {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(corpFlightBookings(new int[][]{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}}, 5)));
        System.out.println(Arrays.toString(corpFlightBookings(new int[][]{{1, 2, 10}, {2, 2, 15}}, 2)));
    }

    public static int[] corpFlightBookings(int[][] bookings, int n) {

        int[] arr = new int[n];
        for (int[] flight : bookings) {
            arr[flight[0] - 1] += flight[2];

            if (flight[1] < n) {
                arr[flight[1]] -= flight[2];
            }
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            arr[i] = sum;
        }

        return arr;
    }
}
