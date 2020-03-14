package com.github.akwei.leetcode;

import org.junit.Test;

public class LeetCode21Test {

    @Test
    public void test01() {
        LeetCode21.ListNode a1 = new LeetCode21.ListNode(1);
        LeetCode21.ListNode a2 = new LeetCode21.ListNode(2);
        LeetCode21.ListNode a3 = new LeetCode21.ListNode(4);
        a1.next = a2;
        a2.next = a3;

        LeetCode21.ListNode b1 = new LeetCode21.ListNode(1);
        LeetCode21.ListNode b2 = new LeetCode21.ListNode(3);
        LeetCode21.ListNode b3 = new LeetCode21.ListNode(4);
        b1.next = b2;
        b2.next = b3;
        LeetCode21 obj = new LeetCode21();
        LeetCode21.ListNode listNode = obj.mergeTwoLists(a1, b1);
        LeetCode21.printListNode(listNode);
    }

    @Test
    public void test02() {
        LeetCode21.ListNode a1 = new LeetCode21.ListNode(-9);
        LeetCode21.ListNode a2 = new LeetCode21.ListNode(3);
        a1.next = a2;

        LeetCode21.ListNode b1 = new LeetCode21.ListNode(5);
        LeetCode21.ListNode b2 = new LeetCode21.ListNode(7);
        b1.next = b2;
        LeetCode21 obj = new LeetCode21();
        LeetCode21.ListNode listNode = obj.mergeTwoLists(a1, b1);
        LeetCode21.printListNode(listNode);
    }
}
