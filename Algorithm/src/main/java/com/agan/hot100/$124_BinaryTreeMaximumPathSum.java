package com.agan.hot100;

public class $124_BinaryTreeMaximumPathSum {

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        reversion(root);
        return max;
    }

    public int reversion(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = reversion(root.left);
        int right = reversion(root.right);
        max = Math.max(max, left + right + root.val);
        return Math.max(Math.max(left, right) + root.val, 0);
    }
}
