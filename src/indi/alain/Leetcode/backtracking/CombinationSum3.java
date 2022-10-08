package indi.alain.Leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum3 {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTracking(candidates, target, 0, 0);
        return result;
    }

    private void backTracking(int[] candidates, int target, int sum, int startIndex) {
        if (sum == target) {
            result.add(new ArrayList(path));
            return;
        }
        for (int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i++) {
            if (i > startIndex && candidates[i] == candidates[i - 1]) continue;
            sum += candidates[i];
            path.add(candidates[i]);
            backTracking(candidates, target, sum, i + 1);
            sum -= candidates[i];
            path.removeLast();
        }
    }


}
