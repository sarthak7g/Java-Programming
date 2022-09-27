package array;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/contiguous-array/">Contiguous SubArray</a>
 * <br/>
 * Approach:
 * <ul>
 *     <li>Use prefix sum concept and whenever prefix sum modulo k is same at two positions, i.e., we have a multiple of k in between</li>
 *     <li>for the constraint of subarray with at least two elements, check the position of same key - which should be 1 less than current position</li>
 *     <li>Time complexity: O(n)</li>
 *     <li>Space complexity: O(n)</li>
 * </ul>
 */

public class ContiguousSubarrayWithEqual0And1 {

    public static void main(String[] args) {
        System.out.println(findMaxLength(new int[] {1,1,1,1}));
        System.out.println(findMaxLength(new int[] {0,0,0,0,0}));
        System.out.println(findMaxLength(new int[] {0,0,1,1,0,0,1,0,1,1,0,1,0}));
    }

    public static int findMaxLength(int[] nums) {
        int zero=0, one=0, length=0, diff, k;
        int[] zarr = new int[nums.length+1];
        int[] oarr = new int[nums.length+1];

        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 0) {
                zero += 1;
                zarr[zero] = i;
            }else {
                one += 1;
                oarr[one] = i;
            }
            int minVal = Math.min(zero, one);
            if(minVal*2 <= length) {
                continue;
            }

            if(zero == one) {
                length = 2*zero;
                continue;
            }
            else if(zero > one) {
                diff = zero-one;
                k = i - zarr[diff];
            }else {
                diff = one-zero;
                k = i - oarr[diff];
            }

            if(minVal*2 == k) {
                // System.out.println(zero + " " + one + " " + k);
                length = k;
            }
        }

        // System.out.println(Arrays.toString(zarr));
        // System.out.println(Arrays.toString(oarr));

        return length;
    }
}
