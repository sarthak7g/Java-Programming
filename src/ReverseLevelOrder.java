import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class LinkedListNode {
    Node data;
    LinkedListNode prev, next;
}


public class ReverseLevelOrder {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t > 0){
            String s = sc.nextLine();
            Node root = buildTree(s);
            ArrayList<Integer> ans = reverseLevelOrder(root);

            for (Integer val: ans)
                System.out.print(val+" ");
            System.out.println();
            t--;
        }
    }

    public static ArrayList<Integer> reverseLevelOrder(Node node)
    {
        ArrayList<Integer> ans = new ArrayList<>();

        LinkedListNode head = new LinkedListNode();
        head.data = node;

        LinkedListNode curr = head;
        Node temp;
        while(curr != null) {
            temp = curr.data;
            if(temp.right != null) {
                LinkedListNode newNode = new LinkedListNode();
                newNode.data = temp.right;
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
            if(temp.left != null) {
                LinkedListNode newNode = new LinkedListNode();
                newNode.data = temp.left;
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }

            curr = curr.prev;

        }

        while(head!=null) {
            ans.add(head.data.data);
            head = head.next;
        }

        return ans;
    }

    static Node buildTree(String str){

        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while(queue.size()>0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if(!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if(i >= ip.length)
                break;

            currVal = ip[i];

            // If the right child is not null
            if(!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;

        printInorder(root.left);
        System.out.print(root.data+" ");

        printInorder(root.right);
    }
}
