package indi.alain.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 *全部路径
 * @author d
 */
public class PathSum {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        List<List<Integer>> reslut = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            traversal(root, targetSum);
            return reslut;
        }

        private void traversal(TreeNode node, int targetSum) {
            if (node == null) {
                return;
            }
            targetSum -= node.val;
            temp.add(node.val);
            if (node.left == null && node.right == null && targetSum == 0) {
                //result 的尾指向temp,若不开辟新的空间就会迭代指向最后一个temp,也就是[]
                reslut.add(new ArrayList<>(temp));
            }
            //if (node.left != null) 可以省略
            traversal(node.left, targetSum);
            //if (node.right != null)
            traversal(node.right, targetSum);
            temp.remove(temp.size() - 1);
        }
    }

}
