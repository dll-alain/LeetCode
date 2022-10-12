package indi.alain.leetcode.binarytree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 中序翻转
 * @author d
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (node.right != null) {
                    stack.push(node.right);
                }
                stack.push(node);
                stack.push(null);
                if (node.left != null) {
                    stack.push(node.left);
                }
            } else {
                TreeNode nodeCenter = stack.pop();
                TreeNode temp = nodeCenter.left;
                nodeCenter.left = nodeCenter.right;
                nodeCenter.right = temp;
            }
        }
        return root;
    }
}
