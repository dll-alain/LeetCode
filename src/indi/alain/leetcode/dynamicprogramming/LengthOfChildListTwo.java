package indi.alain.leetcode.dynamicprogramming;

/**
 * @author d
 */
public class LengthOfChildListTwo {
    public int findLengthOfLCIS(int[] nums) {
        int len = nums.length;
        if (len == 1) return len;
        int[] dp = new int[2];
        dp[0] = 1;
        int reslut = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[1] = dp[0] + 1;
                dp[0] = dp[1];
            }
            else {
                dp[0] = 1;
            }
            if (dp[1] > reslut) reslut = dp[1];
        }
        return reslut;
    }
}
