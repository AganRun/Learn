package com.agan.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明：叶子节点是指没有子节点的节点。
 *
 *
 */
public class $111_MinimumDepthOfBinaryTree {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root);
    }

    public int dfs(TreeNode root) {
        if (root.left == null && root.right == null) {
            //这里是叶子节点，所以返回1
            return 1;
        }
        if (root.left == null) {
            return 1 + dfs(root.right);
        }
        if (root.right == null) {
            return 1 + dfs(root.left);
        }
        return 1 + Math.min(dfs(root.left), dfs(root.right));
    }

    public int bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            depth++;
            int len = queue.size();
            while (len-- > 0) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return depth;
    }
    public static void main(String[] args) {

    }
}
