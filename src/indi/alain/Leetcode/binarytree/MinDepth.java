package indi.alain.Leetcode.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author d
 */
public class MinDepth {
    /**
     * 广度优先迭代
     * 速度较快
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            depth++;
            int len = queue.size();
            while (len-- > 0) {
                TreeNode temp = queue.poll();
                if (temp.left == null && temp.right == null) {
                    return depth;
                }
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
        }
        return depth;
    }

    /**
     * 深度优先递归
     * @param root
     * @return
     */
    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        if (root.left == null) {
            return rightDepth + 1;
        }
        if (root.right == null) {
            return leftDepth + 1;
        }
        return Math.min(leftDepth, rightDepth) + 1;
    }
}
