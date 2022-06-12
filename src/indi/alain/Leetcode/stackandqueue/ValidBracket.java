package indi.alain.Leetcode.stackandqueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 栈匹配括号
 * @author d
 */
public class ValidBracket {
    public boolean isValid(String s) {
        char[] strArr = s.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        for (char ch : strArr) {
            //碰到左括号，就把相应的右括号入栈
            if (ch == '(') {
                stack.push(')');
            }else if (ch == '{') {
                stack.push('}');
            }else if (ch == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.peek() != ch) {
                return false;
            }else {//如果是右括号判断是否和栈顶元素匹配
                stack.pop();
            }
        }
        //最后判断栈中元素是否匹配
        return stack.isEmpty();
    }

    public static void main(String[] args) {
    }
}
