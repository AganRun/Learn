package com.agan.hot100;

import java.util.ArrayList;
import java.util.List;

public class $22_GenerateParentheses {

    /**
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：n = 3
     * 输出：["((()))","(()())","(())()","()(())","()()()"]
     * <p>
     * <p>
     * 示例 2：
     * <p>
     * <p>
     * 输入：n = 1
     * 输出：["()"]
     * <p>
     * <p>
     * <p>
     * <p>
     * 提示：
     * <p>
     * <p>
     * 1 <= n <= 8
     * <p>
     * <p>
     * Related Topics 字符串 动态规划 回溯 👍 4074 👎 0
     */

    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
        List<String> result = new ArrayList();
        StringBuilder sb = new StringBuilder();

        public List<String> generateParenthesis(int n) {
            blackTracking(n, 0, 0);
            return result;
        }

        public void blackTracking(int n, int left, int right) {
            if (left == right && left == n) {
                result.add(sb.toString());
                return;
            }

            if (left < n) {
                sb.append("(");
                blackTracking(n, left + 1, right);
                sb.deleteCharAt(sb.length() - 1);
            }
            if (right < left) {
                sb.append(")");
                blackTracking(n, left, right + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }


    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.generateParenthesis(3));
    }

//leetcode submit region end(Prohibit modification and deletion)

}
