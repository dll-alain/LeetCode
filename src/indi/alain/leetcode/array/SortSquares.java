package indi.alain.leetcode.array;

import java.util.Arrays;

/**
 * @author d
 */
public class SortSquares {

    public static int[] sortSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int k = nums.length - 1;
        int[] temp = new int[nums.length];
        while (left <= right) {
            if (nums[right] * nums[right] > nums[left] * nums[left]) {
                temp[k--] = nums[right] * nums[right];
                right--;
            } else {
                temp[k--] = nums[left] * nums[left];
                left++;
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-100, -3, 0, 1, 2, 3, 4};
        System.out.println(Arrays.toString(sortSquares(nums)));
    }

}
