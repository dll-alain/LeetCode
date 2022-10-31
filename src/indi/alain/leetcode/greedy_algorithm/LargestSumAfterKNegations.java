package indi.alain.leetcode.greedy_algorithm;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author d
 */
public class LargestSumAfterKNegations {
    public int largestSumAfterKNegations(int[] nums, int K) {
        // 将数组按照绝对值大小从大到小排序，注意要按照绝对值的大小
        nums = IntStream.of(nums)
                .boxed()
                .sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1))
                .mapToInt(Integer::intValue).toArray();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            //从前向后遍历，遇到负数将其变为正数，同时K--
            if (nums[i] < 0 && K > 0) {
                nums[i] = -nums[i];
                K--;
            }
        }
        // 如果K还大于0，那么反复转变数值最小的元素，将K用玩
        //反复作用于绝对最小的正数，也就是偶数相当于无作为
        if (K % 2 == 1) {
            nums[len - 1] = -nums[len - 1];
        }
        return Arrays.stream(nums).sum();
    }
}
