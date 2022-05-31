package indi.alain.Leetcode.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author d
 * @date 20220531
 */
public class ThreeSum {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList();
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    return result;
                }
                if (i > 0 && nums[i] == nums[i - 1]) {
                    // i 降重
                    continue;
                }
                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {
                    if (nums[i] + nums[left] + nums[right] < 0) {
                        left++;
                    } else if (nums[i] + nums[left] + nums[right] > 0) {
                        right--;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                        while (left < right && nums[left + 1] == nums[left]) {
                            // left 降重
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            //right 降重
                            right--;
                        }

                        left++;
                        right--;
                    }
                }
            }
            return result;
        }
}
