/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/range-sum-query-2d-immutable/">Range Sum Query 2D</a>
 * <br/>
 * Approach:
 *      <ul>
 *          <li>Use an array to store the sum s.t. sum[i][j] will denote the sum of rectangle formed by [(0, 0), (i, j)]</li>
 *      </ul>
 */

public class RangeSumQuery2D {

    public static void main(String[] args) {
        RangeSumQuery2D obj = new RangeSumQuery2D(new int[][]{{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}});
        System.out.println(obj.sumRegion(2,1,4,3));
        System.out.println(obj.sumRegion(1,1,2,2));
        System.out.println(obj.sumRegion(1,2,2,4));
    }
    int[][] sum;
    public RangeSumQuery2D(int[][] arr) {
        sum = new int[arr.length][arr[0].length];

        for(int i=0; i<arr.length; i++) {
            int s = 0;
            for(int j=0; j<arr[i].length; j++) {
                s += arr[i][j];
                sum[i][j] = i>0 ? sum[i-1][j] + s : s;
            }
        }
        // Arrays.stream(sum).forEach(a -> System.out.println(Arrays.toString(a)));
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int val = sum[row2][col2];
        if(col1>0)
            val -= sum[row2][col1-1];

        if(row1>0)
            val -= sum[row1-1][col2];

        if(col1>0 && row1>0)
            val += sum[row1-1][col1-1];

        return val;
    }
}
