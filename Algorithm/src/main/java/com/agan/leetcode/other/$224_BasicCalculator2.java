package com.agan.leetcode.other;

import java.util.*;

/**
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * <p>
 * 注意:不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "1 + 1"
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：s = " 2-1 + 2 "
 * 输出：3
 * 示例 3：
 * <p>
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/basic-calculator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class $224_BasicCalculator2 {

    private void fun(int a, Integer b, Integer c) {
        a++;
        b++;
        c++;
    }
    public void test() {
        int a = 1;
        Integer b= 1;
        Integer c = 1000;
        fun(a,b,c);
        System.out.println(a + "---" + b + "===" + c);
    }

    public static void main(String[] args) {
        $224_BasicCalculator2 t = new $224_BasicCalculator2();
        t.test();
    }
}
