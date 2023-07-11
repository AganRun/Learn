package com.agan.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 530. 二叉搜索树的最小绝对差
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 *
 * 差值是一个正数，其数值等于两值之差的绝对值。
 * 输入：root = [4,2,6,1,3]
 * 输出：1
 */
public class $530_MinimumAbsoluteDifferenceInBST {

    /**
     * 解法1：将树存入数组，然后遍历数组，求最小值
     * @param root
     * @return
     */
    public int getMinimumDifference1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        recursion(root, list);
        for (int i = 1; i < list.size(); i++) {
            min = Math.min(min, Math.abs(list.get(i) - list.get(i-1)));
        }
        return min;
    }

    public void recursion(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        recursion(root.left, list);
        list.add(root.val);
        recursion(root.right, list);
    }

    /**
     * 解法2：在递归过程中，通过前驱节点保留上个节点
     */
    int min = Integer.MAX_VALUE;
    TreeNode pre = null;
    public int getMinimumDifference(TreeNode root) {
        traversal(root);
        return min;
    }

    public void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        traversal(root.left);
        if (pre != null) {
            min = Math.min(min, root.val - pre.val);
        }
        pre = root;
        traversal(root.right);
    }


}
