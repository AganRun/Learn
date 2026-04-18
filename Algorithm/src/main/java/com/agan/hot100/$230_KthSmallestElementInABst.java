package com.agan.hot100;

public class $230_KthSmallestElementInABst {

    int res = 0;
    int k =0;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        reversion(root);
        return res;
    }



    public void reversion(TreeNode root) {
        if (root == null) {
            return;
        }
        reversion(root.left);
        if (--k == 0) {
            res = root.val;
        }
        reversion(root.right);
    }
}
