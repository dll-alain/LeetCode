package indi.alain.leetcode.dynamicprogramming;

/**判断一个字符串在另一字符串中出现次数
 * @author d
 */
public class NumDistinct {
    public int numDistinct(String s, String t) {
        int l1 = s.length();
        int l2 = t.length();
        int[][] dp = new int[l1 + 1][l2 + 1];
        for (int i = 0; i <= l1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j<= l2; j++) {
                // 考虑s[i - 1] 相当于s[i - 1] 与 t[j - 1] 固定住，只用算 dp[i - 1][j - 1] 即可
                //不考虑s[i - 1] 相当于 删除s[i - 1] 等于 dp[i - 1][j]
                if (s.charAt(i - 1) == t.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                else dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[l1][l2];
    }
}
