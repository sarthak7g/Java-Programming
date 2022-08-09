import java.util.Arrays;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/rotate-image/">Rotate Matrix by 90 degree</a>
 * <br/>
 * Approach :
 *      <ul>
 *          <li>Take transpose of matrix, then</li>
 *          <li>Reverse each row</li>
 *      </ul>
 * Time complexity: O(n^2) <br/>
 * Auxiliary Space: O(1)
 * </body>
 */

public class RotateMatrixBy90 {
    public static void main(String[] args) {
        int matrix[][] = {{10, 20, 30, 40}, {15, 25, 35, 45}, {24, 29, 37, 48}, {32, 33, 39, 50}};
        Arrays.asList(matrix).forEach(ints -> System.out.println(Arrays.toString(ints)));
        rotate(matrix);
        System.out.println("After rotation");
        Arrays.asList(matrix).forEach(ints -> System.out.println(Arrays.toString(ints)));
    }
    public static void rotate(int[][] arr) {
        int n = arr.length, temp;
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                // swap
                temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        int left, right;
        for(int i=0; i<n; i++) {
            // reverse
            left = 0;
            right = n-1;
            while(left<right){
                // swap
                temp = arr[i][left];
                arr[i][left] = arr[i][right];
                arr[i][right] = temp;
                left ++;
                right --;

            }

        }

    }
}
