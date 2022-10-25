package indi.alain.leetcode.greedy_algorithm;

/**
 * @author d
 */
public class WiggleMaxLength {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int preDif = 0;
        int curDif = 0;
        int result = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            curDif = nums[i + 1] - nums[i];
            if ((preDif <= 0 && curDif > 0) || (preDif >= 0 && curDif < 0)) {
                result++;
                preDif = curDif;
            }
        }
        return result;
    }
}
