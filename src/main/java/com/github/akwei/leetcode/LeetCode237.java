package com.github.akwei.leetcode;

public class LeetCode237 {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 因为，我们无法访问我们想要删除的节点 之前 的节点，我们始终不能修改该节点的 next 指针。相反，我们必须将想要删除的节点的值替换为它后面节点中的值，然后删除它之后的节点。
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/delete-node-in-a-linked-list/solution/shan-chu-lian-biao-zhong-de-jie-dian-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
