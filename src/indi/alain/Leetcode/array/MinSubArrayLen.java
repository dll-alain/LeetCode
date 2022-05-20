package indi.alain.Leetcode.array;

/**
 * @author dll
 * @date 20220513
 */
public class MinSubArrayLen {
    public static void radixSort(int[] nums) {
        int[][] bucket = new int[10][nums.length];
        int[] bucketElementCounts = new int[10];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= max) {
                max = nums[i];
            }
        }
        int maxLength = (max + "").length();
        for (int i = 0; i < maxLength; i++) {
            for (int j = 0; j < nums.length; j++) {
                int digitOfElement = (nums[j] / (int)(Math.pow(10, i))) % 10;
                bucket[digitOfElement][bucketElementCounts[digitOfElement]++] = nums[j];
            }
            int index = 0;
            for (int l = 0; l < bucketElementCounts.length; l++) {
                if (bucketElementCounts[l] != 0) {
                    for (int k = 0; k < bucketElementCounts[l]; k++) {
                        nums[index++] = bucket[l][k];
                    }
                }
                bucketElementCounts[l] = 0;
            }
        }
    }

    public static int sum(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        return sum;
    }

    /**
     * 不连续子数组
     * @param target
     * @param nums
     * @return
     */
    public int minLen(int target, int[] nums) {
        radixSort(nums);
        int sum = sum(nums);
        int temp = target - nums[nums.length - 1];
        int count = 1;
        if (temp <= 0) {
            return 1;
        } else if (sum < target) {
            return 0;
        } else {
            for (int i = 1; i < nums.length; i++) {
                temp -= nums[nums.length -1 -i];
                count++;
                if (temp <= 0) {
                    break;
                }
            }
            return count;
        }
    }

    public static int minSubArrayLen(int[] nums, int target) {
        int left = 0;
        int right;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for (right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                result = Math.min(result, right - left + 1);
                sum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }


}
