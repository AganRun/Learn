package com.agan.hot100;

import java.util.ArrayList;
import java.util.List;

public class $98_ValidateBinarySearchTree {

    List<Integer> list = new ArrayList();

    public boolean isValidBST(TreeNode root) {
        reversion(root);
        for(int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i-1)) {
                return false;
            }
        }
        return true;
    }

    public void reversion(TreeNode root) {
        if (root == null) {
            return;
        }
        reversion(root.left);
        list.add(root.val);
        reversion(root.right);
    }

    /**
     * 本地调试：对应 LeetCode 层序输入 {@code [1,1]} —— 根结点值为 1，第二个 {@code 1} 按惯例挂在根的左子。
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);

        boolean result = new $98_ValidateBinarySearchTree().isValidBST(root);
        System.out.println("[1,1] => " + result);
    }
}
