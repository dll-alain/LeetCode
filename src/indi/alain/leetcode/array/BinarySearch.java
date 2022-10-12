package indi.alain.leetcode.array;

/**
 * @author dll
 * @date 20220511
 */
public class BinarySearch {

    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5};
        int target = 5;
        System.out.println(binarySearch(nums, target));
    }

}
