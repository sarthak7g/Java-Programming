package array;

import java.util.Arrays;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/">Minimum Operations to Reduce X to Zero</a>
 * <br/>
 * <br/>
 * <b>Approach 1:</b>
 * <ul>
 *      <li>Create forward sum array.</li>
 *      <li>Now, traverse the array from the back, use binarySearch to find x-back_sum in fwd_sum array.</li>
 *      <li>Time complexity: O(n*log(n))</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 */


public class MinimumOperationsToReduceXToZero {

    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{3,2,20,1,1,3}, 10));
        System.out.println(minOperations(new int[]{8828,9581,49,9818,9974,9869,9991,10000,10000,10000,9999,9993,9904,8819,1231,6309}, 134365));
        System.out.println(minOperations(new int[]{5,3,2,1,1}, 5));
    }

    public static int minOperations(int[] nums, int x) {
        int n=nums.length;
        long[] fsum = new long[n];
        fsum[0] = nums[0];
        for(int i=1; i<n; i++) {
            fsum[i] = fsum[i-1] + nums[i];
        }

        // System.out.println(Arrays.toString(fsum));

        int ans = n+1, index;
        long sum=0;
        for(int i=n-1; i>=0; i--) {
            sum += nums[i];
            if(sum > x) break;

            else if(x-sum == 0) {
                ans = Math.min(ans, n-i);
                continue;
            }
            index = Arrays.binarySearch(fsum, 0, i, x-sum);
            // System.out.println(sum + " " + index);
            if(index >= 0) ans = Math.min(ans, n-i+index+1);
        }

        index = Arrays.binarySearch(fsum, x);
        if(index >= 0) ans = Math.min(ans, index+1);

        if(ans == n+1) return -1;
        return ans;
    }
}
