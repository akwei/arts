package com.github.akwei.me;

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

    public static void add(ListNode head, ListNode node) {
        if (node == null) {
            return;
        }
        node.next = head.next;
        head.next = node;
    }

    public static void remove(ListNode head, int n) {
        if (head == null) {
            return;
        }
        if (n == 0) {
            return;
        }
        if (n == 1) {
            return;
        }
        ListNode node = head;
        ListNode prev = head;
        for (int i = 0; i < n - 1; i++) {
            prev = node;
            node = node.next;
            if (node == null) {
                return;
            }
        }
        prev.next = node.next;
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
