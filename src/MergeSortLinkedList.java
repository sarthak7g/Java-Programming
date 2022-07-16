/**
 *
 * Level: Hard
 * refer to: https://workat.tech/problem-solving/practice/merge-sort-linked-list
 *
 * Approach-
 *      1) Divide the list into two halves, (better to use slow and fast pointer to divide arrays than finding length).
 *      2) Maintain two pointers over both the nodes while merging
 *
 * Time complexity: O(nlog(n))
 *
 */

public class MergeSortLinkedList {
    public static void main(String[] args) {
//        ListNode head = createListNodeFromArray(new int[]{6, 5, 1, 7});
        ListNode head = createListNodeFromArray(new int[]{1, 6, 2, 4, 3, 5, 2, 8, 4, 7});
        print(mergeSort(head));
    }

    static ListNode mergeSort(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        int length = getLength(head);
        ListNode firsthalf = head;
        ListNode secondhalf = head;
        int i=1;
        while(i<length/2) {
            secondhalf = secondhalf.next;
            i++;
        }
        ListNode temp = secondhalf.next;
        secondhalf.next = null;
        secondhalf = temp;

        ListNode sortedFirstHalf = mergeSort(firsthalf);
        ListNode sortedSecondHalf = mergeSort(secondhalf);

         print(sortedFirstHalf);
         System.out.println();
         print(sortedSecondHalf);
         System.out.println();

        if(sortedSecondHalf == null) {
            return sortedFirstHalf;
        }

        ListNode currFirst = sortedFirstHalf, currSecond = sortedSecondHalf, prevFirst = null, prevSecond = null, ansNode=sortedFirstHalf;

        while(currSecond != null && currFirst != null) {
            while(currFirst!=null && currFirst.data<=currSecond.data) {
                prevFirst = currFirst;
                currFirst = currFirst.next;
            }

            if(currFirst == null) {
                currFirst = currSecond;
                prevFirst.next = currFirst;
                break;
            }

            if(prevFirst != null) {
                prevFirst.next = currSecond;
            }else{
                ansNode = currSecond;
            }
            prevSecond = currSecond.next;
            currSecond.next = currFirst;
            prevFirst = currSecond;
            currSecond = prevSecond;

        }

        return ansNode;
    }

    static void print(ListNode root) {
        while(root!=null) {
            System.out.print(root.data + " ");
            root = root.next;
        }
    }

    static int getLength(ListNode root) {
        int count = 0;
        while(root != null){
            root = root.next;
            count += 1;
        }
        return count;
    }

    static ListNode createListNodeFromArray(int arr[]) {
        ListNode head = null, tempNode=null;
        for (int i = 0; i < arr.length; i++) {
            if(i==0) {
                tempNode = new ListNode(arr[i]);
                head = tempNode;
            }else {
                tempNode.next = new ListNode(arr[i]);
                tempNode = tempNode.next;
            }
        }
        return head;
    }

}

class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}