package indi.alain.leetcode.binarytree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author d
 */
public class BuildTree {
    private Map<Integer, Integer> map = new HashMap<>();

    /**
     * 前中序 构造
     * @param preorder 前序
     * @param inorder 中序
     * @return 根节点
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return findNode(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }
    private TreeNode findNode(int[] preorder, int preBegin, int preEnd, int[] inorder, int inBegin, int inEnd) {
        if (preBegin >= preEnd || inBegin >= inEnd) {
            return null;
        }
        int rootIndex = map.get(preorder[preBegin]);
        int rootValue = inorder[rootIndex];
        TreeNode root = new TreeNode(rootValue);
        int lenOfLeft = rootIndex - inBegin;

        root.left = findNode(preorder, preBegin + 1, preBegin + 1 + lenOfLeft, inorder, inBegin, rootIndex);
        root.right = findNode(preorder, preBegin + 1 + lenOfLeft, preEnd, inorder, rootIndex + 1, inEnd);

        return root;
    }


    /*
    中后序构造
     */
//    public TreeNode buildTree(int[] inorder, int[] postorder) {
//        for (int i = 0; i < inorder.length; i++) {
//            map.put(inorder[i], i);
//        }
//        return findNode(inorder, 0, inorder.length, postorder, 0, postorder.length);
//
//    }
//
//    private TreeNode findNode(int[] inorder, int inBegin, int inEnd, int[] postorder, int postBegin, int postEnd) {
//        if (inBegin >= inEnd || postBegin >= postEnd) {
//            return null;
//        }
//
//        int rootIndex = map.get(postorder[postEnd - 1]);
//        int rootValue = inorder[rootIndex];
//        TreeNode root = new TreeNode(rootValue);
//        int lenOfLeft = rootIndex - inBegin;
//
//        root.left = findNode(inorder, inBegin, rootIndex, postorder, postBegin, postBegin + lenOfLeft);
//        root.right = findNode(inorder, rootIndex + 1, inEnd, postorder, postBegin + lenOfLeft, postEnd - 1);
//
//        return root;
//    }




}
