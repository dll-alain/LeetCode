package indi.alain.Leetcode.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author d
 */
public class FindBottomLeftValue {
    private int maxDepth = -1;
    private int leftValue = 0;

    // public int findBottomLeftValue(TreeNode root) {
    //     traversal(root, 0);
    //     return leftValue;
    // }

    // private void traversal(TreeNode node, int deep) {
    //     if (node.left == null && node.right == null) {
    //         if (deep > maxDepth) {
    //             maxDepth = deep;
    //             leftValue = node.val;
    //         }
    //         return;
    //     }

    //     //if (node.right != null) traversal(node.right, deep + 1); 找最大右节点
    //     if (node.left != null) traversal(node.left, deep + 1);
    //     if (node.right != null) traversal(node.right, deep + 1);

    //     return;
    // }

    
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            root = queue.poll();
            if (root.right != null) queue.offer(root.right);
            if (root.left != null) queue.offer(root.left);
        }
        return root.val;
    }

}
