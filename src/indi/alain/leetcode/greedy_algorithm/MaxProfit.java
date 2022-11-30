package indi.alain.leetcode.greedy_algorithm;

/**
 * @author d
 */
public class MaxProfit {
    public int maxProfit(int[] prices, int fee) {
        if (prices.length == 1) return 0;
        int base = prices[0] + fee;  // 本身带交易费的买入，后面高于这个部分的，都是利润；
        int profit = 0;
        for (int dao : prices) {
            if (dao > base) {  // 高于的，都是利润；
                profit += dao - base;
                base = dao;
            }
            else if (dao + fee < base) {  // 一旦遇到下降，说明利润达到顶点了，转为下滑；
                // 不断试探，最低点（买入点）在哪里；但是只要遇到高点，if语句就会加入利润
                base = dao + fee;
            }
            // else if (dao + fee >= base && dao <= base) {
            //     //持仓 因为此时买则不便宜，卖则亏本
            //     continue;
            // }
        }
        return profit;

    }

}
