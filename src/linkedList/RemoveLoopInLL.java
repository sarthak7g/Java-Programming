package linkedList;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://practice.geeksforgeeks.org/problems/remove-loop-in-linked-list/1">Remove loop in LL</a>
 * <br/>
 *  Approach:
 *      <ul>
 *          <li>find the beginning of loop</li>
 *          <li>then, start from the fast pointer to get the prev to beginning of loop</li>
 *          <li>make the prev point to null</li>
 *          <li>Time complexity: O(n)</li>
 *      </ul>
 * </body>
 */

public class RemoveLoopInLL {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 7};
        int pos = 3;
        Node root = createLL(arr, pos);
        print(root);
        removeLoop(root);
        System.out.println("AFTER==============>");
        print(root);
    }

    private static Node createLL(int[] arr, int pos) {
        Node root = new Node(), prev = root, loopAt=null;
        for (int i = 0; i < arr.length; i++) {
            if(i == 0) {
                root.data = arr[i];
            }else {
                Node newNode = new Node();
                newNode.data = arr[i];
                prev.next = newNode;
                prev = prev.next;
            }
            if(i == pos-1) loopAt = prev;
        }
        prev.next = loopAt;
        return root;
    }

    static class Node
    {
        int data;
        Node next;
    }
    public static void removeLoop(Node head){
        // find loop
        Node slow = head, fast=head;
        do{
            slow = slow.next;
            fast = fast.next.next;
        }
        while(fast!=null && fast.next!=null && slow!=fast);

        if(head==null || fast==null || fast.next==null) return;

        // find intersection point
        slow = head;
        Node second = fast;
        while(slow != second) {
            slow = slow.next;
            second = second.next;
        }

        // find the prev of intersection
        Node temp = fast;
        while(temp.next != second) {
            temp = temp.next;
        }
        temp.next = null;

        // print(head);
    }

    static void print(Node head) {
        int count = 0;
        while(head!=null && count<10) {
            System.out.println(head.data);
            head = head.next;
            count++;
        }
    }
}
