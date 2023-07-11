package com.agan.leetcode.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
 *
 * 如果树中有不止一个众数，可以按 任意顺序 返回。
 *
 * 假定 BST 满足如下定义：
 *
 * 结点左子树中所含节点的值 小于等于 当前节点的值
 * 结点右子树中所含节点的值 大于等于 当前节点的值
 * 左子树和右子树都是二叉搜索树
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-mode-in-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class $501_FindModeInBinarySearchTree {

    /**
     * 解法1：将数转数组，然后遍历数组记录频次，然后统计前几名
     * @param root
     * @return
     */
    public int[] findMode(TreeNode root) {
        traversal(root);
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    List<Integer> res = new ArrayList<>();
    int maxFrequency = 0;
    //还可以优化。不要额外的存储空间。因为数组树顺序递增的，可以通过判断前一个元素来计次
    Map<Integer, Integer> map = new HashMap<>();

    public void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        traversal(root.left);
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        if (map.get(root.val) > maxFrequency) {
            maxFrequency = map.get(root.val);
            res.clear();
            res.add(root.val);
        } else if (map.get(root.val) == maxFrequency) {
            res.add(root.val);
        }
        traversal(root.right);
    }
}
