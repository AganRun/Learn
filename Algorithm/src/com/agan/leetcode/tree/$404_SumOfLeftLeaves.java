package com.agan.leetcode.tree;

public class $404_SumOfLeftLeaves {

    /**
     * 给定二叉树的根节点 root ，返回所有左叶子之和。
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int pos) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null && pos == 1) {
            return root.val;
        }
        return dfs(root.left, 1) + dfs(root.right, 0);
    }
}
