package indi.alain.leetcode.dynamicprogramming;

/**
 * @author d
 */
public class Fib {
    public int fib(int n) {
        if (n <= 1) return n;
        // 1
        int[] dp = new int[n + 1];
        // 3
        dp[0] = 0;
        dp[1] = 1;
        //4
        for (int i = 2; i <= n; i++) {
            //2
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
