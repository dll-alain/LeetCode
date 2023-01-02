package indi.alain.leetcode.dynamicprogramming;

/**
 * @author d
 */
public class PurchaseStockTwo {
    public int maxProfit(int[] prices) {
        int[] dp = new int[2];
        dp[0] = -prices[0];  //hold stock
        dp[1] = 0;  //not hold stock
        for (int i = 1; i < prices.length; i++) {
            dp[0] = Math.max(dp[0], dp[1] - prices[i]);
            dp[1] = Math.max(dp[1], dp[0] + prices[i]);
        }
        return dp[1];
    }
}
