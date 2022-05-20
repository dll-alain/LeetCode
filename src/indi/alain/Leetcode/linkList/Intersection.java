package indi.alain.Leetcode.linkList;
import indi.alain.Leetcode.linkList.RemoveNthFromEnd.ListNode;

/**
 * @author d
 */
public class Intersection {
    public RemoveNthFromEnd.ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA = getSize(headA);
        int sizeB = getSize(headB);
        ListNode tempA = headA;
        ListNode tempB = headB;
        int gap = 0;
        if (sizeA > sizeB) {
            gap = sizeA - sizeB;
            for (int i = 0; i < gap; i++) {
                tempA = tempA.next;
            }
        }else {
            gap = sizeB - sizeA;
            for (int i = 0; i < gap; i++) {
                tempB = tempB.next;
            }
        }

        ListNode intersect = null;
        while (tempA != null) {
            if ( intersect == null && tempA == tempB) {
                intersect = tempA;
            }
            if (tempA != tempB) {
                intersect = null;
            }
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return intersect;


    }

    public int getSize(ListNode head) {
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}
