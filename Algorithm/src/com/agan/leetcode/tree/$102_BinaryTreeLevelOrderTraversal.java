package com.agan.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
 */
public class $102_BinaryTreeLevelOrderTraversal {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        dsf(root, 0);
        return result;
//        return bfs(root);
    }

    /**
     * 深度优先
     * @param root
     * @param deep
     */
    public void dsf(TreeNode root, int deep) {
        if (root == null) {
            return;
        }
        if (deep + 1 > result.size()) {
            result.add(new ArrayList<>());
        }
        result.get(deep).add(root.val);
        dsf(root.left, deep+1);
        dsf(root.right, deep+1);
    }

    /**
     * 广度优先
     * @param root
     * @return
     */
    public List<List<Integer>> bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return result;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> layer = new ArrayList<>();

            int len = queue.size();
            while (len-- > 0) {
                TreeNode node = queue.poll();
                layer.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(layer);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode left = new TreeNode(2, null, null);
        TreeNode right = new TreeNode(3, null, null);
        TreeNode root = new TreeNode(1, left, right);
        $102_BinaryTreeLevelOrderTraversal s = new $102_BinaryTreeLevelOrderTraversal();
        System.out.println(s.levelOrder(root));
    }
}
