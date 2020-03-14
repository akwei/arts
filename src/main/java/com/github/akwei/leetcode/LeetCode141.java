package com.github.akwei.leetcode;

/**
 * 给定一个链表，判断链表中是否有环。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode141 {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode n1 = head;
        ListNode n2 = head;
        while (true) {
            n1 = n1.next;
            n2 = n2.next;
            if (n2 == null) {
                return false;
            }
            n2 = n2.next;
            if (n2 == null) {
                return false;
            }
            if (n1.equals(n2)) {
                return true;
            }
        }
    }

}
