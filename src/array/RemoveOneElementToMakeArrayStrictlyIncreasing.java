package array;

public class RemoveOneElementToMakeArrayStrictlyIncreasing {
    public static void main(String[] args) {
        System.out.println(canBeIncreasing(new int[]{1, 2, 10, 5, 7}));
        System.out.println(canBeIncreasing(new int[]{2, 3, 1, 27}));
        System.out.println(canBeIncreasing(new int[]{1, 1, 1}));
    }

    public static boolean canBeIncreasing(int[] nums) {
        boolean flag = true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                if (flag) {
                    nums[i] = nums[i - 1];
                    flag = false;
                } else return false;
            }
        }
        return true;
    }
}
