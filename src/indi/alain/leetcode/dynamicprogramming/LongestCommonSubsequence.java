package indi.alain.leetcode.dynamicprogramming;

/**
 * @author d
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[] dp = new int[len2 + 1];
        int result = 0;
        for (int i = 1; i <= len1; i++) {
            int pre = dp[0]; //让每个内循环只递增1
            for (int j = 1; j <= len2; j++) {
                int cur = dp[j]; //0 1
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[j] = pre + 1;  // dp[1]=1
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                pre = cur; // 0
            }
        }
        return dp[len2];
    }
}
