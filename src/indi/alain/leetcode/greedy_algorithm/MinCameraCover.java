package indi.alain.leetcode.greedy_algorithm;

/**
 * @author d
 */
public class MinCameraCover {
    int count = 0;
    public int minCameraCover(TreeNode root) {
        if (minCamera(root) == 0) {
            //防止根节点没检测到，因为根节点没有父节点
            count++;
        }
        return count;
    }

    /**
     节点的状态值：
     0 表示无覆盖
     1 表示 有摄像头
     2 表示有覆盖
     后序遍历，根据左右节点的情况,来判读 自己的状态
     */
    private int minCamera(TreeNode root) {
        if (root == null) {
            //空节点必是叶子节点，叶子节点必被覆盖
            return 2;
        }
        int left = minCamera(root.left);
        int right = minCamera(root.right);
        if (left == 0 || right == 0) {
            //左右叶子节点有一个没被覆盖 父节点需要为1
            count++;
            return 1;
        }
        else if (left == 2 && right == 2) {
            //左右叶子节点全被覆盖 父节点需要为0 贪心
            return 0;
        }
        else if (left == 1 || right == 1) {
            //左右叶子节点右一个为1 父节点为2
            return 2;
        }
        return -1;
    }
}


class TreeNode {
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

