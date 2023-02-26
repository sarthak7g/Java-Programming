package stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <h3>Level: Hard </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/maximum-score-of-a-good-subarray/description/">Maximum Score of a Good Subarray</a>
 * <br/>
 * <br/>
 * <b>Approach 1:</b>
 * <ul>
 *      <li>Hint: MS & Element Contribution approach. Find the left and right border where an element is min.</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 * <b>Approach 2:</b>
 * <ul>
 *      <li>Greedy approach(two pointers): Start with i=j=k, move i to left or j to right by comparing arr[i-1] and arr[j+1].</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(1)</li>
 * </ul>
 * </body>
 */

public class MaximumScoreOfAGoodSubarray {
    public static void main(String[] args) {
        System.out.println(maximumScore(new int[]{1, 4, 3, 7, 4, 5}, 3));
        System.out.println(maximumScore(new int[]{5, 5, 4, 5, 4, 1, 1, 1}, 0));
        System.out.println(maximumScore(new int[]{6569, 9667, 3148, 7698, 1622, 2194, 793, 9041, 1670, 1872}, 5));
        System.out.println();
        System.out.println(maximumScore2(new int[]{1, 4, 3, 7, 4, 5}, 3));
        System.out.println(maximumScore2(new int[]{5, 5, 4, 5, 4, 1, 1, 1}, 0));
        System.out.println(maximumScore2(new int[]{6569, 9667, 3148, 7698, 1622, 2194, 793, 9041, 1670, 1872}, 5));


    }

    public static int maximumScore(int[] nums, int k) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = nums.length, idx, ans = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[i] < nums[stack.getFirst()]) {
                idx = stack.remove();
                arr[idx] = i - 1;
            }
            stack.addFirst(i);
        }
        while (!stack.isEmpty()) {
            arr[stack.remove()] = n - 1;
        }

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] < nums[stack.getFirst()]) {
                idx = stack.remove();
                if (k <= arr[idx] && k > i) {
                    ans = Math.max(ans, (arr[idx] - i) * nums[idx]);
                }

            }
            stack.addFirst(i);
        }
        while (!stack.isEmpty()) {
            idx = stack.remove();
            if (k <= arr[idx]) {
                ans = Math.max(ans, (arr[idx] + 1) * nums[idx]);
            }

        }
        return ans;
    }

    public static int maximumScore2(int[] arr, int k) {
        int n = arr.length, ans = arr[k], i = k, j = k, tmp, min = arr[k];
        while (true) {
            if (i >= 1 && j < n - 1) {
                if (arr[i - 1] >= arr[j + 1]) {
                    i -= 1;
                    min = Math.min(arr[i], min);
                } else {
                    j += 1;
                    min = Math.min(arr[j], min);
                }
                tmp = min * (j - i + 1);
                ans = Math.max(ans, tmp);
            } else break;
        }

        while (i > 0) {
            i -= 1;
            min = Math.min(arr[i], min);
            tmp = min * (j - i + 1);
            ans = Math.max(ans, tmp);
        }

        while (j < n - 1) {
            j += 1;
            min = Math.min(arr[j], min);
            tmp = min * (j - i + 1);
            ans = Math.max(ans, tmp);
        }

        return ans;
    }
}
