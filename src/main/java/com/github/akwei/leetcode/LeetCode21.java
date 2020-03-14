package com.github.akwei.leetcode;

public class LeetCode21 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 考虑几个情况:
     * -----
     * [1,2,4]
     * [1,3,4]
     * -----
     * [5]
     * [1,2,4]
     * -----
     * [-9,3]
     * [5,7]
     * -----
     * 组装的新节点需要清除next
     * 链表长度不一样
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode node = null;
        ListNode cur = null;
        while (true) {
            ListNode tmp;
            if (head1 != null && head2 != null) {
                if (head1.val <= head2.val) {
                    tmp = head1;
                    head1 = head1.next;
                    tmp.next = null;
                    if (head1 == null || head1.val > head2.val) {
                        tmp.next = head2;
                        head2 = head2.next;
                        tmp.next.next = null;
                    }
                } else {
                    tmp = head2;
                    head2 = head2.next;
                    tmp.next = null;
                    if (head2 == null || head2.val > head1.val) {
                        tmp.next = head1;
                        head1 = head1.next;
                        tmp.next.next = null;
                    }
                }
            } else if (head1 != null) {
                tmp = head1;
                head1 = head1.next;
                tmp.next = null;
            } else if (head2 != null) {
                tmp = head2;
                head2 = head2.next;
                tmp.next = null;
            } else {
                return node;
            }
            if (node == null) {
                cur = tmp;
                node = cur;
            } else {
                cur.next = tmp;
            }
            cur = tmp;
            if (tmp.next != null) {
                cur = tmp.next;
            }
        }
    }

    /**
     * 递归算法
     */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists1(l1, l2.next);
            return l2;
        }
    }


    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(4);
        a1.next = a2;
        a2.next = a3;

        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(3);
        ListNode b3 = new ListNode(4);
        b1.next = b2;
        b2.next = b3;
        LeetCode21 obj = new LeetCode21();
        ListNode listNode = obj.mergeTwoLists(a1, b1);
        printListNode(listNode);
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
}
