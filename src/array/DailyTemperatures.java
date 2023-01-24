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
 */

public class DailyTemperatures {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
        System.out.println(Arrays.toString(dailyTemperatures2(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{30, 40, 50, 60})));
        System.out.println(Arrays.toString(dailyTemperatures2(new int[]{30, 40, 50, 60})));
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{30, 60, 90})));
        System.out.println(Arrays.toString(dailyTemperatures2(new int[]{30, 60, 90})));
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
                ans[idx] = i-idx;
            }
            s.push(i);
        }

        return ans;
    }


}
