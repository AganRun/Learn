package com.agan.leetcode.tree;

/**
 * 108. 将有序数组转换为二叉搜索树
 *
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 *
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 输入：nums = [-10,-3,0,5,9]
 * 输出：[0,-3,9,-10,null,5]
 * 解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class $108_ConvertSortedArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        return recursion(nums, 0, nums.length-1);

    }

    public TreeNode recursion(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (end + start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = recursion(nums, start, mid-1);
        root.right = recursion(nums, mid+1, end);
        return root;
    }

    public static void main(String[] args) {
        $108_ConvertSortedArrayToBinarySearchTree c = new $108_ConvertSortedArrayToBinarySearchTree();
        TreeUtils.show(c.sortedArrayToBST(new int[]{-10,-4,-3,0,1,2,3,4,5,9}));
    }
}
