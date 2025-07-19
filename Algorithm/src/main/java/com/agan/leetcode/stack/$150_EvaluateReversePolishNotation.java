package com.agan.leetcode.stack;

import java.util.Stack;

/**
 * 给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式。
 *
 * 请你计算该表达式。返回一个表示表达式值的整数。
 *
 * 注意：
 *
 * 有效的算符为 '+'、'-'、'*' 和 '/' 。
 * 每个操作数（运算对象）都可以是一个整数或者另一个表达式。
 * 两个整数之间的除法总是 向零截断 。
 * 表达式中不含除零运算。
 * 输入是一个根据逆波兰表示法表示的算术表达式。
 * 答案及所有中间计算结果可以用 32 位 整数表示。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/evaluate-reverse-polish-notation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 输入：tokens = ["2","1","+","3","*"]
 * 输出：9
 * 解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 */
public class $150_EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+")) {
                stack.push((stack.pop() + stack.pop()));
            } else if (token.equals("-")) {
                Integer one = stack.pop();
                Integer two = stack.pop();
                stack.push((two - one));
            } else if (token.equals("*")) {
                stack.push((stack.pop() * stack.pop()));
            } else if (token.equals("/")) {
                Integer one = stack.pop();
                Integer two = stack.pop();
                stack.push((two / one));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        $150_EvaluateReversePolishNotation e = new $150_EvaluateReversePolishNotation();
        System.out.println(e.evalRPN(new String[]{"4","13","5","/","+"}));
        // 4+(13/5)
    }
}
