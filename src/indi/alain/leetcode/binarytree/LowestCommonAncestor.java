package indi.alain.leetcode.binarytree;

/**
 * @author d
 */
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode leftTra = lowestCommonAncestor(root.left, p, q);
        TreeNode rightTra = lowestCommonAncestor(root.right, p, q);
        if (leftTra != null && rightTra != null) {
            return root;
        } else if (leftTra != null && rightTra == null) {
            return leftTra;
        } else if (leftTra == null && rightTra != null) {
            return rightTra;
        }
        return null;
    }
}
