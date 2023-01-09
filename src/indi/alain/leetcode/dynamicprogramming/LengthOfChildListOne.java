package indi.alain.leetcode.dynamicprogramming;

import java.util.Arrays;

/**
 * @author d
 */
public class LengthOfChildListOne {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len == 1) return len;
        int result = 0;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            if (dp[i] > result) result = dp[i];
        }
        return result;
    }
}
