package com.agan.leetcode.stack;

import java.util.Stack;

/**
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 * 示例 2：
 *
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 *
 * ()(()) 6
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class $32_LongestValidParentheses {

    //用栈解决
    public static int solution1(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        Integer max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                // 此时遇到右括号
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }

    //直接数括号
    public static int solution2(String s) {
        int left = 0, right = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else if (s.charAt(i) == ')') {
                right++;
            }
            if (left == right) {
                max = Math.max(max, 2 * left);
            }
            if (right > left) {
                left = 0;
                right = 0;
            }
        }

        left = 0; right = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else if (s.charAt(i) == ')') {
                right++;
            }
            if (left == right) {
                max = Math.max(max, 2 * left);
            }
            if (left > right) {
                left = 0;
                right = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
//        System.out.println($32_LongestValidParentheses.solution1(")()())"));
        System.out.println($32_LongestValidParentheses.solution2("()()))"));
    }
}
