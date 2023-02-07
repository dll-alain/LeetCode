package indi.alain.leetcode.others;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author d
 */
public class NextGreaterElementTwo {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        if (len == 1) return new int[]{-1};
        int[] res = new int[len];
        Arrays.fill(res, -1);
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < 2 * len; i++) {
            while (!stack.isEmpty() && nums[i % len] > nums[stack.peek()]) {
                res[stack.peek()] = nums[i % len];
                stack.pop();
            }
            stack.push(i % len);
        }
        return res;
    }
}
