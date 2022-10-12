package indi.alain.leetcode.linkList;

/**
 * @author dll
 * @date 20220516
 */
public class ReverseList {
    static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp = null;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public ListNode reverseList2(ListNode head) {
        return reverse(null, head);
    }

    public ListNode reverse(ListNode pre, ListNode cur) {
        if (cur == null) {
            //递归出口
            return pre;
        }
        ListNode temp = null;
        temp = cur.next;
        cur.next = pre;
        pre = cur;
        cur = temp;
        return reverse(pre, cur);
    }


}
