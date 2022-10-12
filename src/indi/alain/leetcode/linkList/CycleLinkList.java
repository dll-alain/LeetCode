package indi.alain.leetcode.linkList;

/**
 * @author d
 */
public class CycleLinkList {
    static class LinkList {
        public LinkList next;
        public int val;

        public LinkList(int val) {
            this.val = val;
        }
    }

    /**
     *快慢指针 – 快指针走两步，慢指针走一步，如果快慢指针相遇，有环形
     * 是否相遇，起点出一个指针，相遇点出一个指针，一步，相遇节点就是入口
     * @param head 输入头结点
     * @return 如果有环，放回环的入口
     */
    public LinkList detectCycle(LinkList head) {
        LinkList fast = head;
        LinkList slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                LinkList index1 = head;
                LinkList index2 = fast;
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }
}
