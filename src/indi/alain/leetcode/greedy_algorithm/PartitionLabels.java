package indi.alain.leetcode.greedy_algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author d
 */
public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        char[] charArr = s.toCharArray();
        int[] edge = new int[26];
        for (int i = 0; i < s.length(); i++) {
            edge[charArr[i] - 'a'] = i;
        }
        int index = 0;
        int lastCut = -1;
        for (int j = 0; j < s.length(); j++) {
            index = Math.max(index, edge[charArr[j] - 'a']);
            if (j == index) {
                result.add(j - lastCut);
                lastCut = j;
            }
        }
        return result;
    }
}
