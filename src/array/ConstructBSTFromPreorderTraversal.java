package array;

import java.util.Arrays;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/">Construct Binary Search Tree from Preorder Traversal</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Hint: Recursively build tree. To find the pos effectively we will use binary search.</li>
 *      <li>Time complexity: O(n*log(n))</li>
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

    static int idx = 0;

    public static void main(String[] args) {
        System.out.println(bstFromPreorder(new int[]{8, 5, 1, 7, 10, 12}));
    }

    public static TreeNode bstFromPreorder(int[] pre) {
        int[] in = Arrays.copyOf(pre, pre.length);
        Arrays.sort(in);
        return solve(pre, in, 0, pre.length - 1);
    }

    public static TreeNode solve(int[] pre, int[] in, int st, int end) {
        if (st > end) return null;

        int val = pre[idx];
        if (st == end) {
            idx += 1;
            return new TreeNode(val);
        }

        System.out.println(idx + " " + st + " " + end);
        int pos;
        TreeNode root = new TreeNode(val);
        pos = Arrays.binarySearch(in, st, end+1, val);
        idx += 1;
        root.left = solve(pre, in, st, pos - 1);
        root.right = solve(pre, in, pos + 1, end);
        return root;
    }

}
