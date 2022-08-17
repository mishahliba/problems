package main.java.leetcode;

import java.util.HashMap;

public class LinkedListCycle142 {
    public static void main(String[] args) {
        var solution = new LinkedListCycle142();

        ListNode root = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        root.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = second;

        var startCycle = solution.detectCycle(root);
        System.out.println(startCycle);
    }

    public ListNode detectCycle(ListNode head) {
        var counterMap = new HashMap<ListNode, Integer>();

        var index = 0;
        while (index < 10000) {
            if(head == null || head.next == null)
                return null;

            counterMap.merge(head, 1, Integer::sum);
            if (counterMap.get(head) > 1)
                return head;

            index++;
            head = head.next;
        }
        return null;
    }
}
