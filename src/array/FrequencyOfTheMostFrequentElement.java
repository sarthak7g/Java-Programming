package array;

import java.util.Arrays;

/**
 * <h3>Level: Medium</h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/frequency-of-the-most-frequent-element/"> Frequency of the Most Frequent Element</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Sliding window approach- satisfy this condition, i.e., k + sum >= arr[right]*(right-left+1)</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(1)</li>
 * </ul>
 */

public class FrequencyOfTheMostFrequentElement {
    public static void main(String[] args) {
        System.out.println(maxFrequency(new int[]{1, 2, 4}, 5));
        System.out.println(maxFrequency(new int[]{1, 1, 2, 2, 2, 4, 4, 4, 5}, 11));
    }

    public static int maxFrequency(int[] arr, int k) {
        Arrays.sort(arr);
        int left = 0, right = 0, ans = 1, n = arr.length;
        long sum = 0;
        while (right < n && left <= right) {
            sum += arr[right];
            if (sum + k >= (long) (right - left + 1) * arr[right]) {
                ans = Math.max(ans, right - left + 1);
            } else {
                sum -= arr[left++];
            }
            right++;
        }
        return ans;
    }
}
