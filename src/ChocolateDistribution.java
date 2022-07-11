import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * Level: Easy
 * refer to: https://practice.geeksforgeeks.org/problems/chocolate-distribution-problem3825/1#
 *
 * Time complexity: O(nlogn)
 * Space complexity: O(1)
 */

public class ChocolateDistribution {

    public static void main(String[] args) {

        List<Integer> arr = Arrays.asList(3, 4, 1, 9, 56, 7, 9, 12);
        System.out.println(findMinDiff(arr, arr.size(), 4));
    }

    public static long findMinDiff (List<Integer> arr, int n, int m)
    {
        if(m==1) return 0;
        Collections.sort(arr);
        int minVal = Integer.MAX_VALUE;
        for(int i=0; i<n-m+1; i++) {
            minVal = Math.min(minVal, arr.get(i+m-1)-arr.get(i));
        }
        return minVal;

    }
}
