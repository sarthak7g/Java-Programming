package array;

public class MaximumBinaryTree {

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        System.out.println();
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return solve(nums, 0, nums.length-1);
    }

    public static TreeNode solve(int[] arr, int l, int r) {
        if(l > r) return null;

        if(l == r) return new TreeNode(arr[l]);

        int max = arr[l], maxIdx = l;
        for(int i=l+1; i<=r; i++) {
            if(arr[i] > max) {
                max = arr[i];
                maxIdx = i;
            }
        }

        TreeNode ans = new TreeNode(max);
        ans.left = solve(arr, l, maxIdx-1);
        ans.right = solve(arr, maxIdx+1, r);
        return ans;
    }

    public static void printTree(TreeNode node) {

    }
}
