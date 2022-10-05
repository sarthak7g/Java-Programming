package array;

/**
 * <h3>Level: Easy </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/find-pivot-index/">Find Pivot Index</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Compare forward prefix sum with backward prefix sum.</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 *
 */

public class PivotIndex {

    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
        System.out.println(pivotIndex(new int[]{1, 2, 3}));
        System.out.println(pivotIndex(new int[]{2, 1, -1}));
        System.out.println(pivotIndex(new int[]{-1, -1, 0, 1, 1, -1}));
        System.out.println(pivotIndex(new int[]{-1, -1, 0, 0, -1, -1}));
    }

    public static int pivotIndex(int[] nums) {
        int[] arr = new int[nums.length];
        for (int j = nums.length - 2; j >= 0; j--) {
            arr[j] = arr[j + 1] + nums[j + 1];
        }

        if (arr[0] == 0) return 0;
        arr[0] = 0;

        int temp;

        for (int i = 1; i < nums.length; i++) {
            temp = arr[i - 1] + nums[i - 1];
            if (arr[i] == temp) {
                return i;
            }
            arr[i] = temp;
        }

        return -1;
    }

}
