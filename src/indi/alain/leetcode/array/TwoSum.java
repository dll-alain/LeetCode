package indi.alain.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author dll
 * @date 20220511
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                result[0] = map.get(nums[i]);
                result[1] = i;
                return result;
            }
            map.put(target - nums[i], i);
        }
        return result;
    }

    public static void main(String[] args) {
        int target = 11;
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(twoSum(nums, target)));

    }
}
