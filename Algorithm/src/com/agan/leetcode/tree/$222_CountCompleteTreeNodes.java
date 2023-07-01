package com.agan.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 *
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，
 * 其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。
 * 若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 *
 */
public class $222_CountCompleteTreeNodes {

    /**
     * 针对完全二叉树的特有解法
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        int depthLeft = 0;
        while (left != null) {
            left = left.left;
            depthLeft++;
        }
        int depthright = 0;
        while (right != null) {
            right = right.right;
            depthright++;
        }
        if (depthLeft == depthright) {
            return (2 << depthLeft) - 1;
        }
        return 1 + countNodes(root.left)  + countNodes(root.right) ;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + bfs(root.left) + bfs(root.right);
    }

    public int bfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            while (len-- > 0) {
                count++;
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        $222_CountCompleteTreeNodes s = new $222_CountCompleteTreeNodes();
        System.out.println(s.countNodes(TreeUtils.buildTree(new int[]{1,2,3,4,5,6})));
    }
}
