package array;

/**
 * <h3>Level: Easy </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/remove-one-element-to-make-the-array-strictly-increasing/description/">Remove One Element to Make the Array Strictly Increasing</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Have a boolean flag to make sure only one value can be changed.</li>
 *      <li>Compare the current element with prev 2 elems. If it is less than both, then curr elem has to be removed else if it less than only prev then remove prev only.</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(1)</li>
 * </ul>
 */

public class RemoveOneElementToMakeArrayStrictlyIncreasing {
    public static void main(String[] args) {
        System.out.println(canBeIncreasing(new int[]{1, 2, 10, 5, 7}));
        System.out.println(canBeIncreasing(new int[]{2, 3, 1, 27}));
        System.out.println(canBeIncreasing(new int[]{1, 1, 1}));
    }

    public static boolean canBeIncreasing(int[] nums) {
        boolean flag = true;
        int prev = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                if (flag) {
                    if (nums[i] <= prev) {
                        nums[i] = nums[i - 1];
                    } else {
                        nums[i - 1] = prev;
                    }
                    flag = false;
                } else return false;
            }
            prev = nums[i - 1];
        }
        return true;
    }
}
