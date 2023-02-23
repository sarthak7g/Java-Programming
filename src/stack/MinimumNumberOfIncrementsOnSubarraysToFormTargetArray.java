package stack;

public class MinimumNumberOfIncrementsOnSubarraysToFormTargetArray {
    public static void main(String[] args) {
        System.out.println(minNumberOperations(new int[]{1, 2, 3, 2, 1}));
        System.out.println(minNumberOperations(new int[]{3, 1, 1, 2}));
        System.out.println(minNumberOperations(new int[]{3, 1, 5, 4, 2}));
        System.out.println(minNumberOperations(new int[]{15, 14, 13, 5, 7, 9, 6, 3, 12}));
        System.out.println(minNumberOperations(new int[]{15, 14, 13, 5, 7, 9, 6, 8, 12}));
    }

    public static int minNumberOperations(int[] arr) {
        int n = arr.length, i = 1, curr = arr[0], ans = 0;
        while (i < n) {
            while (i < n && arr[i] >= curr) i++;
            curr = arr[i - 1];
            ans += curr;

            while (i < n && arr[i] <= curr) i++;
            curr = arr[i - 1];
            ans -= curr;
        }
        return ans;
    }
}
