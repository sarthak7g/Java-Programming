/**
 *
 * Level: Medium
 * refer to: https://leetcode.com/problems/search-a-2d-matrix-ii/
 *
 * Approach I:
 *      1) Traverse through the matrix diagonally
 *          a) find the last column that can have the target
 *          b) find the last row that can have the target
 *
 * Time complexity: O(m * log(n))
 * Space complexity: O(1)
 *
 * Approach II:
 *      1) Traverse from cell (0, n-1)
 *          a) if mat[cell] == target, return true
 *          b) if target < mat[cell], move left
 *          c) if target > mat[right], move right
 *
 * Time complexity: O(m+n)
 * Space complexity: O(1)
 *
 *
 */

public class SearchA2DMatrix2 {
    public static void main(String[] args) {
        int matrix[][] = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        System.out.println(searchMatrix(matrix, 0));
        System.out.println(searchMatrix2ndApproach(matrix, 0));

        System.out.println(searchMatrix(matrix, 15));
        System.out.println(searchMatrix2ndApproach(matrix, 15));

        System.out.println(searchMatrix(matrix, 22));
        System.out.println(searchMatrix2ndApproach(matrix, 22));

        System.out.println(searchMatrix(matrix, 13));
        System.out.println(searchMatrix2ndApproach(matrix, 13));

        System.out.println(searchMatrix(matrix, 180));
        System.out.println(searchMatrix2ndApproach(matrix, 180));

        System.out.println(searchMatrix(matrix, 30));
        System.out.println(searchMatrix2ndApproach(matrix, 30));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        int endRow=matrix.length-1, endCol = matrix[0].length-1;
        int startCol=0, startRow=0;
        int rowVal, colVal;

        while(startCol<=endCol && startRow<=endRow) {
            colVal = rowBinarySearch(matrix[startCol], target, startCol, endCol);
            // System.out.println(colVal);
            if(colVal >= 0) return true;
            endCol = (colVal+2)*-1;

            rowVal = colBinarySearch(matrix, target, startRow, endRow, startCol);
            if(rowVal >= 0) return true;
            endRow = (rowVal+2)*-1;

            startRow += 1;
            startCol += 1;
        }
        return false;
    }

    private static int rowBinarySearch(int arr[], int target, int start, int end) {
        int mid;
        while(start<=end) {
            mid = (start+end)/2;
            if(target == arr[mid]) return mid;

            if(target > arr[mid]) {
                start = mid+1;
            }
            else end = mid-1;
        }

        return (start+1)*-1;
    }

    private static int colBinarySearch(int[][] matrix, int target, int start, int end, int col) {
        int mid=0;
        while(start<=end) {
            mid = (start+end)/2;
            if(matrix[mid][col] == target) {
                return mid;
            }
            if(matrix[mid][col] < target) {
                start = mid + 1;
            }
            else end = mid - 1;
        }
        return (start+1)*-1;
    }

    public static boolean searchMatrix2ndApproach(int[][] mat, int target) {
        int row=0, col=mat[0].length-1;
        while(row<mat.length && col>=0) {
            if(target == mat[row][col]) {
                return true;
            }
            if(target < mat[row][col]) {
                col -= 1;
            }
            else row += 1;
        }
        return false;
    }


}
