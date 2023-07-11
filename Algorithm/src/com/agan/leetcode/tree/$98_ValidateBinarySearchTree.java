package com.agan.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *
 * 有效 二叉搜索树定义如下：
 *
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class $98_ValidateBinarySearchTree {

    /**
     * 思路：二叉搜索树的前序遍历是递增数组。验证数组就OK了
     */
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        transTreeToList(root, list);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    public void transTreeToList(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        transTreeToList(root.left, list);
        list.add(root.val);
        transTreeToList(root.right, list);
    }

    /**
     * 在递归过程中，记录最大值。采用中序遍历，过程中判断，是一样的
     * @param root
     * @return
     */
    long maxValue = Long.MIN_VALUE;
    public boolean isValidBST2(TreeNode root) {
        //终止条件
        if (root == null) {
            return true;
        }
        //中序遍历
        boolean left = isValidBST2(root.left);
        if (maxValue < root.val) {
            maxValue = root.val;
        } else {
            return false;
        }
        boolean right = isValidBST2(root.right);
        return left && right;
    }

}
