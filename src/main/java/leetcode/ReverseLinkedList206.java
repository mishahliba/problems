package main.java.leetcode;

public class ReverseLinkedList206 {
    public static void main(String[] args) {
        var solution = new ReverseLinkedList206();
        ListNode root1 = new ListNode(1);
        ListNode nextFirst1 = new ListNode(2);
        ListNode nextFirst2 = new ListNode(4);
        root1.next = nextFirst1;
        nextFirst1.next = nextFirst2;


        var result = solution.reverseList(root1);
        while (result.next != null) {
            var curr = result.val;
            System.out.println("value: " + curr);
            result = result.next;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;

        while (current != null) {
            ListNode nextTemp = current.next;
            current.next = previous;
            previous = current;
            current = nextTemp;
        }
        return previous;
    }
}
