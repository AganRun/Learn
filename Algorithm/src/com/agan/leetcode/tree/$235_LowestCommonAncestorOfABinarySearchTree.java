package com.agan.leetcode.tree;

/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 *
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class $235_LowestCommonAncestorOfABinarySearchTree {

    /**
     * 二叉搜索树是递增的。所以两个节点的最近公共祖先，就是第一次出现的，值位于pq直接的节点
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        //值太大，想左字数寻找
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        //值太小，想右字数寻找
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        //最有一种可能，在二者中间
        return root;
    }

    public static void main(String[] args) {
        $235_LowestCommonAncestorOfABinarySearchTree c = new $235_LowestCommonAncestorOfABinarySearchTree();
        TreeNode root = TreeUtils.buildTree(new int[]{6,2,8,0,4,7,9,-1,-1,3,5});
        TreeUtils.show(root);
        System.out.println(c.lowestCommonAncestor(root, new TreeNode(3),new TreeNode(5)).val);
    }
}
