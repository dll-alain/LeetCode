package indi.alain.Leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SubSets {
    private List<List<Integer>> result = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backTracking(nums, 0);
        return result;
    }

    public void backTracking(int[] nums, int startIndex) {
        result.add(new ArrayList<Integer>(path));
        if (startIndex >= nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backTracking(nums, i + 1);
            path.removeLast();
        }
    }

}
