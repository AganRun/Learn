package com.agan.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static java.lang.Math.max;

public class $104_MaximumDepthOfBinaryTree {

    /**
     * 给定一个二叉树，找出其最大深度。
     *
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * 示例：
     * 给定二叉树 [3,9,20,null,null,15,7]，
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     * @param root
     * @return
     */
    Integer max = Integer.MIN_VALUE;
    public int maxDepth(TreeNode root) {
        return dsf(root);
    }

    /**
     * 递归法
     * @param root
     * @return
     */
    public Integer dsf(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(dsf(root.left), dsf(root.right));
    }

    /**
     * 迭代法
     */
    public int bfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            while (len-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            depth++;
        }
        return depth;
    }

}
