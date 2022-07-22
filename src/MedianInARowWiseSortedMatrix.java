import java.util.Arrays;

/**
 *
 * Level: Hard
 * refer to: https://practice.geeksforgeeks.org/problems/median-in-a-row-wise-sorted-matrix1527/1
 *
 * Approach:
 *      1) Their will be at least n/2 number of elements that are less than equal to median.
 *      2) So, we are going to find an element between minimum of whole matrix and maximum of whole matrix using binary search,
 *      that satisfies the above condition
 *
 * Time complexity: O(32 * R * log(C))
 * Space complexity: O(1)
 *
 */

public class MedianInARowWiseSortedMatrix {
    public static void main(String[] args) {
        int arr[][] = {{4, 6, 7,}, {8, 8, 9,}, {3, 5, 9}};
        System.out.println(median(arr, arr.length, arr[0].length));
    }
    private static int median(int arr[][], int r, int c) {
        // find min and max value
        int minVal = Integer.MAX_VALUE, maxVal = Integer.MIN_VALUE;
        for(int i=0; i<r; i++) {
            minVal = Math.min(minVal, arr[i][0]);
        }

        for(int i=0; i<r; i++) {
            maxVal = Math.max(maxVal, arr[i][c-1]);
        }


        int mid, index, sum, nums = (r*c + 1)/2;
        while(minVal<maxVal) {
            mid = (minVal + maxVal)/2;
            sum = 0;
            for(int i=0; i<r; i++) {
                index = Arrays.binarySearch(arr[i], mid);
                // System.out.println(index);
                if(index < 0) {
                    index *= -1;
                    index -= 1;
                }
                else {
                    while(index < c && arr[i][index] == mid) {
                        index += 1;
                    }
                }
                sum += index;
            }

            // System.out.println(sum);
            if(sum<nums) {
                minVal = mid + 1;
            }
            else {
                maxVal = mid;
            }

        }

        return minVal;
    }
}
