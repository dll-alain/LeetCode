package indi.alain.Leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author d
 */
public class Partition {
    private List<List<String>> result = new ArrayList<>();
    private LinkedList<String> path = new LinkedList<>();
    public List<List<String>> partition(String s) {
        backTracking(s, 0);
        return result;
    }

    private void backTracking(String s, int startIndex) {
        if (startIndex >= s.length()) {
            result.add(new ArrayList<String>(path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (isPartition(s, startIndex, i)) {
                String str = s.substring(startIndex, i + 1);
                path.add(str);
            } else {
                continue;
            }
            backTracking(s, i + 1);
            path.removeLast();
        }

    }

    private boolean isPartition(String s, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

}
