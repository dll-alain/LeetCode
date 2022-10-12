package indi.alain.leetcode.binarytree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 递归解决对称二叉树
 * 迭代解决相同二叉树
 * @author d
 */
public class IsSymmetric {

    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        deque.offer(1);
    }

    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
      }
    }

    private boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right != null) {
            return false;
        }
        if (left != null && right == null) {
            return false;
        }

        if (left == null && right == null) {
            return true;
        }
        if (left.val != right.val) {
            return false;
        }
        // 比较外侧
        boolean compareOutside = compare(left.left, right.right);
        // 比较内侧
        boolean compareInside = compare(left.right, right.left);
        return compareOutside && compareInside;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);
        while (!queue.isEmpty()) {
            TreeNode leftNode = queue.poll();
            TreeNode rightNode = queue.poll();
            if (leftNode == null && rightNode == null) {
                continue;
            }
            if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) {
                return false;
            }
            //相等，而非对称
            queue.offer(leftNode.left);
            queue.offer(rightNode.left);
            queue.offer(leftNode.right);
            queue.offer(rightNode.right);
        }
        return true;
    }

}
