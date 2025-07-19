package com.agan.leetcode.tree;

import java.util.*;

public class $257_BinaryTreePaths {

    /**
     * 给你一个二叉树的根节点 root ，按 任意顺序 ，
     * 返回所有从根节点到叶子节点的路径。
     *
     * 叶子节点 是指没有子节点的节点。
     *
     *
     * @param root
     * @return
     */

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
//        dfs(root, "", result);
        return recursion(root);
    }

    /**
     * 深度优先
     * @param root
     * @param path
     * @param result
     */
    public void dfs(TreeNode root, String path, List<String> result) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            result.add(path + root.val);
        }
        dfs(root.left, path + root.val + "->", result);
        dfs(root.right, path + root.val + "->", result);
    }

    /**
     * 深度有限，栈写法
     * @param root
     * @return
     */
    public List<String> dfsWithStack(TreeNode root) {
        List<String> result = new ArrayList<>();
        Stack<Object> stack = new Stack<>();
        stack.push(root);
        stack.push("" + root.val);
        while (!stack.isEmpty()) {
            String path = (String) stack.pop();
            TreeNode node = (TreeNode) stack.pop();
            if (node.left == null && node.right == null) {
                result.add(path);
            }
            if (node.left != null) {
                stack.push(node.left);
                stack.push(path + "->" + node.left.val);
            }
            if (node.right != null) {
                stack.push(node.right);
                stack.push(path  + "->" + node.right.val);
            }
        }
        return result;
    }

    /**
     * 广度优先
     * @param root
     * @return
     */
    public List<String> bfs(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null)
            return res;
        //队列，节点和路径成对出现，路径就是从根节点到当前节点的路径
        Queue<Object> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root.val + "");
        while (!queue.isEmpty()) {
            TreeNode node = (TreeNode) queue.poll();
            String path = (String) queue.poll();
            //如果到叶子节点，说明找到了一条完整路径
            if (node.left == null && node.right == null) {
                res.add(path);
            }

            //右子节点不为空就把右子节点和路径存放到队列中
            if (node.right != null) {
                queue.add(node.right);
                queue.add(path + "->" + node.right.val);
            }

            //左子节点不为空就把左子节点和路径存放到队列中
            if (node.left != null) {
                queue.add(node.left);
                queue.add(path + "->" + node.left.val);
            }
        }
        return res;
    }

    /**
     * 递归写法
     * @param root
     * @return
     */
    public List<String> recursion(TreeNode root) {
        List<String> res = new LinkedList<>();
        if (root == null)
            return res;
        //到达叶子节点，把路径加入到集合中
        if (root.left == null && root.right == null) {
            res.add(root.val + "");
            return res;
        }
        //遍历左子节点的路径
        for (String path : recursion(root.left)) {
            res.add(root.val + "->" + path);
        }
        //遍历右子节点的路径
        for (String path : recursion(root.right)) {
            res.add(root.val + "->" + path);
        }
        return res;
    }

    public static void main(String[] args) {
        $257_BinaryTreePaths t = new $257_BinaryTreePaths();
        TreeNode root = TreeUtils.buildTree(new int[]{1, 2, 3, -1, 5});
        System.out.println(t.binaryTreePaths(root));

    }
}
