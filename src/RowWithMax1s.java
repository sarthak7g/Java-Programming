/**
 *
 * Level: Medium
 * refer to: https://practice.geeksforgeeks.org/problems/row-with-max-1s0023/1
 *
 * Approach:
 *      1) Find the leftmost 1 in the first row using binarySearch and save it in the curr_index.
 *      2) traverse each row :
 *          - check if val at curr_index-1 has 1 or not. If it's a 0, then skip or continue
 *          - else keep moving towards left until there is 1 on the left
 *          - do same for each row
 *
 * Time complexity: O(m + n)
 * Space complexity: O(1)
 *
 */

public class RowWithMax1s {
    public static void main(String[] args) {
        int matrix[][] = {{0, 0, 0, 0}, {0, 0, 0, 1}, {0, 0, 1, 1}, {0, 1, 1, 1}};
//        int matrix[][] = {{0, 0}, {0, 0}};

        System.out.println(rowWithMax1s(matrix, matrix.length, matrix[0].length));
    }

    private static int rowWithMax1s(int arr[][], int n, int m) {
        // find leftmost 1 in 1st row
        int index = binarySearchFirstOccurence(arr[0], m);
        if (index == 0) return 0;

        int k, max = 0;
        if (index == m) max = -1;

        System.out.println(index + ":" + max);
        for (int i = 1; i < n; i++) {
            k = index - 1;
            while (k >= 0 && arr[i][k] == 1) k--;
            if (k + 1 < index) max = i;
            index = k + 1;
            System.out.println(index + ":" + max);
            if (index == 0) return i;
        }
        return max;
    }

    private static int binarySearchFirstOccurence(int[] arr, int length) {
        int start = 0, end = length - 1;
        int mid;

        while (start < end) {
            mid = (start + end) / 2;
            if (arr[mid] == 1) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        if (arr[start] == 0) return length;

        return start;
    }
}
