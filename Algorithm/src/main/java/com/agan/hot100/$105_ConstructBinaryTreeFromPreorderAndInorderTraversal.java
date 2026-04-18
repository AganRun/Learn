package com.agan.hot100;

public class $105_ConstructBinaryTreeFromPreorderAndInorderTraversal {

/**
 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回
 其根节点。



 示例 1:


 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 输出: [3,9,20,null,null,15,7]


 示例 2:


 输入: preorder = [-1], inorder = [-1]
 输出: [-1]




 提示:


 1 <= preorder.length <= 3000
 inorder.length == preorder.length
 -3000 <= preorder[i], inorder[i] <= 3000
 preorder 和 inorder 均 无重复 元素
 inorder 均出现在 preorder
 preorder 保证 为二叉树的前序遍历序列
 inorder 保证 为二叉树的中序遍历序列


 Related Topics 树 数组 哈希表 分治 二叉树 👍 2729 👎 0

 */


    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return reversion(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    public TreeNode reversion(int[] preorder, int pstart, int pend, int[] inorder, int istart, int iend) {
        if (pstart > pend || istart > iend) {
            return null;
        }
        int rootVal = preorder[pstart];
        TreeNode root = new TreeNode(rootVal);
        int i_left_middle = 0;
        for(int i = istart; i <= iend; i++) {
            if (inorder[i] == rootVal) {
                i_left_middle = i;
            }
        }
        int leftSize = i_left_middle - istart;
        int rightSize = iend - i_left_middle;
        root.left = reversion(preorder, pstart + 1,  pstart + leftSize, inorder, istart,i_left_middle - 1);
        root.right = reversion(preorder, pend - rightSize + 1, pend, inorder, i_left_middle + 1, iend);

        return root;

    }
//leetcode submit region end(Prohibit modification and deletion)

    /** 调试用：层序输出，与题面 [3,9,20,null,null,15,7] 一致 */
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode root = new $105_ConstructBinaryTreeFromPreorderAndInorderTraversal().buildTree(preorder, inorder);
        System.out.println(TreeUtils.toLevelOrderLeetCode(root));
        TreeUtils.show(root);
    }

}