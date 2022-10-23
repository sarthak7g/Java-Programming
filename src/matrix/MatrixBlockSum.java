package matrix;

import java.util.Arrays;

public class MatrixBlockSum {
    public static void main(String[] args) {
        int matrix[][] = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

//        Arrays.stream(matrixBlockSum(matrix, 1)).forEach(x -> Arrays.toString());
    }

    public static int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        int[][] arr = new int[m][n];
        int[][] ans = new int[m][n];

        int sum=0;

        for(int i=0; i<m; i++) {
            sum = 0;
            for(int j=0; j<n; j++) {
                sum += mat[i][j];

                arr[i][j] = i==0 ? sum : sum + arr[i-1][j];
            }
        }

        // Arrays.stream(mat).forEach(x -> System.out.println(Arrays.toString(x)));

        int row1, row2, col1, col2;
        for(int i=0; i<m; i++) {

            row1 = Math.max(i-k, 0);
            row2 = Math.min(i+k, m-1);

            for(int j=0; j<n; j++) {
                col1 = Math.max(j-k, 0);
                col2 = Math.min(j+k, n-1);

                // System.out.println(String.format("Area for [%s...%s][%s...%s]", row1, row2, col1, col2));

                ans[i][j] = arr[row2][col2];

                if(row1 > 0) {
                    ans[i][j] -= arr[row1-1][col2];
                }

                if(col1 > 0) {
                    ans[i][j] -= arr[row2][col1-1];
                }
                if(row1 > 0 && col1 > 0) {
                    ans[i][j] += arr[row1-1][col1-1];
                }

            }
        }


        return ans;
    }
}
