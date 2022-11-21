package array;

/**
 * <h3>Level: Easy</h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/find-the-middle-index-in-array/">Find the Middle Index in Array</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Hint: Prefix Sum</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 */

public class FindTheMiddleIndexInArray {
    public static void main(String[] args) {
        System.out.println(findMiddleIndex(new int[]{2,3,-1,8,4}));
        System.out.println(findMiddleIndex(new int[]{1,-1,4}));
        System.out.println(findMiddleIndex(new int[]{1,5}));
    }

    public static int findMiddleIndex(int[] nums) {
        int n=nums.length, sum=0;
        int[] right_sum = new int[n];
        for(int i=n-1; i>=0; i--) {
            sum += nums[i];
            right_sum[i] = sum;
        }
        sum=0;
        for(int i=0; i<n-1; i++) {
            if(sum == right_sum[i+1]) {
                return i;
            }
            sum += nums[i];
        }
        if(sum == 0) return n-1;
        return -1;
    }
}
