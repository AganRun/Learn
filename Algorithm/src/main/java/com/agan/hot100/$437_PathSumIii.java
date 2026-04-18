/**
给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。 

 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。 



 示例 1：

 

 
输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
输出：3
解释：和等于 8 的路径有 3 条，如图所示。
 

 示例 2： 

 
输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
输出：3
 

 

 提示: 

 
 二叉树的节点个数的范围是 [0,1000] 
 
 -10⁹ <= Node.val <= 10⁹ 
 -1000 <= targetSum <= 1000 
 

 Related Topics 树 深度优先搜索 二叉树 👍 2284 👎 0

*/
  
package com.agan.hot100;

import java.util.HashMap;
import java.util.Map;

public class $437_PathSumIii{

    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        // if (root == null) return 0;
        // return countFrom(root, targetSum) + pathum(root.left, targetSum) + pathSum(root.right, targetSum);
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return dfs(root, 0, targetSum, map);
    }

    private int countFrom(TreeNode root, long targetSum) {
        if (root == null) {
            return 0;
        }
        int count = (root.val == targetSum) ? 1 : 0;
        long next = targetSum - root.val;
        return count + countFrom(root.left, next) + countFrom(root.right, next);
    }

    public int dfs(TreeNode root, int currentSum, int targetSum, Map<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }
        currentSum += root.val;
        map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        int res = map.getOrDefault(currentSum - targetSum, 0);
        res += dfs(root.left, currentSum, targetSum, map);
        res += dfs(root.right, currentSum, targetSum, map);
        map.put(currentSum, map.get(currentSum) - 1);
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Integer[] rootArr = {10,5,-3,3,2,null,11,3,-2,null,1};
        int targetSum = 8;

        TreeNode root = TreeUtils.buildTree(rootArr);
        $437_PathSumIii outer = new $437_PathSumIii();
        Solution s = outer.new Solution();

        System.out.println(TreeUtils.toLevelOrderLeetCode(root));
        System.out.println(s.pathSum(root, targetSum));
        TreeUtils.show(root);
    }

}