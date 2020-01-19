package com.github.akwei.leetcode;

public class AddTwoNumbers {

    static class ListNode {
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
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode n1 = l1;
        ListNode n2 = l2;
        ListNode prev = null;
        ListNode head = null;
        boolean moreAdd = false;
        while ((n1 != null || n2 != null) || moreAdd) {
            Object[] objs = addNode(n1, n2, moreAdd);
            ListNode resNode = (ListNode) objs[0];
            moreAdd = (Boolean) objs[1];
            if (head == null) {
                head = resNode;
            }
            if (prev != null) {
                prev.next = resNode;
            }
            prev = resNode;
            if (n1 != null) {
                n1 = n1.next;
            }
            if (n2 != null) {
                n2 = n2.next;
            }
        }
        return head;
    }

    public Object[] addNode(ListNode l1, ListNode l2, boolean moreAdd) {
        int a = 0;
        int b = 0;
        if (l1 != null) {
            a = l1.val;
        }
        if (l2 != null) {
            b = l2.val;
        }
        int c = a + b;
        if (moreAdd) {
            c = c + 1;
        }
        boolean more = false;
        if (c >= 10) {
            more = true;
            c = c % 10;
        }
        ListNode n = new ListNode(c);
        return new Object[]{n, more};
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(3);
        a1.next = a2;
        a2.next = a3;

        ListNode b1 = new ListNode(5);
        ListNode b2 = new ListNode(6);
        ListNode b3 = new ListNode(4);
        ListNode b4 = new ListNode(9);
        b1.next = b2;
        b2.next = b3;
        b3.next = b4;
        AddTwoNumbers obj = new AddTwoNumbers();
        ListNode listNode = obj.addTwoNumbers(a1, b1);
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
