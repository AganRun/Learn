package com.agan.leetcode.tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
 *
 *输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * 输出：[3,9,20,null,null,15,7]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class $106_ConstructBinaryTreeFromInorderAndPostorderTraversal {

    int[] inorder;
    int[] postorder;

    Map<Integer, Integer> inIndexMap =  new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        for (int i = 0; i < inorder.length; i++) {
            inIndexMap.put(inorder[i], i);
        }
        return recursion(0, inorder.length - 1, 0, postorder.length - 1);
    }

    /**
     * 好难想呀，需要配合着看
     * https://programmercarl.com/0106.%E4%BB%8E%E4%B8%AD%E5%BA%8F%E4%B8%8E%E5%90%8E%E5%BA%8F%E9%81%8D%E5%8E%86%E5%BA%8F%E5%88%97%E6%9E%84%E9%80%A0%E4%BA%8C%E5%8F%89%E6%A0%91.html#%E6%80%9D%E8%B7%AF
     * https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/solution/tu-jie-gou-zao-er-cha-shu-wei-wan-dai-xu-by-user72/
     * @param inLeft
     * @param inRight
     * @param postLeft
     * @param postRight
     * @return
     */

    public TreeNode recursion(int inLeft, int inRight, int postLeft, int postRight) {
        if (inLeft > inRight || postLeft > postRight) {
            return null;
        }
        int rootValue = postorder[postRight];
        TreeNode root = new TreeNode(rootValue);
        int index = inIndexMap.get(rootValue);
        //pr计算过程解释，后续数组的起始位置加上左子树长度-1 就是后序数组结束位置了，左子树的长度 = 根节点索引-左子树
        root.left = recursion(inLeft, index - 1, postLeft, postLeft + index - inLeft - 1);
        root.right = recursion(index + 1, inRight, postLeft + index - inLeft , postRight - 1);
        return root;
    }

    public static void main(String[] args) {
        $106_ConstructBinaryTreeFromInorderAndPostorderTraversal c = new $106_ConstructBinaryTreeFromInorderAndPostorderTraversal();
        System.out.println(c.buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3}));
    }

}
