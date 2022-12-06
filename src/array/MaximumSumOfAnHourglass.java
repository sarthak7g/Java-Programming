package array;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/maximum-sum-of-an-hourglass/description/">Maximum Sum of an Hourglass</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Hint: Calculate prefix sum</li>
 *      <li>Time complexity: O(n^2)</li>
 *      <li>Space complexity: O(n^2)</li>
 * </ul>
 */

public class MaximumSumOfAnHourglass {
    public static void main(String[] args) {
        System.out.println(maxSum(new int[][]{{6,2,1,3},{4,2,1,5},{9,2,8,7},{4,1,2,9}}));
        System.out.println(maxSum(new int[][]{{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}}));
    }

    public static int maxSum(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        int[][] arr = new int[m][n+1];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                arr[i][j+1] = arr[i][j] + grid[i][j];
            }
        }

        int max = 0, temp;
        for(int i=0; i<m-2; i++) {
            for(int j=0; j<n-2; j++) {
                temp = arr[i][j+3]-arr[i][j]
                        + arr[i+2][j+3]-arr[i+2][j]
                        + grid[i+1][j+1];
                max = Math.max(max, temp);

            }
        }

        return max;
    }
}
