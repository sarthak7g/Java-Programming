package array;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum/">Number of Sub-arrays With Odd Sum</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Update count of even and odd sums according to the prefix sum.</li>
 *      <li>If the sum is even, add odd_count to answer, else add even_count to the answer.</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(1)</li>
 * </ul>
 *
 */

public class NumberOfSubArraysWithOddSum {
    public static void main(String[] args) {
        System.out.println(numOfSubarrays(new int[]{1,3,5}));
        System.out.println(numOfSubarrays(new int[]{1,3,5,4,4,1}));
        System.out.println(numOfSubarrays(new int[]{1,4,9,3,8,5}));
    }

    public static int numOfSubarrays(int[] arr) {
        int even=1, odd=0;
        long ans=0, sum=0;

        for(int el : arr) {
            sum += el;
            if(sum % 2 == 0) {
                ans += odd;
                even++;
            } else {
                ans += even;
                odd++;
            }
        }


        return (int)(ans % 1000000007);
    }
}
