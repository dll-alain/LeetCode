package indi.alain.leetcode.dynamicprogramming;

/**
 * 最多买两次
 * @author d
 */
public class PurchaseStockThree {
    public int maxProfit(int[] prices) {
        int[] dp = new int[4];
        dp[0] = -prices[0];  //第一次持有
        dp[1] = 0;  //第一次卖出
        dp[2] = -prices[0];  //第二次持有
        dp[3] = 0;  //第二次卖出
        for (int i = 1; i < prices.length; i++) {
            dp[0] = Math.max(dp[0], -prices[i]);
            dp[1] = Math.max(dp[1], dp[0] + prices[i]);
            dp[2] = Math.max(dp[2], dp[1] - prices[i]);
            dp[3] = Math.max(dp[3], dp[2] + prices[i]);
        }
        return dp[3];
    }
}
