package com.agan.leetcode.tree;

/**
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 *
 * 一般来说，删除节点可分为两个步骤：
 *
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 *
 */
public class $450_DeleteNodeInABST {

    /**
     * 如果找到了要删除的节点。
     * 用右子树替代当前节点，
     * 并将左子树挂在到右子树的最左节点
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        }
        //找到了节点
        //1. 没有孩子节点
        if (root.left == null && root.right == null) {
            return null;
        } else if (root.left == null && root.right != null) {
            //2. 左空，右不空
            return root.right;
        } else if (root.left != null && root.right == null) {
            //3. 左不空，右空
            return root.left;
        } else {
            //4. 左右都不空
            TreeNode node = root.right;
            while (node.left != null) {
                node = node.left;
            }
            node.left = root.left;
            root.left = null;
            return root.right;
        }

    }

}
