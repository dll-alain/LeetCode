package indi.alain.Leetcode.onetoten;
import indi.alain.Leetcode.onetoten.ReverseList.ListNode;

/**
 * @author dll
 */
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while (pre.next != null && pre.next.next != null) {
            ListNode temp = head.next.next;
            pre.next = head.next;
            head.next.next = head;
            head.next = temp;

            pre = head;
            head = temp;
        }
        return dummy.next;
    }

    public ListNode recursion(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode next = node.next;
        ListNode newNext = recursion(next.next);
        node.next = node;
        node.next = newNext;
        return next;
    }
}
