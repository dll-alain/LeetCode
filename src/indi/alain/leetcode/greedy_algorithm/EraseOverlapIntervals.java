package indi.alain.leetcode.greedy_algorithm;

import java.util.Arrays;

/**
 * 无重叠区间
 * @author d
 */
public class EraseOverlapIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> {
            return a[1] - b[1];
        });
        int count = 0;
        int edge = Integer.MIN_VALUE;
        for (int i = 0; i < intervals.length; i++) {
            if (edge <= intervals[i][0]) {
                edge = intervals[i][1];
            } else {
                count++;
            }
        }
        return count;
    }
}
