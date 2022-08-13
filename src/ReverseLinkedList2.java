/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/reverse-linked-list-ii/">Reverse Linked List II</a>
 * <br/>
 * Approach :
 *      <ul>
 *          <li>Traverse till left-1, </li>
 *          <li>then use iterative approach to reverse LL </li>
 *      </ul>
 * Time complexity: O(n) <br/>
 * </body>
 */

public class ReverseLinkedList2 {
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
        ListNode ans = reverseBetween(head, 2, 4);
        traverseNode(ans);

    }
    public static ListNode reverseBetween(ListNode head, int left, int right) {

        if(head.next == null) return head;

        ListNode tail = null;
        int count=0;
        while(count<left-1) {
            if(count == 0) {
                tail = head;
            }else tail = tail.next;
            count ++;
        }

        count = 0;
        ListNode root = tail!=null ? tail.next : head, curr=root, temp;
        while(curr.next!=null && count<right-left) {
            temp = curr.next;
            curr.next = temp.next;
            temp.next = root;
            root = temp;
            count ++;
        }
        if(tail != null) {
            tail.next = root;
            return head;
        }

        return root;
    }

    static void traverseNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
    static ListNode createNode() {
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
}
