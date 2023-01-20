package indi.alain.leetcode.others;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 单调队列
 * @author d
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] res = new int[len];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                res[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return res;
    }
}
