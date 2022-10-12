package indi.alain.leetcode.binarytree;

/**
 * @author d
 */
public class ConstructMaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return findNode(nums, 0, nums.length);
    }

    private static TreeNode findNode(int[] nums, int leftIndex, int rightIndex) {
        if (rightIndex - leftIndex < 1) {
            return null;
        }
        if (rightIndex - leftIndex == 1) {
            return new TreeNode(nums[leftIndex]); //left close right open
        }
        int maxIndex = leftIndex;
        int maxValue = nums[leftIndex];
        for (int i = leftIndex + 1; i < rightIndex; i++) {
            if (maxValue < nums[i]) {
                maxIndex = i;
                maxValue = nums[i];
            }
        }
        TreeNode root = new TreeNode(maxValue);
        root.left = findNode(nums, leftIndex, maxIndex);
        root.right = findNode(nums, maxIndex + 1, rightIndex);
        return root;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 6, 0, 5};
        TreeNode root = findNode(nums, 0, nums.length);

    }
}
