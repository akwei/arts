package com.github.akwei;

public class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
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

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        printListNode(l1);
        ListNode n = reverse(l1);
        printListNode(n);
    }
}
