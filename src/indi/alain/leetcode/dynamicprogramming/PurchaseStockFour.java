package indi.alain.leetcode.dynamicprogramming;

/**
 * @author d
 */
public class PurchaseStockFour {
    public int maxProfit(int k, int[] prices) {
        if (k == 0 || prices.length == 0) return 0;
        //0 purchase 1 droup out
        int[] dp = new int[2 * k];
        for (int i = 0; i < k; i++) {
            dp[2 * i] = -prices[0];
        }
        for (int i = 1; i < prices.length; i++) {
            //dp length is even number and j += 2, so we need init 2 nums, of course j - 1 cant be negative
            dp[0] = Math.max(dp[0], -prices[i]);
            dp[1] = Math.max(dp[1], dp[0] + prices[i]);
            for (int j = 2; j < dp.length; j += 2) {
                dp[j] = Math.max(dp[j], dp[j - 1] - prices[i]);
                dp[j + 1] = Math.max(dp[j + 1], dp[j] + prices[i]);
            }
        }
        return dp[dp.length - 1];
    }
}
