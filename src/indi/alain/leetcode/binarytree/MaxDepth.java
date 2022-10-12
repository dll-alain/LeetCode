package indi.alain.leetcode.binarytree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * e二叉树最大深度
 * @author d
 */
public class MaxDepth {

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            depth++;
            while (len-- > 0) {
                Node temp = queue.poll();
                for (int i = 0; i < temp.children.size(); i++) {
                    if (temp.children.get(i) != null) {
                        queue.offer(temp.children.get(i));
                    }
                }
            }
        }
        return depth;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
