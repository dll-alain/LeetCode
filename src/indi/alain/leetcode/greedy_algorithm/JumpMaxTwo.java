package indi.alain.leetcode.greedy_algorithm;

/**
 * @author d
 */
public class JumpMaxTwo {
    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        int count = 0;
        int curCover = 0;
        int nextCover = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i > curCover) {
                count++;
                curCover = nextCover;
            }
            nextCover = Math.max(i + nums[i], nextCover);
        }
        return count;
    }
}
