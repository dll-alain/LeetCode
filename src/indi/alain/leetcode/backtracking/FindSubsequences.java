package indi.alain.leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author d
 */
public class FindSubsequences {
    private List<List<Integer>> result = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        backTacking(nums, 0);
        return result;
    }
    private void backTacking(int[] nums, int startIndex) {
        if (path.size() >= 2) {
            result.add(new ArrayList<>(path));
        }
        if (startIndex >= nums.length) {
            return;
        }
        int[] use = new int[201];
        for (int i = startIndex; i < nums.length; i++) {
            if ((!path.isEmpty() && nums[i] < path.get(path.size() - 1)) || use[nums[i] + 100] == 1) {
                continue;
            }
            use[nums[i] + 100] = 1;
            path.add(nums[i]);
            backTacking(nums, i + 1);
            path.removeLast();
        }

    }

}
