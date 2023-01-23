package array;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/maximum-binary-tree/description/">Maximum Binary Tree</a>
 * <br/>
 * <br/>
 * <b>Approach 1:</b>
 * <ul>
 *      <li>Recursive solution</li>
 *      <li>Time complexity: Worst case (sorted array) O(n^2)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 * <b>Approach 2:</b>
 * <ul>
 *      <li>Recursive solution with query from segment tree.</li>
 *      <li>It is found out that the T(n) of this solution is more than that of previous solution. Think why?</li>
 *      <li>Time complexity: O(n^2)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 */

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
        @Override
        public String toString() {
            return "TreeNode{" +
                    "data=" + data +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public static void main(String[] args) {
        System.out.println(constructMaximumBinaryTree(new int[] {3,2,1,6,0,5}));
        System.out.println(constructMaximumBinaryTree2(new int[] {3,2,1,6,0,5}));

        System.out.println(constructMaximumBinaryTree(new int[] {3,2,1}));
        System.out.println(constructMaximumBinaryTree2(new int[] {3,2,1}));
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


    /**
     * Approach 2:
     */

    public static TreeNode constructMaximumBinaryTree2(int[] nums) {
        int n = nums.length;
        int[] seg = new int[4*n];
        buildSeg(seg, nums, 0, 0, n-1);
        return solveWithSegmentTree(seg, nums, 0, n-1);
    }

    public static TreeNode solveWithSegmentTree(int[] seg, int[] arr, int l, int r) {
        if(l > r) return null;

        if(l == r) return new TreeNode(arr[l]);

        int maxIdx = query(seg, arr, 0, arr.length-1, l, r, 0);

        TreeNode ans = new TreeNode(arr[maxIdx]);
        ans.left = solveWithSegmentTree(seg, arr, l, maxIdx-1);
        ans.right = solveWithSegmentTree(seg, arr, maxIdx+1, r);
        return ans;
    }
    public static void buildSeg(int[] seg, int[] arr, int idx, int l, int r) {
        if(l > r) return;
        if(l == r) {
            seg[idx] = l;
            return;
        }
        int mid = (l+r)/2;
        buildSeg(seg, arr, 2*idx+1, l, mid);
        buildSeg(seg, arr, 2*idx+2, mid+1, r);

        if(arr[seg[2*idx+1]] > arr[seg[2*idx+2]])
            seg[idx] = seg[2*idx+1];
        else seg[idx] = seg[2*idx+2];
    }

    public static int query(int[] seg, int[] arr, int l, int r, int first, int sec, int idx) {
        if(l > sec || first > r) return -1;
        if(l >= first  && r <= sec) return seg[idx];

        if(l == r) return seg[idx];

        int mid = (l+r)/2;
        int leftAns = query(seg, arr, l, mid, first, sec, 2*idx+1);
        int rightAns = query(seg, arr, mid+1, r, first, sec, 2*idx+2);
        if(leftAns == -1) return rightAns;
        else if(rightAns == -1) return leftAns;

        if(arr[leftAns] > arr[rightAns]) return leftAns;
        return rightAns;
    }


}
