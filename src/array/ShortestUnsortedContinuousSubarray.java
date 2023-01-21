package array;

import java.util.Stack;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/shortest-unsorted-continuous-subarray/description/">Shortest Unsorted Continuous Subarray</a>
 * <br/>
 * <br/>
 * <b>Approach 1:</b>
 * <ul>
 *      <li>Hint: MS</li>
 *      <li>Start from RHS. Find the right boundary(high) which is the highest popped index from the stack.</li>
 *      <li>In the same traversal from right, to find the left boundary we just need to check if the curr element is greater than the min element obtained so far, because if the array is sorted the curr element should be minimum.</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 * <b>Approach 2:</b>
 * <ul>
 *      <li>The idea behind this method is that the correct position of the minimum element in the unsorted subarray helps to determine the required left boundary. Similarly, the correct position of the maximum element in the unsorted subarray helps to determine the required right boundary.</li>
 *      <li>refer <a href="https://leetcode.com/problems/shortest-unsorted-continuous-subarray/solutions/127627/shortest-unsorted-continous-subarray/">solution</a></li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(1)</li>
 * </ul>
 */

public class ShortestUnsortedContinuousSubarray {
    public static void main(String[] args) {
        System.out.println(findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
        System.out.println(findUnsortedSubarray(new int[]{1, 2, 3, 4}));
        System.out.println(findUnsortedSubarray(new int[]{1}));
        System.out.println(findUnsortedSubarray(new int[]{1, 3, 5, 2, 4}));
        System.out.println();
        System.out.println(findUnsortedSubarray2(new int[]{2, 6, 4, 8, 10, 9, 15}));
        System.out.println(findUnsortedSubarray2(new int[]{1, 2, 3, 4}));
        System.out.println(findUnsortedSubarray2(new int[]{1}));
        System.out.println(findUnsortedSubarray2(new int[]{1, 3, 5, 2, 4}));
    }

    public static int findUnsortedSubarray(int[] arr) {
        Stack<Integer> s = new Stack<>();
        int n = arr.length, low = n - 1, high = 0, curr = 0, min = arr[n - 1];
        for (int j = n - 1; j >= 0; j--) {
            min = Math.min(min, arr[j]);
            while (!s.empty() && arr[j] > arr[s.peek()]) {
                curr = s.pop();
            }
            high = Math.max(high, curr);
            if (arr[j] > min) low = j;
            s.push(j);
            // System.out.println(j + " " + low + " " + high);
        }
        if (s.size() == n) return 0;
        return high - low + 1;
    }

    public static int findUnsortedSubarray2(int[] arr) {
        int i=1, n=arr.length, j, min=arr[n-1], max=arr[0];
        while(i<n && arr[i] >= arr[i-1]) i++;
        if(i == n) return 0;
        while(i < n) {
            min = Math.min(min, arr[i]);
            i++;
        }

        i = n-2;
        while(i>=0 && arr[i] <= arr[i+1]) i--;
        while(i >= 0) {
            max = Math.max(arr[i], max);
            i--;
        }

        // System.out.println(min + " " + max);
        for(i=0; i<n; i++) {
            if(min<arr[i]) break;
        }
        for(j=n-1; j>=0; j--) {
            if(max > arr[j]) break;
        }

        return j-i+1;
    }
}
