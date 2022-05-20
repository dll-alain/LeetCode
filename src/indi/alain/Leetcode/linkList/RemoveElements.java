package indi.alain.Leetcode.linkList;

/**
 * @author dll
 * @date 20220514
 */
public class RemoveElements {

    static class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode temp = head;
        if (head == null || head.next == null) {
            head = null;
            return null;
        }
        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
