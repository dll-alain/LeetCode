package indi.alain.Leetcode.stackandqueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 队列实现栈
 * 基于单双链表
 * @author d
 */
public class QueueToStack {
    Queue<Integer> queue = new LinkedList<>();

    //单链表
    public void push(int x) {
        queue.offer(x);
        for (int i = 1; i < queue.size(); i++) {
            queue.offer(queue.peek());
            queue.poll();
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}

class MyStack {
    Deque<Integer> deque = new ArrayDeque<>();

    public MyStack() {

    }

    //双链表
    public void push(int x) {
        deque.addFirst(x);
    }

    public int pop() {
        return deque.poll();
    }

    public int top() {
        return deque.peek();

    }

    public boolean empty() {
        return deque.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
