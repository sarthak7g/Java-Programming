/**
 * <h3>Level: Easy </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array/">Remove Duplicates from Sorted Array</a>
 * <br/>
 * Approach:
 *      <ul>
 *          <li>Maintain two pointers both starting at 1</li>
 *          <li>if arr[i-1] == arr[j] then, arr[i] = arr[j] & increment i & j</li>
 *          <li>else increment j</li>
 *          <li>Time complexity: O(N)</li>
 *          <li>Space complexity: O(1)</li>
 *      </ul>
 */

public class RemoveDuplicatesFromSortedArrays {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1,1,2,3,3,4}));
        System.out.println(removeDuplicates(new int[]{1,2,2,3,4}));
        System.out.println(removeDuplicates(new int[]{1,2,3}));
    }
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 1)
            return 1;
        int i = 1, j = 1;
        while (j < nums.length) {
            if (nums[i - 1] == nums[j]) {
                j++;
            } else {
                nums[i] = nums[j];
                i++;
                j++;
            }
        }
        return i;
    }
}
