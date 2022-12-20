package indi.alain.leetcode.dynamicprogramming;

/**
 * @author d
 */
public class GetZeroCoins {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            //先遍历物品
            for (int j = coins[i]; j <= amount; j++) { // 再遍历背包
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }

}
