package indi.alain.leetcode.stackandqueue;

import java.util.Stack;

/**
 * 栈实现队列
 * @author d
 */
public class StackToQueue {
    private Stack<Integer> stackIn;
    private Stack<Integer> stackOut;

    public StackToQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    private void dumpStackIn() {
        if (!stackOut.empty()) {
            return;
        }
        while (!stackIn.empty()) {
            stackOut.push(stackIn.pop());
        }
    }

    public void push(int x) {
        stackIn.push(x);
    }

    public int pop() {
        dumpStackIn();
        return stackOut.pop();
    }

    public int peek() {
        dumpStackIn();
        return stackOut.peek();
    }

    public boolean empty() {
        return stackIn.empty() && stackOut.empty();
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
}
