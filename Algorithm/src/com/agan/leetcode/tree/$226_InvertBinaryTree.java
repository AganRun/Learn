package com.agan.leetcode.tree;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 *
 * 输入：root = [2,1,3]
 * 输出：[2,3,1]
 */
public class $226_InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        return dfs(root);
//        return bfs(root);
    }

    /**
     * 解法1、递归，深度遍历
     * @param root
     * @return
     */
    public TreeNode dfs(TreeNode root) {
        if (root == null) {
            return null;
        }
        swap(root);
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    /**
     * 解法2，迭代法
     * @param root
     */
    public TreeNode bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                continue;
            }
            swap(node);
            queue.offer(node.left);
            queue.offer(node.right);
        }
        return root;
    }

    public void swap(TreeNode root) {
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }

    public static void main(String[] args) {
        $226_InvertBinaryTree s = new $226_InvertBinaryTree();
        TreeNode left = new TreeNode(2, null, null);
        TreeNode right = new TreeNode(3, null, null);
        TreeNode root = new TreeNode(1, left, right);
        System.out.println(s.invertTree(root));
    }
}
