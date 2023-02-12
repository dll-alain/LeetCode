package indi.alain.leetcode.others;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author d
 */
public class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        Deque<Integer> stack = new LinkedList<>();
        int res = 0;

        // 数组扩容，在头和尾各加入一个元素
        int[] newHeights = new int[len + 2];
        System.arraycopy(heights, 0, newHeights, 1, len);
        heights = newHeights;

        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int mid = stack.pop();
                int h = heights[mid];
                int left = stack.peek();
                int right = i;
                int w = right - left - 1;
                res = Math.max(res, w * h);
            }
            stack.push(i);
        }
        return res;
    }

}
