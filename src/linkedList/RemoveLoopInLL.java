package linkedList;

public class RemoveLoopInLL {
    class Node
    {
        int data;
        Node next;
    }
    public static void main(String[] args) {

    }
    public static void removeLoop(Node head){
        // code here
        // remove the loop without losing any nodes

        // find loop
        Node slow = head, fast=head.next;
        while(fast!=null && fast.next!=null && slow!=fast) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if(head==null || fast==null || fast.next==null) return;

        // find intersection point
        slow = head;

        while(slow.next != fast.next.next) {
            slow = slow.next;
            fast = fast.next.next;
        }

        fast.next.next = null;

        print(head);
    }

    static void print(Node head) {
        while(head!=null) {
            System.out.println(head.data);
            head = head.next;
        }
    }
}
