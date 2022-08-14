/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/insertion-sort-list/">Insertion Sort Linked List</a>
 * <br/>
 * Time complexity: O(n^2) <br/>
 * </body>
 */

public class InsertionSortLinkedList {
    public static void main(String[] args) {
        ListNode head = createNode();
        display(head);
        ListNode ans = insertionSortList(head);
        display(ans);
    }

    private static ListNode createNode() {
        int[] arr = {5, 2, 4, 1, 3};
        ListNode head = null, curr=null;
        for (int j : arr) {
            if (head == null) {
                head = new ListNode(j);
                curr = head;
            } else {
                curr.next = new ListNode(j);
                curr = curr.next;
            }
        }
        return head;
    }

    public static ListNode insertionSortList(ListNode head) {
        if(head.next == null) return head;

        ListNode prev=null, curr=head;
        while(curr!=null) {
            if(curr != head && curr.data < prev.data) {
                prev.next = curr.next;
                head = add(head, curr);
                curr = prev.next;
            }else {
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }

    private static ListNode add(ListNode head, ListNode curr) {
        if(curr.data < head.data) {
            curr.next = head;
            head = curr;
            return head;
        }

        ListNode temp=head;
        while(temp.next.data < curr.data) {
            temp = temp.next;
        }

        curr.next = temp.next;
        temp.next = curr;
        return head;
    }

    private static void display(ListNode root) {
        while(root!=null) {
            System.out.print(root.data + " ");
            root = root.next;
        }
        System.out.println();
    }
}
