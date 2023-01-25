package array;

import java.util.Arrays;
import java.util.Stack;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/daily-temperatures/description/">Daily Temperatures</a>
 * <br/>
 * <br/>
 * <b>Approach 1:</b>
 * <ul>
 *      <li>Hint: MS</li>
 *      <li>Backward approach- Insert indexes</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 * <b>Approach 2:</b>
 * <ul>
 *      <li>Hint: MS</li>
 *      <li>Forward approach- Insert indexes</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 * <b>Approach 3:</b>
 * <ul>
 *      <li>Hint: Iterate backwards and use the answer you're constructing. Refer <a href="https://leetcode.com/problems/daily-temperatures/solutions/1516538/daily-temperatures/">solution</a></li>
 *      <li>To further optimize it, we will use a hottest variable.</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(1)</li>
 * </ul>
 * </body>
 */

public class DailyTemperatures {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
        System.out.println(Arrays.toString(dailyTemperatures2(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
        System.out.println(Arrays.toString(dailyTemperatures3(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));

        System.out.println(Arrays.toString(dailyTemperatures(new int[]{30, 40, 50, 60})));
        System.out.println(Arrays.toString(dailyTemperatures2(new int[]{30, 40, 50, 60})));
        System.out.println(Arrays.toString(dailyTemperatures3(new int[]{30, 40, 50, 60})));

        System.out.println(Arrays.toString(dailyTemperatures(new int[]{30, 60, 90})));
        System.out.println(Arrays.toString(dailyTemperatures2(new int[]{30, 60, 90})));
        System.out.println(Arrays.toString(dailyTemperatures3(new int[]{30, 60, 90})));
    }

    public static int[] dailyTemperatures(int[] arr) {
        int n = arr.length;
        Stack<Integer> s = new Stack<>();
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!s.empty() && arr[i] >= arr[s.peek()]) {
                s.pop();
            }
            if (s.empty()) ans[i] = 0;
            else ans[i] = s.peek() - i;
            s.push(i);
        }

        return ans;
    }

    public static int[] dailyTemperatures2(int[] arr) {
        int n = arr.length, idx;
        Stack<Integer> s = new Stack<>();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            while (!s.empty() && arr[i] > arr[s.peek()]) {
                idx = s.pop();
                ans[idx] = i - idx;
            }
            s.push(i);
        }

        return ans;
    }

    public static int[] dailyTemperatures3(int[] arr) {
        int n = arr.length, curr, hottest = arr[n - 1];
        int[] ans = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            if (ans[i] >= hottest) {
                hottest = ans[i];
                continue;
            }

            curr = 1;
            while (ans[i + curr] != 0 && arr[i + curr] <= arr[i]) {
                curr += ans[i + curr];
            }

            if (arr[i + curr] > arr[i]) ans[i] = curr;
        }

        return ans;
    }

}
