package indi.alain.leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author d
 */
public class Combine {
    private List<List<Integer>> reslut = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        backTracking(n, k, 1);
        return reslut;
    }

    private void backTracking(int n, int k, int startIndex) {
        if (path.size() == k) {
            reslut.add(new ArrayList(path));
            return;
        }
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            backTracking(n, k, i + 1);
            path.removeLast();
        }
    }
}
