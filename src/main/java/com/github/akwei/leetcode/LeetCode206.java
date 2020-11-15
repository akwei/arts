package com.github.akwei.leetcode;

public class LeetCode206 {

    public ListNode reverseList(ListNode head) {
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

    public static void main(String[] args) {
        LeetCode206.ListNode n1 = new LeetCode206.ListNode(1);
        LeetCode206.ListNode n2 = new LeetCode206.ListNode(2);
        LeetCode206.ListNode n3 = new LeetCode206.ListNode(3);
        LeetCode206.ListNode n4 = new LeetCode206.ListNode(4);
        LeetCode206.ListNode n5 = new LeetCode206.ListNode(5);
        LeetCode206.ListNode n6 = new LeetCode206.ListNode(6);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        LeetCode206 obj = new LeetCode206();
        obj.reverseList(n1);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
