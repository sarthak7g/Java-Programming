import java.util.ArrayList;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: https://practice.geeksforgeeks.org/problems/spirally-traversing-a-matrix-1587115621/1
 * <p>
 * Time complexity: O(n^2) <br/>
 * </p>
 * </body>
 */
public class SpiralTraversalMatrix {
    public static void main(String[] args) {
        int matrix[][] = {{1, 2, -1, -4, -20},
                {-8, -3, 4, 2, 1},
                {3, 8, 6, 1, 3},
                {-4, -1, 1, 7, -6},
                {0, -4, 10, -5, 1}};
        int matrix1[][] = {{1, 2, 3}};
        int matrix2[][] = {{-1}, {-4}, {-7}};
        System.out.println(spirallyTraverse(matrix, matrix.length, matrix[0].length));
        System.out.println(spirallyTraverse(matrix1, matrix1.length, matrix1[0].length));
        System.out.println(spirallyTraverse(matrix2, matrix2.length, matrix2[0].length));
    }

    static ArrayList<Integer> spirallyTraverse(int arr[][], int r, int c) {
        // code here
        int rstart = 0, rend = r - 1;
        int cstart = 0, cend = c - 1;
        ArrayList<Integer> al = new ArrayList<>();

        while (rstart < rend && cstart < cend) {
            int count = 0;
            while (count < 4) {
                if (count % 4 == 0) {
                    // l to r
                    for (int i = cstart; i <= cend; i++) {
                        al.add(arr[rstart][i]);
                    }
                } else if (count % 4 == 1) {
                    // t to d
                    for (int i = rstart + 1; i <= rend - 1; i++) {
                        al.add(arr[i][cend]);
                    }
                } else if (count % 4 == 2) {
                    // r to l
                    for (int i = cend; i >= cstart; i--) {
                        al.add(arr[rend][i]);
                    }
                } else {
                    // d to t
                    for (int i = rend - 1; i >= rstart + 1; i--) {
                        al.add(arr[i][cstart]);
                    }
                }
                count += 1;
            }

            rstart++;
            rend--;
            cstart++;
            cend--;
        }

        if (cstart == cend && rstart == rend) {
            al.add(arr[rstart][cstart]);
        } else if (cstart == cend) {
            for (int i = rstart; i <= rend; i++) {
                al.add(arr[i][cend]);
            }
        } else if (rstart == rend) {
            for (int i = cstart; i <= cend; i++) {
                al.add(arr[rstart][i]);
            }
        }
        return al;

    }
}
