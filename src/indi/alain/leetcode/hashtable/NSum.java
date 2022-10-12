package indi.alain.leetcode.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author d
 * n数之和的轮子
 */
public class NSum {
    public List<List<Integer>> nSum(int[] nums, int n, int start, int target) {
        Arrays.sort(nums);
        int size = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        if (n < 2 || size < n) {
            return result;
        }

        if (n == 2) {
            int left = start;
            int right = size - 1;
            while (left < right) {
                int leftElem = nums[left];
                int rightElem = nums[right];
                int sum = leftElem + rightElem;
                if (sum < target) {
                    while (left < right && nums[left] == leftElem) {
                        left++;
                    }
                } else if (sum > target) {
                    while (left < right && nums[right] == rightElem) {
                        right--;
                    }
                } else {
                    result.add(Arrays.asList(leftElem, rightElem));
                    while (left < right && nums[left] == leftElem) {
                        left++;
                    }
                    while (left < right && nums[right] == rightElem) {
                        right--;
                    }
                }
            }
        } else {
            //大于两个数，采用递归
            for (int i = start; i < size; i++) {
                List<List<Integer>> subResult = nSum(nums, n-1, i+1, target - nums[i]);
                for (List<Integer> list : subResult) {
                    List<Integer> arrayList = new ArrayList<>();
                    arrayList.add(nums[i]);
                    arrayList.addAll(list);
                    result.add(arrayList);
                }
                while (i < size - 1 && nums[i+ 1] == nums[i]) {
                    i++;
                }
            }
        }
        return result;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        while (left < right && nums[left] == nums[left+1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right-1]) {
                            right--;
                        }
                        left++;
                        right--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        NSum fourSum = new NSum();
        System.out.println(fourSum.nSum(nums, 4, 0, 0));
    }

}
