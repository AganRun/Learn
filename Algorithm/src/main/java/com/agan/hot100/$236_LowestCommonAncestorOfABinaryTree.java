package com.agan.hot100;

public class $236_LowestCommonAncestorOfABinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return reversion(root, p, q);
    }

    public TreeNode reversion(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = reversion(root.left, p, q);
        TreeNode right = reversion(root.right, p, q);
        if (left == null || right == null) return right == null ? left : right;
        return root;
    }
}
