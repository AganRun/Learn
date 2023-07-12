package com.agan.leetcode.tree;

/**
 * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 *
 * 提醒一下，二叉搜索树满足下列约束条件：
 *
 * 节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。
 * 左右子树也必须是二叉搜索树。
 *
 * 输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
 * 输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 *
 */
public class $538_ConvertBSTToGreaterTree {

    /**
     * 其实这就是一棵树，大家可能看起来有点别扭，换一个角度来看，这就是一个有序数组[2, 5, 13]，
     * 求从后到前的累加数组，也就是[20, 18, 13]，是不是感觉这就简单了。
     * @param root
     * @return
     */
    TreeNode pre = null;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        //右->中->左
        root.right = convertBST(root.right);
        if (pre != null) {
            root.val += pre.val;
        }
        pre = root;
        root.left = convertBST(root.left);
        return root;
    }

    public static void main(String[] args) {

    }

}
