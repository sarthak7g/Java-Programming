package array;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/minimum-size-subarray-sum/">Minimum Size Subarray Sum</a>
 * <br/>
 * Approach:
 *      <ul>
 *          <li>Use 2 pointers at window extremes</li>
 *          <li>Time complexity: O(n)</li>
 *      </ul>
 */

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        System.out.println(minSubArrayLen(11, new int[]{1,1,1,1,1,1,1}));
        System.out.println(minSubArrayLen(7, new int[]{1,1,1,1,1,1,1}));
        System.out.println(minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
        System.out.println(minSubArrayLen(4, new int[]{1,4,4}));
    }
    public static int minSubArrayLen(int target, int[] arr) {
        if(arr[0] >= target) return 1;

        if(arr.length == 1) return 0;

        int i=0, j=1, sum=arr[0]+arr[1], minLength = arr.length+1;
        while(j<arr.length) {

            if(sum >= target) {
                minLength = Math.min(j-i+1, minLength);
                if(minLength == 1) return 1;
                sum -= arr[i++];
            }
            else {
                if(j == arr.length-1) break;
                sum += arr[++j];
            }
        }
        return minLength==arr.length+1 ? 0 : minLength;
    }
}
