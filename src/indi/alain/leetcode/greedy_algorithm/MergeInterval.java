package indi.alain.leetcode.greedy_algorithm;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author d
 */
public class MergeInterval {
    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> result = new LinkedList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= result.getLast()[1]) {
                int start = result.getLast()[0];
                int end = Math.max(result.getLast()[1], intervals[i][1]);
                result.removeLast();
                result.add(new int[]{start, end});
            } else {
                result.add(intervals[i]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
