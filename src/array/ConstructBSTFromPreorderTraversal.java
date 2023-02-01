package array;

import java.util.Arrays;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/">Construct Binary Search Tree from Preorder Traversal</a>
 * <br/>
 * <br/>
 * <b>Approach 1:</b>
 * <ul>
 *      <li>Hint: Recursively build tree. To find the pos effectively we will use binary search.</li>
 *      <li>Time complexity: O(n*log(n))</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 * <b>Approach 2:</b>
 * <ul>
 *      <li>Hint: Recursively build tree using upper-lower limits and without using inorder traversal.</li>
 *      <li>At start, we will set lower and upper limit to negative infinity and positive infinity respectively, to see if an element can be placed there or not. Recursively we will do the same while changing the limits.</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 * </body>
 */

public class ConstructBSTFromPreorderTraversal {

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

    static int idx, idx2;

    public static void main(String[] args) {
        System.out.println(bstFromPreorder(new int[]{8, 5, 1, 7, 10, 12}));
        System.out.println(bstFromPreorder(new int[]{1, 3}));
        System.out.println();
        System.out.println(bstFromPreorder2(new int[]{8, 5, 1, 7, 10, 12}));
        System.out.println(bstFromPreorder2(new int[]{1, 3}));
    }

    public static TreeNode bstFromPreorder(int[] pre) {
        int[] in = Arrays.copyOf(pre, pre.length);
        Arrays.sort(in);
        idx = 0;
        return solve(pre, in, 0, pre.length - 1);
    }

    public static TreeNode solve(int[] pre, int[] in, int st, int end) {
        if (st > end) return null;

        int val = pre[idx];

        int pos;
        TreeNode root = new TreeNode(val);
        pos = Arrays.binarySearch(in, st, end + 1, val);
        idx += 1;
        root.left = solve(pre, in, st, pos - 1);
        root.right = solve(pre, in, pos + 1, end);
        return root;
    }


    public static TreeNode bstFromPreorder2(int[] pre) {
        idx2 = 0;
        return solve2(pre, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static TreeNode solve2(int[] pre, int low, int high) {
        if (idx2 >= pre.length) return null;

        int val = pre[idx2];
        if (val < low || val > high) return null;

        TreeNode root = new TreeNode(val);
        idx2 += 1;
        root.left = solve2(pre, low, val);
        root.right = solve2(pre, val, high);
        return root;
    }
}
