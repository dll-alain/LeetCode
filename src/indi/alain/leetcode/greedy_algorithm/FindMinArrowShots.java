package indi.alain.leetcode.greedy_algorithm;

import java.util.Arrays;

/**
 * @author d
 */
public class FindMinArrowShots {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int result = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > points[i - 1][1]) {
                //第二个气球不挨着第一个气球
                result++;
            } else {
                //更新右边界
                points[i][1] = Math.min(points[i][1], points[i - 1][1]);
            }
        }
        return result;
    }
}
