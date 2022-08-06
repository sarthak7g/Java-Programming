/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: https://www.codingninjas.com/codestudio/problems/find-a-specific-pair-in-the-matrix_1115467?leftPanelTab=0
 * <p>
 * <h4>Approach:</h4>
 * <ul>
 *      <li>Start traversing from the bottom right element,</li>
 *      <li>At each (i, j) store the max element of sub matrix from (i, j) to (n-1, n-1)</li>
 * </ul>
 * Time complexity: O(n^2) <br/>
 * </p>
 * </body>
 */

public class FindASpecificPairInMatrix {
    public static void main(String[] args) {
        int matrix[][] = {{1, 2, -1, -4, -20},
                {-8, -3, 4, 2, 1},
                {3, 8, 6, 1, 3},
                {-4, -1, 1, 7, -6},
                {0, -4, 10, -5, 1}};
        int matrix1[][] = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        int matrix2[][] = {{-1, -2, -3},
                {-4, -5, -6},
                {-7, -8, -9}};
        System.out.println(findMaxValue(matrix, matrix.length));
        System.out.println(findMaxValue(matrix1, matrix1.length));
        System.out.println(findMaxValue(matrix2, matrix2.length));
    }

    public static int findMaxValue(int mat[][], int n) {
        int max = Integer.MIN_VALUE;
        int val;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == n - 1 && j == n - 1) {
                    continue;
                } else if (i == n - 1) {
                    val = Math.max(mat[i][j], mat[i][j + 1]);
                } else if (j == n - 1) {
                    val = Math.max(mat[i][j], mat[i + 1][j]);
                } else {
                    val = max(mat[i][j], mat[i + 1][j], mat[i][j + 1]);
                }
                if (i < n - 1 && j < n - 1) {
                    max = Math.max(mat[i + 1][j + 1] - mat[i][j], max);
                }
                mat[i][j] = val;
            }
        }
        return max;
    }

    private static int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
}
