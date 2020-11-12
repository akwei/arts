package com.github.akwei.geekbang.list;

public class ListOp {

    public static ListNode removeByValue(ListNode head, int value) {
        ListNode nHead = head;
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            if (cur.value == value) {
                if (prev == null) {
                    nHead = cur.next;
                } else {
                    prev.next = cur.next;
                }
            } else {
                prev = cur;
            }
            cur = cur.next;
        }
        return nHead;
    }

    public static void insertAfter(ListNode head, ListNode preNode, int value) {

    }

    public static void update(ListNode head, ListNode node, int value) {

    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(1);
        ListNode n8 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;

        ListNode head = n1;
        head = removeByValue(head, 1);
        printList(head);
    }

    private static void printList(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.println(cur.value);
            cur = cur.next;
        }
    }
}

class ListNode {
    int value;
    ListNode next;

    public ListNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}
