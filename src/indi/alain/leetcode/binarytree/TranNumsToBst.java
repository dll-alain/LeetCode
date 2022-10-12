package indi.alain.leetcode.binarytree;

/**
 * @author d
 */
public class TranNumsToBst {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root =  findNode(nums, 0, nums.length - 1);
        return root;
    }

    private TreeNode findNode(int[] nums,int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + ((right - left) / 2);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = findNode(nums, left, mid - 1);
        root.right = findNode(nums, mid + 1, right);
        return root;
    }

}
