package indi.alain.leetcode.dynamicprogramming;

/**
 * @author d
 */
public class CombinationSumFour {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        //排列问题，先遍历背包
        for (int j = 1; j <= target; j++) {
            for (int num : nums) {
                if (j < num) continue;
                dp[j] += dp[j - num];
            }
        }
        return dp[target];
    }
}
