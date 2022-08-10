/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://practice.geeksforgeeks.org/problems/largest-square-formed-in-a-matrix0806/1">Largest square formed in a matrix</a>
 * <br/>
 * Approach :
 *      <ul>
 *          <li>Start traversing from the bottom right</li>
 *          <li>if arr[i][j] is 1, then arr[i][j] = min(arr[i][j + 1], arr[i + 1][j], arr[i + 1][j + 1]) + 1</li>
 *      </ul>
 * Time complexity: O(n^2) <br/>
 * Auxiliary Space: O(1)
 * </body>
 */

public class LargestSquareFormedInAMatrix {
    public static void main(String[] args) {
        int matrix[][] = {{1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}};
        System.out.println(maxSquare(matrix.length, matrix[0].length, matrix));
    }

    static int maxSquare(int n, int m, int arr[][]) {
        // code here
        int max = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (i == n - 1 || j == m - 1 || arr[i][j] == 0) {
                    max = Math.max(arr[i][j], max);
                    continue;
                }
                int val = min(arr[i][j + 1], arr[i + 1][j], arr[i + 1][j + 1]) + 1;
                max = Math.max(val, max);
                arr[i][j] = val;
            }
        }
        return max;
    }

    static int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
