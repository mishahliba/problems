package main.java.leetcode;

public class MiddleOfTheLinkedList876 {
    public static void main(String[] args) {
        var solution = new MiddleOfTheLinkedList876();
        ListNode root = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        root.next = second;
        second.next = third;
        //third.next = fourth;
        var result = solution.middleNode(root);
        System.out.println(result);
    }

    public ListNode middleNode(ListNode head) {
        if (head.next == null) return head;

        var copy = head;
        var firstCounter = 0;
        var target = 0;

        while (head != null) {
            firstCounter++;
            head = head.next;
        }
        target = (firstCounter / 2);

        var counter = 0;
        while (counter != target) {
            copy = copy.next;
            counter++;
        }
        return copy;
    }
}
