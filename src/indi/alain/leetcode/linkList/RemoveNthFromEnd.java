package indi.alain.leetcode.linkList;

/**
 * @author d
 */
public class RemoveNthFromEnd {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode removeNode(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int count = 0;
        ListNode pre = dummy;
        while (pre.next != null) {
            pre = pre.next;
            count++;
        }
        pre = dummy;
        int i = count - n;
        while (i > 0) {
            pre = pre.next;
            i--;
        }
        pre.next = pre.next.next;
        return dummy.next;
    }

    /**
     * 双指针法
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = null;
        ListNode slowIndex = dummy;
        ListNode fastIndex = dummy;
        while (n-- > 0) {
            fastIndex = fastIndex.next;
        }
        while (fastIndex != null) {
            pre = slowIndex;
            slowIndex = slowIndex.next;
            fastIndex = fastIndex.next;
        }
        pre.next = slowIndex.next;
        slowIndex = null;
        return dummy.next;
    }
}
