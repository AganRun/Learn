package com.agan.leetcode.tree;

/**
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class $112_PathSum {

    /**
     * 深度优先。
     * 如果当前是叶子节点，判断节点值与目标值是否相等
     * 如果是非叶子节点，判断左孩子 是否等于 目标值-当前值
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        //叶子节点
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        if (root.left != null) {
            boolean left = hasPathSum(root.left, targetSum - root.val);
            if (left) {
                //如果已经找到了解，提前返回
                return true;
            }
        }
        if (root.right != null) {
            boolean right = hasPathSum(root.right, targetSum - root.val);
            //如果已经找到了解，提前返回
            if (right) {
                return true;
            }
        }
        return false;
    }
}
