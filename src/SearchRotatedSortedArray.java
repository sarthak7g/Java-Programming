
/**
 *
 * Level: Medium
 * refer to: https://workat.tech/problem-solving/practice/search-rotated-array
 *
 * Approach - Find the point of separation and then apply binary search on both halves
 *
 * Time complexity: O(log(n))
 *
 */

public class SearchRotatedSortedArray {

    public static void main(String[] args) {
        System.out.println(getElementIndex(new int[]{9, 1, 2, 4, 7}, 4));
    }
    static int getElementIndex(int[] arr, int target) {
        // find the point of separation
        int n = arr.length;
        int i = findPointOfSeparation(arr, 0, n-1);
//        System.out.println("separation was at index: " + i);

        if (i == 0 && target == arr[i]) {
            return 0;
        }
        if (i == n - 2 && target == arr[n - 1]) {
            return n - 1;
        }

        if (i == -1) {
            return binarySearch(arr, 0, n - 1, target);
        }

        return Math.max(binarySearch(arr, 0, i, target),
                binarySearch(arr, i + 1, n - 1, target));

    }

    static int findPointOfSeparation(int[] arr, int start, int end) {
        int mid = (start + end)/2;
        while (start<=end) {
            if(mid-1 >= start && arr[mid] < arr[mid-1]) {
                return mid-1;
            }
            if(mid+1 <= end && arr[mid] > arr[mid+1]) {
                return mid;
            }

            if(arr[mid] > arr[end])
                start = mid+1;

            else end = mid-1;

            mid = (start+end)/2;
        }
        return -1;
    }

    static int binarySearch(int[] arr, int start, int end, int target) {

        int mid = (start + end) / 2;
        while (start <= end) {
            if (arr[mid] == target)
                return mid;
            if (arr[mid] > target)
                end = mid - 1;
            else start = mid + 1;

            mid = (start + end) / 2;
        }
        return -1;
    }
}
