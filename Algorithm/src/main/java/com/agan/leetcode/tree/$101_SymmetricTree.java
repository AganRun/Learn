package com.agan.leetcode.tree;


public class $101_SymmetricTree {

    /**
     * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfs(root.left, root.right);

    }

    /**
     * 递归法
     * 也可以将元素放入队列或者栈中。两个两个去除，看是否相等。
     * 如果相等，同时再将他们的左右子数放入队列，知道栈为空，或者发现不相等
     * @param left
     * @param right
     * @return
     */
    boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null) {
            return false;
        } else if (right == null) {
            return false;
        } else if (left.val != right.val) {
            return false;
        }
        return dfs(left.right, right.left) && dfs(left.left, right.right);
    }

}
