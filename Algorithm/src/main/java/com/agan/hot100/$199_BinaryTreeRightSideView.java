/**
 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。



 示例 1： 


 输入：root = [1,2,3,null,5,null,4] 


 输出：[1,3,4] 

 解释： 



 示例 2： 


 输入：root = [1,2,3,4,null,null,null,5] 


 输出：[1,3,4,5] 

 解释： 



 示例 3： 


 输入：root = [1,null,3] 


 输出：[1,3] 

 示例 4： 


 输入：root = [] 


 输出：[] 



 提示: 


 二叉树的节点个数的范围是 [0,100] 

 -100 <= Node.val <= 100 


 Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1323 👎 0

 */

package com.agan.hot100;

import java.util.ArrayList;
import java.util.List;

public class $199_BinaryTreeRightSideView{

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

        List<Integer> result = new ArrayList<>();

        public List<Integer> rightSideView(TreeNode root) {
            reversion(root, 0);
            return result;
        }

        public void reversion(TreeNode root, int deepth) {
            if (root == null) {
                return;
            }
            if (deepth == result.size()) { //深度首次遇到
                result.add(root.val);
            }
            reversion(root.right, deepth + 1);
            reversion(root.left, deepth + 1);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}