package indi.alain.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    private List<List<Integer>> result = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTracking(candidates, target, 0, 0);
        return result;
    }

    private void backTracking(int[] candidates, int target, int sum, int startIndex) {
        // if (sum > target) {
        //     return;
        // }
        if (sum == target) {
            result.add(new ArrayList(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            sum += candidates[i];
            if (sum > target) {
                break;
            }
            path.add(candidates[i]);
            backTracking(candidates, target, sum, i);
            sum -= candidates[i];
            path.removeLast();
        }
    }




}
