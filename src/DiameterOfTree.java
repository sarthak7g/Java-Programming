import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * Level: Easy
 * refer to: https://practice.geeksforgeeks.org/problems/diameter-of-binary-tree/1
 *
 * Time complexity: O(n)
 * Space complexity: O(n)
 *
 */

public class DiameterOfTree {
    public static void main(String[] args) {
        char [] arr = {'1', '2', '3', 'N', '4', '5', 'N', '7', '8'};
        System.out.println(diameter(buildTree(arr)));
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

    static int diameter(Node root) {
        return find(root).max;
    }

    static PairTree find(Node root) {
        if(root == null) {
            return new PairTree();
        }
        if(root.left==null && root.right==null) {
            PairTree p = new PairTree();
            p.height = 1;
            p.max = 1;
            return p;
        }

        PairTree lp = find(root.left), rp = find(root.right);
        PairTree ans = new PairTree();
        ans.height = Math.max(lp.height, rp.height) + 1;
        int max = Math.max(lp.max, rp.max);
        ans.max = Math.max(lp.height + rp.height + 1, max);
        return ans;
    }
}

class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class PairTree {
    int height;
    int max;
}