package indi.alain.leetcode.dynamicprogramming;

/**
 * @author d
 */
public class FindTargetSumWays {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int s : nums) sum += s;
        if ((target + sum) % 2 != 0) return 0;
        int bagSize = (target + sum) / 2;
        if (bagSize < 0) bagSize = -bagSize;
        int[] dp = new int[bagSize + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = bagSize; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[bagSize];
    }

}
