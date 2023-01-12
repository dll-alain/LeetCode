package indi.alain.leetcode.dynamicprogramming;

/**
 * 最多平行线
 * @author d
 */
public class MaxUncrossedLines {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int[] dp = new int[l2 + 1];
        for (int i = 1; i <= l1; i++) { //i = 2
            int pre = dp[0];  // pre = 0
            for (int j = 1; j <= l2; j++) {
                int cur = dp[j]; //cur = 1; cur = 1
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[j] = pre + 1; // dp[1] = 1 dp[2] = 2
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                pre = cur; // pre = 1 pre = 1
            }
        }
        return dp[l2];
    }
}
