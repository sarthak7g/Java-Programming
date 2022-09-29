package linkedList;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    public static ListNode createNode(int[] arr) {
        ListNode head = null, curr = null;
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

    public static void traverseNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
