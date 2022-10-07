package array;

import java.util.Arrays;

/**
 * <h3>Level: Easy </h3>
 * <body>
 * refer to: <a href="https://practice.geeksforgeeks.org/problems/maximize-sum-after-k-negations/0">Maximize sum after K negations</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Hint: Sort array</li>
 *      <li>Time complexity: O(n * log n)</li>
 *      <li>Space complexity: O(1)</li>
 * </ul>
 *
 */

public class MaximizeSum {

    public static void main(String[] args) {
        System.out.println(maximizeSum(new long[]{5, -2, 5, -4, 5, -12, 5, 5, 5, 20}, 10, 5));
    }

    public static long maximizeSum(long[] arr, int n, int k)
    {
        Arrays.sort(arr);
        int i=0;
        while(k>0 && i<n && arr[i]<0) {
            arr[i] *= -1;
            i++;
            k--;
        }

        if(k % 2 == 1) {
            Arrays.sort(arr);
            arr[0] *= -1;
        }

        long sum=0;
        for(long num : arr) {
            sum += num;
        }

        return sum;
    }
}
