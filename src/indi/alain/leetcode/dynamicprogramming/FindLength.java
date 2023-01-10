package indi.alain.leetcode.dynamicprogramming;

/**
 * @author d
 */
public class FindLength {
    public int findLength(int[] nums1, int[] nums2) {
        int[] dp = new int[nums2.length + 1];
        int result = 0;
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = nums2.length; j > 0; j--) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[j] = dp[j - 1] + 1;
                } else {
                    dp[j] = 0;
                }
                result = result < dp[j] ? dp[j] : result;
            }
        }
        return result;
    }
}
