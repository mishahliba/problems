package main.java.leetcode;

public class MergeTwoLists21 {
    public static void main(String[] args) {
        var solution = new MergeTwoLists21();
        ListNode root1 = new ListNode(1);
        ListNode nextFirst1 = new ListNode(2);
        ListNode nextFirst2 = new ListNode(4);
        root1.next = nextFirst1;
        nextFirst1.next = nextFirst2;

        ListNode root2 = new ListNode(1);
        ListNode nextSecond1 = new ListNode(3);
        ListNode nextSecond2 = new ListNode(4);
        root2.next = nextSecond1;
        nextSecond1.next = nextSecond2;

        var result = solution.mergeTwoLists(root1, root2);
        while (result.next != null) {
            var curr = result.val;
            System.out.println("value: " + curr);
            result = result.next;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        return helpFunction(list1, list2, new ListNode());
    }

    private ListNode nextNode(ListNode list) {
        if (list != null && list.next != null) return new ListNode();
        return null;
    }

    private ListNode helpFunction(ListNode list1, ListNode list2, ListNode result) {
        if (list1 != null && list2 != null) {
            var next = new ListNode();
            if (list1.val >= list2.val) {
                result.val = list2.val;
                result.next = next;
                helpFunction(list1, list2.next, next);
            } else {
                result.val = list1.val;
                result.next = next;
                helpFunction(list1.next, list2, next);
            }
        } else if (list1 != null && list2 == null) {
            result.val = list1.val;
            var next = nextNode(list1);
            result.next = next;
            helpFunction(list1.next, list2, next);
        } else if (list1 == null && list2 != null) {
            result.val = list2.val;
            var next = nextNode(list2);
            result.next = next;
            helpFunction(list1, list2.next, next);
        } else if (list1 == null && list2 == null) {
            return null;
        }
        return result;
    }


}
