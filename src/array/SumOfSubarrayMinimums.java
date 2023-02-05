package array;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/sum-of-subarray-minimums/description/">Sum of Subarray Minimums</a>
 * <br/>
 * <br/>
 * <b>Approach 1:</b>
 * <ul>
 *      <li>Hint: Try finding the contribution of an element to the answer. Sum of the contribution of each element we will get the final answer. Refer <a href="https://leetcode.com/problems/sum-of-subarray-minimums/solutions/2700011/sum-of-subarray-minimums/">solution</a></li>
 *      <li>We will find the range for each element where it is smallest. So, essentially we need to find the next smallest element on both the sides.</li>
 *      <li>Now, to find an element's contribution focus on when we can start and when we can end an subarray s.t. the element is included in all the subarrays.</li>
 *      <li>Start will be all indexes before current element(included) and end will also be all indexes after current element(included).</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 * <b>Approach 2:</b>
 * <ul>
 *      <li>Intuition: DP + MonoStack</li>
 *      <li>We will build upon the solution of previous indexes while traversing from 0 to n.</li>
 *      <li>dp[i] will denote the answer for all the sub arrays that end at i.</li>
 *      <li>Use increasing mono stack to put all elements.</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 * </body>
 */

public class SumOfSubarrayMinimums {
    public static void main(String[] args) {
        System.out.println(sumSubarrayMins(new int[]{3, 1, 2, 4}));
        System.out.println(sumSubarrayMins(new int[]{71, 55, 82, 55}));
        System.out.println(sumSubarrayMins(new int[]{11, 81, 94, 43, 3}));
        System.out.println();
        System.out.println(sumSubarrayMins2(new int[]{3, 1, 2, 4}));
        System.out.println(sumSubarrayMins2(new int[]{71, 55, 82, 55}));
        System.out.println(sumSubarrayMins2(new int[]{11, 81, 94, 43, 3}));
    }

    public static int sumSubarrayMins(int[] arr) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        int n = arr.length, key, mod = 1000000007;
        ArrayList<Integer> val;
        long count, ans = 0;

        // find the smallest element on the left
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.getLast()] > arr[i]) {
                stack.removeLast();
            }
            ArrayList<Integer> temp = new ArrayList<>();
            if (stack.isEmpty()) {
                temp.add(0);
            } else {
                temp.add(stack.getLast() + 1);
            }
            map.put(i, temp);
            stack.addLast(i);
        }
        stack.clear();

        // find the smallest element on the right
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.getLast()] >= arr[i]) {
                stack.removeLast();
            }
            if (stack.isEmpty()) {
                map.get(i).add(n - 1);
            } else {
                map.get(i).add(stack.getLast() - 1);
            }
            stack.addLast(i);
        }

        // find an element's contribution in the range
        for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            key = entry.getKey();
            val = entry.getValue();
            count = ((long) (key - val.get(0) + 1) * (val.get(1) - key + 1)) % mod;
            ans += ((count * arr[key]) % mod);
            ans %= mod;
        }

        return (int) ans;
    }

    public static int sumSubarrayMins2(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = arr.length, mod = 1000000007;
        long ans = 0;
        long[] dp = new long[n];

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.getLast()] > arr[i]) {
                stack.removeLast();
            }
            if (stack.isEmpty()) {
                dp[i] = ((long) arr[i] * (i + 1)) % mod;
            } else {
                dp[i] = (dp[stack.getLast()] + ((long) arr[i] * (i - stack.getLast()))) % mod;
            }
            ans += dp[i];
            ans %= mod;
            stack.addLast(i);
        }

        return (int) ans;
    }

}
