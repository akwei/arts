package com.github.akwei.leetcode;

public class LeetCode19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        if (fast == null) {
            //表示清除了头结点,直接返回 next
            return head.next;
        }
        while (true) {
            if (fast.next == null) {
                slow.next = slow.next.next;
                return head;
            }
            slow = slow.next;
            fast = fast.next;
        }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        LeetCode19 obj = new LeetCode19();
        ListNode head = obj.removeNthFromEnd(n1, 5);
        printListNode(head);
    }

    public static void printListNode(ListNode head) {
        ListNode ln = head;
        StringBuilder sb = new StringBuilder();
        while (ln != null) {
            sb.append(ln.val).append(", ");
            ln = ln.next;
        }
        System.out.println(sb.toString());
    }

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
}
