package indi.alain.leetcode.stackandqueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author d
 */
public class RemoveDuplicates {
    /**
     * 字符串作为栈
     * @param s
     * @return
     */
    public String removeDuplicates(String s) {
        //Deque<Character> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int top = -1;
        for (int i = 0; i < s.length(); i++) {
            if (top >= 0 && sb.charAt(top) == s.charAt(i)) {
                sb.deleteCharAt(top);
                top--;
            } else {
                sb.append(s.charAt(i));
                top++;
            }
        }
        return sb.toString();
    }

    public String removeDuplicates2(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length(); i++) {
            if (stack.isEmpty() || stack.peek() != sb.charAt(i)) {
                stack.push(sb.charAt(i));
            } else {
                stack.pop();
            }
        }
        sb.delete(0, sb.length());
        while (!stack.isEmpty()) {
            sb.append(stack.removeLast());
        }
        return sb.toString();
    }



    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("ssss");
        sb.charAt(0);
    }
}
