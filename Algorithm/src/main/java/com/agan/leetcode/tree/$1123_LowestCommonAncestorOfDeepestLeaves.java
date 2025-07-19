package com.agan.leetcode.tree;


import javafx.util.Pair;

/**
 * 给你一个有根节点 root 的二叉树，返回它 最深的叶节点的最近公共祖先 。
 *
 * 回想一下：
 *
 * 叶节点 是二叉树中没有子节点的节点
 * 树的根节点的 深度 为 0，如果某一节点的深度为 d，那它的子节点的深度就是 d+1
 * 如果我们假定 A 是一组节点 S 的 最近公共祖先，S 中的每个节点都在以 A 为根节点的子树中，且 A 的深度达到此条件下可能的最大值。
 *
 *
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4]
 * 输出：[2,7,4]
 * 解释：我们返回值为 2 的节点，在图中用黄色标记。
 * 在图中用蓝色标记的是树的最深的节点。
 * 注意，节点 6、0 和 8 也是叶节点，但是它们的深度是 2 ，而节点 7 和 4 的深度是 3 。
 * https://s3-lc-upload.s3.amazonaws.com/uploads/2018/07/01/sketch1.png
 *
 * 参考答案https://leetcode.cn/problems/lowest-common-ancestor-of-deepest-leaves/solutions/2428724/liang-chong-di-gui-si-lu-pythonjavacgojs-xxnk/?envType=daily-question&envId=2023-09-06
 */
public class $1123_LowestCommonAncestorOfDeepestLeaves {

    TreeNode res = new TreeNode();
    int maxDepth;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
//        dfs1(root, 0);
//        return res;
        return dfs2(root).getValue();
    }

    /**
     * 递归这棵二叉树，同时维护全局最大深度 maxDepth\textit{maxDepth}maxDepth。
     * 在「递」的时候往下传 depth\textit{depth}depth，用来表示当前节点的深度。
     * 在「归」的时候往上传当前子树最深叶节点的深度。
     *
     * 设左子树最深叶节点的深度为 leftMaxDepth\textit{leftMaxDepth}leftMaxDepth
     * 右子树最深叶节点的深度为 rightMaxDepth\textit{rightMaxDepth}rightMaxDepth。
     * 如果 leftMaxDepth=rightMaxDepth=maxDepth\textit{leftMaxDepth}=\textit{rightMaxDepth}=\textit{maxDepth}leftMaxDepth=rightMaxDepth=maxDepth，
     * 那么更新答案为当前节点。注意这并不代表我们找到了答案，如果后面发现了更深的叶节点，那么答案还会更新。
     *
     * @param root
     * @param depth
     * @return
     */
    public int dfs1(TreeNode root, int depth) {
        if (root == null) {
            maxDepth = Math.max(depth, maxDepth);
            return depth;
        }
        int leftDep = dfs1(root.left, depth + 1);
        int rightDep = dfs1(root.right, depth + 1);
        if (leftDep == maxDepth && rightDep == maxDepth) {
            res = root;
        }
        return Math.max(leftDep, rightDep);
    }

    /**
     * 自底向上
     * 设子树的根节点为 node\textit{node}node，node\textit{node}node 的左子树的高度为 leftHeight\textit{leftHeight}leftHeight，node\textit{node}node 的右子树的高度为 rightHeight\textit{rightHeight}rightHeight。
     * 如果 leftHeight>rightHeight\textit{leftHeight} > \textit{rightHeight}leftHeight>rightHeight，那么子树的高度为 leftHeight+1\textit{leftHeight} + 1leftHeight+1，lca\textit{lca}lca 是左子树的 lca\textit{lca}lca。
     * 如果 leftHeight<rightHeight\textit{leftHeight} < \textit{rightHeight}leftHeight<rightHeight，那么子树的高度为 rightHeight+1\textit{rightHeight} + 1rightHeight+1，lca\textit{lca}lca 是右子树的 lca\textit{lca}lca。
     * 如果 leftHeight=rightHeight\textit{leftHeight} = \textit{rightHeight}leftHeight=rightHeight，那么子树的高度为 leftHeight+1\textit{leftHeight} + 1leftHeight+1，lca\textit{lca}lca 就是 node\textit{node}node。反证法：如果 lca\textit{lca}lca 在左子树中，那么 lca\textit{lca}lca 不是右子树的最深叶结点的祖先，这不对；如果 lca\textit{lca}lca 在右子树中，那么 lca\textit{lca}lca 不是左子树的最深叶结点的祖先，这也不对；如果 lca\textit{lca}lca 在 node\textit{node}node 的上面，那就不符合「最近」的要求。所以 lca\textit{lca}lca 只能是 node\textit{node}node。
     *     * @param node
     * @return
     */
    private Pair<Integer, TreeNode> dfs2(TreeNode node) {
        if (node == null)
            return new Pair<>(0, null);
        Pair<Integer, TreeNode> left = dfs2(node.left);
        Pair<Integer, TreeNode> right = dfs2(node.right);
        if (left.getKey() > right.getKey()) // 左子树更高
            return new Pair<>(left.getKey() + 1, left.getValue());
        if (left.getKey() < right.getKey()) // 右子树更高
            return new Pair<>(right.getKey() + 1, right.getValue());
        return new Pair<>(left.getKey() + 1, node); // 一样高
    }

    public static void main(String[] args) {
        TreeNode rootNode = TreeUtils.buildTree(new int[]{3, 5, 1, 6, 2, 0, 8, -1, -1, 7, 4});
        $1123_LowestCommonAncestorOfDeepestLeaves s = new $1123_LowestCommonAncestorOfDeepestLeaves();
        TreeNode treeNode = s.lcaDeepestLeaves(rootNode);
        System.out.println(treeNode.val);
    }

}
