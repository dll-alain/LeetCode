package indi.alain.Leetcode.stackandqueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 逆波兰计算器
 * @author d
 */
public class EvalRPN {

    class Solution {
        public int evalRPN(String[] tokens) {
            Deque<Integer> stack = new LinkedList();
            for (String s : tokens) {
                if ("+".equals(s)) {        // leetcode 内置jdk的问题，不能使用==判断字符串是否相等
                    stack.push(stack.pop() + stack.pop());      // 注意 - 和/ 需要特殊处理
                } else if ("-".equals(s)) {
                    stack.push(-stack.pop() + stack.pop());
                } else if ("*".equals(s)) {
                    stack.push(stack.pop() * stack.pop());
                } else if ("/".equals(s)) {
                    int temp1 = stack.pop();
                    int temp2 = stack.pop();
                    stack.push(temp2 / temp1);
                } else {
                    stack.push(Integer.valueOf(s));
                }
            }
            return stack.pop();
        }
    }

    public int evalRPN2(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        int temp = 0;
        for (String s : tokens) {
            if (s.matches("^-?\\d+")) {
                stack.push(Integer.parseInt(s));
            } else {
                int num2 = stack.pop();
                int num1 = stack.pop();
                switch(s) {
                    case "+" -> temp = num1 + num2;
                    case "-" -> temp = num1 - num2;
                    case "*" -> temp = num1 * num2;
                    case "/" -> temp = num1 / num2;
                    default -> throw new RuntimeException("error operator");
                }
                stack.push(temp);
            }
        }
        return stack.pop();
    }
}
