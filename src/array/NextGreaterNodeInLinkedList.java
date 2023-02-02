package array;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/next-greater-node-in-linked-list/description/">Next Greater Node In Linked List</a>
 * <br/>
 * <br/>
 * <b>Approach 1:</b>
 * <ul>
 *      <li>Hint: Copy LL into array and traverse from back using monotonic stack.</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 * <b>Approach 2:</b>
 * <ul>
 *      <li>Hint: Single pass. Copy LL into array and traverse from front using monotonic stack.</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 * </body>
 */

public class NextGreaterNodeInLinkedList {

    static class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextLargerNodes(constructNode(new int[]{2, 1, 5}))));
        System.out.println(Arrays.toString(nextLargerNodes(constructNode(new int[]{2, 7, 4, 3, 5}))));

        System.out.println(Arrays.toString(nextLargerNodes2(constructNode(new int[]{2, 1, 5}))));
        System.out.println(Arrays.toString(nextLargerNodes2(constructNode(new int[]{2, 7, 4, 3, 5}))));
    }

    private static ListNode constructNode(int[] ints) {
        ListNode head = new ListNode(ints[0]), tmp = head;
        for (int i = 1; i < ints.length; i++) {
            tmp.next = new ListNode(ints[i]);
            tmp = tmp.next;
        }
        return head;
    }

    public static int length(ListNode root) {
        int count = 0;
        while (root != null) {
            count++;
            root = root.next;
        }
        return count;
    }

    public static int[] nextLargerNodes(ListNode head) {
        int l = length(head), i = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] arr = new int[l], ans = new int[l];
        while (head != null) {
            arr[i++] = head.val;
            head = head.next;
        }

        for (i = l - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] >= stack.getFirst()) {
                stack.removeFirst();
            }
            if (!stack.isEmpty()) {
                ans[i] = stack.getFirst();
            }
            stack.addFirst(arr[i]);
        }
        return ans;
    }

    public static int[] nextLargerNodes2(ListNode head) {
        int l = length(head), i = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] arr = new int[l], ans = new int[l];
        while (head != null) {
            arr[i] = head.val;
            head = head.next;
            while (!stack.isEmpty() && arr[i] > arr[stack.getFirst()]) {
                ans[stack.removeFirst()] = arr[i];
            }
            stack.addFirst(i);
            i++;
        }

        return ans;

    }

}
