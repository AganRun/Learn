package com.agan.leetcode.tree;

public class $110_BalancedBinaryTree {

    /**
     * 给你一个树，判断是否是平衡二叉树
     */
    public boolean isBalanced(TreeNode root) {
        return bfs(root) != -1;
    }

    public int bfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = bfs(root.left);
        if (left == -1) {
            return -1;
        }
        int right = bfs(root.right);
        if (right == -1) {
            return -1;
        }
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {
        $110_BalancedBinaryTree t = new $110_BalancedBinaryTree();
        TreeNode root = TreeUtils.buildTree(new int[]{1,2,2,3,3,-1,-1,4,4});
        TreeUtils.show(root);
        System.out.println(t.isBalanced(root));
    }
}
