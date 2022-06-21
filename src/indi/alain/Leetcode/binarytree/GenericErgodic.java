package indi.alain.Leetcode.binarytree;

import java.util.*;

/**
 * 二叉树遍历通用写法
 * @author d
 */
public class GenericErgodic {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
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
                if (node.left != null) {
                    stack.push(node.left);
                }
                stack.push(node);
                stack.push(null);
            } else {
                result.add(stack.pop().val);
            }
        }
        return result;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                stack.push(node);
                stack.push(null);
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
            } else {
                result.add(stack.pop().val);
            }
        }
        return result;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
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
                result.add(stack.pop().val);
            }
        }
        return result;
    }

}
