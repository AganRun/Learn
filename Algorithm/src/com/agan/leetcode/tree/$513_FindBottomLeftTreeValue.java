package com.agan.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class $513_FindBottomLeftTreeValue {

    /**
     * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
     *
     * 假设二叉树中至少有一个节点。
     * @param root
     * @return
     */

    public int findBottomLeftValue(TreeNode root) {
        return bfs(root);
    }

    public int bfs(TreeNode root) {
        int left = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                if (i == 0) {
                    left = node.val;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return left;
    }
}
