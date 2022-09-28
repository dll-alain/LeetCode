package indi.alain.Leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author d
 */
public class SumOfCombine {

    private List<List<Integer>> result = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(0, k, n, 1);
        return result;

    }
    private void backtracking(int sum, int k, int n, int startIndex) {
        if (sum > n) return;
        if (path.size() == k) {
            if (sum == n) result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            sum += i;
            path.add(i);
            backtracking(sum, k, n, i + 1);
            sum -= i;
            path.removeLast();
        }
        return;
    }
}
