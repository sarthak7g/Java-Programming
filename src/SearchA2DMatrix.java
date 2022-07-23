/**
 *
 * Level: Medium
 * refer to: https://leetcode.com/problems/search-a-2d-matrix/
 *
 * Approach:
 *      1) Use binary search on first elements of rows to find out which row it belongs
 *      2) Use binary search on the found row again
 *
 * Time complexity: O(log(m) + log(n))
 * Space complexity: O(1)
 *
 */

public class SearchA2DMatrix {
    public static void main(String args[] ) throws Exception {

        int matrix[][] = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(searchMatrix(matrix, 35));
        System.out.println(searchMatrix(matrix, 0));
        System.out.println(searchMatrix(matrix, 65));
        System.out.println(searchMatrix(matrix, 17));
        System.out.println(searchMatrix(matrix, 60));

    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int place = rowBinarySearch(matrix, target);
        if(place == -1) return false;
        if(place<0) {
            place = place*(-1) - 2;
        }else return true;

        // System.out.println(Arrays.toString(matrix[place]));
        int ans = colBinarySearch(matrix[place], target);
        if(ans<0) return false;
        return true;
    }


    //     1 3, 2 -> 1,0 -> -2 (start+1)*-1
    //     1 3, 4 -> 2,1 -> -3
    //     1 3, 0 -> 0,-1 -> -1
    private static int rowBinarySearch(int[][] matrix, int target) {
        int start=0, end=matrix.length-1;
        int mid=0;
        while(start<=end) {
            mid = (start+end)/2;
            if(matrix[mid][0] == target) {
                return mid;
            }
            if(matrix[mid][0] < target) {
                start = mid + 1;
            }
            else end = mid - 1;
        }
        return (start+1)*-1;
    }

    private static int colBinarySearch(int[] arr, int target) {
        int start=0, end=arr.length-1;
        int mid=0;
        while(start<=end) {
            mid = (start+end)/2;
            if(arr[mid] == target) {
                return mid;
            }
            if(arr[mid] < target) {
                start = mid + 1;
            }
            else end = mid - 1;
        }

        return (start+1)*-1;
    }

}
