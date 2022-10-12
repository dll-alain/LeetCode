package indi.alain.leetcode.linkList;

/**
 * @author dll
 * @date 20220515
 */
public class MyLinkedList {
    public Node dummy;
    public int size;


    static class Node {
        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public MyLinkedList() {
        size = 0;
        dummy = new Node(0);
    }

    public int get(int index) {
        if ((index < 0) || index >= size) {
            return -1;
        }
        Node temp = dummy;
        for (int i = 0; i <= index; i++) {
            temp = temp.next;
        }
        return temp.val;

    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        size++;
        Node pre = dummy;
        for (int i = 0; i < index; i++) {
            pre = pre.next;

        }
        Node addNode = new Node(val);
        //先把前驱节点的next给addNode
        addNode.next = pre.next;
        pre.next = addNode;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        size--;
        Node pre = dummy;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        pre.next = pre.next.next;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
