package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <h3>Level: Easy </h3>
 * <body>
 * refer to: <a href="https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1">Left View of Tree</a>
 * <br/>
 *  Approach:
 *      <ul>
 *          <li>Recursive solution, take two arguments- currHeight and afterHeight</li>
 *          <li>if currHeight > afterHeight, then add it to the list and increase the afterHeight</li>
 *          <li>else check in the subtree</li>
 *          <li>Time complexity: O(n)</li>
 *      </ul>
 * </body>
 */

public class LeftViewOfTree {
    static class Node
    {
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }

    static ArrayList<Integer> ans = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(leftView(buildTree(new char[]{'1', '2', '3', 'N', '4', '5', 'N', '7', '8'})));
        ans.clear();
        System.out.println(leftView(buildTree(new char[]{'1', '2', '3', 'N', 'N', '4', '5', 'N', 'N', '6', '7', 'N', 'N', '8'})));
    }


    static ArrayList<Integer> leftView(Node head)
    {
        if(head == null)
            return ans;

        ans.add(head.data);
        find(head, 0, 0);
        return ans;
    }

    static int find(Node root, int currHeight, int afterHeight) {
        if(root == null) return afterHeight;

        if(currHeight > afterHeight) {
            ans.add(root.data);
            afterHeight = currHeight;
        }

        afterHeight = find(root.left, currHeight+1, afterHeight);
        return find(root.right, currHeight+1, afterHeight);

    }

    static Node buildTree(char[] ip) {

        if (ip.length == 0 || ip[0] == 'N') {
            return null;
        }

        // Create the root of the tree
        Node root = new Node(ip[0]-48);
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            char currVal = ip[i];

            // If the left child is not null
            if (currVal != 'N') {

                // Create the left child for the current node
                currNode.left = new Node(currVal-48);
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (currVal != 'N') {

                // Create the right child for the current node
                currNode.right = new Node(currVal-48);

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }
}
