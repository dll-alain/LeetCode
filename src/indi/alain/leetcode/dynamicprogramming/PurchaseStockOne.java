package indi.alain.leetcode.dynamicprogramming;

/**
 * 买彩票one
 * @author d
 */
public class PurchaseStockOne {
    public int maxProfit(int[] prices) {
        int[] dp = new int[2];
        dp[0] = -prices[0]; //持有
        dp[1] = 0; //未持有
        for (int i = 1; i < prices.length; i++) {
            dp[0] = Math.max(dp[0], -prices[i]);
            dp[1] = Math.max(dp[1], prices[i] + dp[0]);
        }
        return dp[1];
    }
}
