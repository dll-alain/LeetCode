package indi.alain.leetcode.dynamicprogramming;

/**
 * @author d
 */
public class CountSubString {
    public int countSubstrings(String s) {
        int res = 0;
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        //从下到上，从左到右
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        // 情况一 和 情况二
                        res++;
                        dp[i][j] = true;
                    }
                    else if (dp[i + 1][j - 1]) {
                        //情况三
                        res++;
                        dp[i][j] = true;
                    }
                }
            }
        }
        return res;
    }
}
