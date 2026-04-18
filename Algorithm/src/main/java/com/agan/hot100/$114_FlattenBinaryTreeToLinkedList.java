package com.agan.hot100;

public class $114_FlattenBinaryTreeToLinkedList {

    /**
     *
     * 可以发现展开的顺序其实就是二叉树的先序遍历。算法和 94 题中序遍历的 Morris 算法有些神似，我们需要两步完成这道题。
     *
     * 将左子树插入到右子树的地方
     * 将原来的右子树接到左子树的最右边节点
     * 考虑新的右子树的根节点，一直重复上边的过程，直到新的右子树为 null
     *
     *     1
     *    / \
     *   2   5
     *  / \   \
     * 3   4   6
     *
     * //将 1 的左子树插入到右子树的地方
     *     1
     *      \
     *       2         5
     *      / \         \
     *     3   4         6
     * //将原来的右子树接到左子树的最右边节点
     *     1
     *      \
     *       2
     *      / \
     *     3   4
     *          \
     *           5
     *            \
     *             6
     *
     *  //将 2 的左子树插入到右子树的地方
     *     1
     *      \
     *       2
     *        \
     *         3       4
     *                  \
     *                   5
     *                    \
     *                     6
     *
     *  //将原来的右子树接到左子树的最右边节点
     *     1
     *      \
     *       2
     *        \
     *         3
     *          \
     *           4
     *            \
     *             5
     *              \
     *               6
     *
     *   ......
     *
     * 作者：windliang
     * 链接：https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/solutions/17274/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--26/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param root
     */
    public void flatten(TreeNode root) {
        while(root != null) {
            if (root.left == null) {
                root = root.right;
            } else {
                //左子树移动到右子树
                TreeNode right = root.right;
                TreeNode cur = root.left;
                root.right = root.left;
                root.left = null;
                // 原来的右子树，拼到左子树的最右节点
                while (cur.right != null) {
                    cur = cur.right;
                }
                cur.right = right;
                root = root.right;
            }
        }
    }
}
