package indi.alain.Leetcode.binarytree;

/**
 * @author d
 */
public class SumBSTNodeValue {

    private int preValue = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        convertBST(root.right);
        root.val += preValue;
        preValue = root.val;
        convertBST(root.left);
        return root;
    }
}
