package array;

/**
 * <h3>Level: Easy </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/find-the-highest-altitude/">Find the Highest Altitude</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 *      <ul>
 *          <li>Find prefix sum.</li>
 *          <li>Time complexity: O(n)</li>
 *          <li>Space complexity: O(1)</li>
 *      </ul>
 */

public class FindTheHighestAltitude {

    public static void main(String[] args) {
        System.out.println(largestAltitude(new int[]{-5, 1, 5, 0, -7}));
        System.out.println(largestAltitude(new int[]{-4, -3, -2, -1, 4, 3, 2}));
    }

    public static int largestAltitude(int[] gain) {
        int sum = 0, ans = 0;
        for (int el : gain) {
            sum += el;
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
