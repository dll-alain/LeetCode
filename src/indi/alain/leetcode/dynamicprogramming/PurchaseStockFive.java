package indi.alain.leetcode.dynamicprogramming;

/**
 * @author d
 */
public class PurchaseStockFive {
    public int maxProfit(int[] prices) {
        //0 hold 1 not hold 2 today sold 3 frozen
        int[] dp = new int[4];
        dp[0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            int temp1 = dp[0];
            int temp2 = dp[2];
            dp[0] = Math.max(dp[0], Math.max(dp[1] - prices[i], dp[3] - prices[i]));
            dp[1] = Math.max(dp[1], dp[3]);
            dp[2] = temp1 + prices[i];
            dp[3] = temp2;
        }
        return Math.max(dp[1], Math.max(dp[2], dp[3]));
    }
}
