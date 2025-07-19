package com.agan.leetcode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 给你二叉树的根节点 root ，返回它节点值的 后序 遍历。
 */
public class $145_BinaryTreePostorderTraversal {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traversal(root, result);
        return result;
    }

    public void traversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        traversal(root.left, result);
        traversal(root.right, result);
        result.add(root.val);
    }

    /**
     * 后续遍历
     * 目标：左 右 中
     * 入栈 中 左 右
     * 出栈 中 右 左
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (root.right != null) stack.push(node.right);
            if (root.left != null) stack.push(node.right);
        }
        Collections.reverse(result);
        return result;
    }


    public static void main(String[] args) {
        $145_BinaryTreePostorderTraversal traversal = new $145_BinaryTreePostorderTraversal();
        TreeNode left = new TreeNode(2, null, null);
        TreeNode right = new TreeNode(3, null, null);
        TreeNode root = new TreeNode(1, left, right);
        System.out.println(traversal.postorderTraversal(root));
    }

}
