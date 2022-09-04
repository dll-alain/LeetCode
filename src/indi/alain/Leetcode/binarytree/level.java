package indi.alain.Leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;

public class level {
    public  List<List<Integer>> resList = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        checkFun(root, 0);
        return resList;
    }

    public void checkFun(TreeNode node, Integer deep) {
        if (node == null) {
            return;
        }
        deep++;
        if (resList.size() < deep) {
            List<Integer> item = new ArrayList<>();
            resList.add(item);
        }
        resList.get(deep - 1).add(node.val);
        checkFun(node.left, deep);
        checkFun(node.right, deep);
    }
}
