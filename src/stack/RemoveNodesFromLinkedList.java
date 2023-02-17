package stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/remove-nodes-from-linked-list/description/">Remove Nodes From Linked List</a>
 * <br/>
 * <br/>
 * <b>Approach 1:</b>
 * <ul>
 *      <li>Hint: Use monotonic stack to store a ListNode.</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 * </body>
 */

public class RemoveNodesFromLinkedList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        System.out.println(removeNodes(constructNode(new int[]{5, 2, 13, 3, 8})));
        System.out.println(removeNodes(constructNode(new int[]{1, 1, 1, 1})));
    }

    private static ListNode constructNode(int[] ints) {
        ListNode head = new ListNode(ints[0]), tmp = head;
        for (int i = 1; i < ints.length; i++) {
            tmp.next = new ListNode(ints[i]);
            tmp = tmp.next;
        }
        return head;
    }

    public static ListNode removeNodes(ListNode head) {
        ListNode node = head;
        Deque<ListNode> stack = new ArrayDeque<>();
        while (node != null) {
            while (!stack.isEmpty() && node.val > stack.getFirst().val) {
                stack.remove();
            }
            if (stack.isEmpty()) head = node;
            else stack.getFirst().next = node;
            stack.addFirst(node);
            node = node.next;
        }

        return head;
    }
}
