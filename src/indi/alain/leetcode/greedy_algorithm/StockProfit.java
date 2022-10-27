package indi.alain.leetcode.greedy_algorithm;

/**
 * @author d
 */
public class StockProfit {
    public int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            result += Math.max((prices[i + 1] - prices[i]), 0);
        }
        return result;
    }
}
