package indi.alain.Leetcode.stackandqueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 维护一个单调队列
 * @author d
 */
public class MaxSlidingWin {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> slideWin = new ArrayDeque<>();
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int index = 0;
        for (int i = 0; i < n; i++) {
            //落后于窗口范围的数据会被清空
            while (!slideWin.isEmpty() && slideWin.peek() < i - k + 1) {
                slideWin.poll();
            }
            //queue里的数据从back到front递增，当num[i]更大时，num[i]作为后来者会清空前面比它小的数据
            while (!slideWin.isEmpty() && nums[slideWin.peekLast()] < nums[i]) {
                slideWin.pollLast();
            }
            slideWin.offer(i);
            if (i >= k - 1) {
                result[index++] = nums[slideWin.peek()];
            }
        }
        return result;
    }
}
