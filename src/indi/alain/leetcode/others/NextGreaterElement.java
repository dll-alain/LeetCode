package indi.alain.leetcode.others;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author d
 */
public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new LinkedList<>();
        int len = nums1.length;
        int[] res = new int[len];
        Arrays.fill(res, -1);
        for (int i = 0; i < len; i++) map.put(nums1[i], i);
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                if (map.containsKey(nums2[stack.peek()])) {
                    res[map.get(nums2[stack.peek()])] = nums2[i];
                }
                stack.pop();
            }
            stack.push(i);
        }
        return res;
    }
}
