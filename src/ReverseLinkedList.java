/**
 * <h3>Level: Easy </h3>
 * <body>
 * refer to: <a href="https://practice.geeksforgeeks.org/problems/reverse-a-linked-list/1">Reverse Linked List</a>
 * <br/>
 * Approach :
 *      <ol>
 *          <li>Recursive</li>
 *          <li>Iterative</li>
 *      </ol>
 * Time complexity: O(n) <br/>
 * </body>
 */

public class ReverseLinkedList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode head = createNode();
        traverseNode(head);
        ListNode ans = reverseListIterative(head);
        traverseNode(ans);
        head = createNode();
        ListNode ans2 = reverseListRecursive(head);
        traverseNode(ans2);
    }

    private static void traverseNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
    private static ListNode createNode() {
        int[] arr = {1, 2, 3, 4, 5};
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
    public static ListNode reverseListIterative(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode prev = head, curr = head.next;
        while (curr != null) {
            prev.next = curr.next;
            curr.next = head;
            head = curr;
            curr = prev.next;
        }

        return head;
    }
    static ListNode reverseListRecursive(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode tail = head;
        while(tail.next != null) {
            tail = tail.next;
        }

        reverse(head);
        return tail;

    }
    static void reverse(ListNode head) {

        if(head == null || head.next == null) {
            return;
        }

        reverse(head.next);
        head.next.next = head;
        head.next = null;
    }
}
