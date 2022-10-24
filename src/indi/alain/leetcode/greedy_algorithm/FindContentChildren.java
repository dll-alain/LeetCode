package indi.alain.leetcode.greedy_algorithm;

import java.util.Arrays;

/**
 * @author d
 */
public class FindContentChildren {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int index = 0;
        for (int i = 0; i < s.length; i++) {
            if (index < g.length && g[index] <= s[i]) {
                index++;
            }
        }
        return index;
    }
}
