package com.agan.leetcode.tree;

/**
 * 给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high。通过修剪二叉搜索树，使得所有节点的值在[low, high]中。修剪树 不应该 改变保留在树中的元素的相对结构 (即，如果没有被移除，原有的父代子代关系都应当保留)。 可以证明，存在 唯一的答案 。
 *
 * 所以结果应当返回修剪好的二叉搜索树的新的根节点。注意，根节点可能会根据给定的边界发生改变。
 *
 * 输入：root = [1,0,2], low = 1, high = 2
 * 输出：[1,null,2]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/trim-a-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class $669_TrimABinarySearchTree {

    /**
     * 删除超过边界的节点
     * 遍历过程中，如果有小于Low的节点，返回他的右字数
     * 如果右大于high的节点，返回它的左子树
     * @param root
     * @param low
     * @param high
     * @return
     */
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }
        // root在[low,high]范围内
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }

    public static void main(String[] args) {
        $669_TrimABinarySearchTree t = new $669_TrimABinarySearchTree();
        TreeNode root = TreeUtils.buildTree(new int[]{3,0,4,-1,2,-1,-1,-1,-1,1,-1,-1,-1,-1,-1});
        TreeUtils.show(root);
        TreeUtils.show(t.trimBST(root, 1, 3));
    }
}
