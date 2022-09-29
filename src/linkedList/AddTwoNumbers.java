package linkedList;

import static linkedList.ListNode.createNode;
import static linkedList.ListNode.traverseNode;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/add-two-numbers/">Add Two Numbers</a>
 * <br/>
 *  Approach:
 *      <ul>
 *          <li>Linear two pointers traversal with carry</li>
 *          <li>Time complexity: O(n)</li>
 *          <li>Space complexity: O(n)</li>
 *      </ul>
 * </body>
 */

public class AddTwoNumbers {
    static ListNode ans = null;
    static ListNode tail = null;

    public static void main(String[] args) {
        traverseNode(addTwoNumbers(createNode(new int[]{9, 9, 9}), createNode(new int[]{1, 0, 0, 1})));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum, carry = 0;

        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + carry;
            addNode(sum % 10);
            carry = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            sum = l1.val + carry;
            addNode(sum % 10);
            carry = sum / 10;
            l1 = l1.next;
        }

        while (l2 != null) {
            sum = l2.val + carry;
            addNode(sum % 10);
            carry = sum / 10;
            l2 = l2.next;
        }

        if (carry != 0) {
            addNode(carry);
        }
        return ans;
    }

    static void addNode(int val) {
        if (tail == null) {
            tail = new ListNode(val);
            ans = tail;
        } else {
            tail.next = new ListNode(val);
            tail = tail.next;
        }
    }
}

