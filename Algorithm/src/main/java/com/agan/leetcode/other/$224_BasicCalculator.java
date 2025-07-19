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
public class $224_BasicCalculator {

    public int solution(String s) {
        return Integer.parseInt(dealWithBrackets(s.replace(" ", "")));
    }

    public String dealWithBrackets(String s) {
        //1. 先处理括号
        if (s.contains("(")) {
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.push(i);
                } else if (s.charAt(i) == ')') {
                    Integer start = stack.pop();
                    String n = s.substring(0, start) + basicCalc(s.substring(start + 1, i)) + s.substring(i+1);
                    return dealWithBrackets(n.replace("+-", "-").replace("--", "+")); //计算完可能出现1+(1-2)=1+-1
                }
            }
        }
        return String.valueOf(basicCalc(s));
    }

    /**
     * 无括号计算器
     * @param s
     * @return
     */
    public int basicCalc(String s) {
        int i = 0, result = 0; int flag = 1;
        if (s.charAt(i) == '-') {
            i++;
            flag = -1;
        }
        NextInt nextInt = getNextInt(s.substring(i));
        result = flag * nextInt.next;
        i += nextInt.step;
        while (i < s.length()) {
            if (s.charAt(i) == '+') {
                nextInt = getNextInt(s.substring(i+1));
                result += nextInt.next;
                i += nextInt.step;
            } else if (s.charAt(i) == '-') {
                nextInt = getNextInt(s.substring(i+1));
                result -= nextInt.next;
                i += nextInt.step;
            }
            i++;
        }
        return result;
    }

    /**
     * 获取下一个数字 及 步长
     * @param s
     * @return
     */
    public NextInt getNextInt(String s) {
        int i = 0;
        int flag = 1;
        if (s.charAt(i) == '-') {
            flag = -1;
            i++;
        }
        int result = flag * Integer.parseInt(String.valueOf(s.charAt(i++)));
        while (i < s.length()) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                return new NextInt(result, i);
            } else {
                result = result * 10 + Integer.parseInt(String.valueOf(s.charAt(i++)));
            }
        }
        return new NextInt(result, i);
    }

    class NextInt {
        int next;
        int step;

        public NextInt(int next, int step) {
            this.next = next;
            this.step = step;
        }

        @Override
        public String toString() {
            return "NextInt{" +
                    "next=" + next +
                    ", step=" + step +
                    '}';
        }
    }


    /**
     * 推荐双栈解法，一个存数字，一个存操作符。兼容+-/
     * https://leetcode-cn.com/problems/basic-calculator/solution/shuang-zhan-jie-jue-tong-yong-biao-da-sh-olym/
     * */
    Map<Character, Integer> map = new HashMap(){{
        put('-', 1);
        put('+', 1);
        put('*', 2);
        put('/', 2);
        put('%', 2);
        put('^', 3);
    }};
    public int calculate(String s) {
        s = s.replaceAll(" ", "");
        char[] cs = s.toCharArray();
        int n = s.length();
        Deque<Integer> nums = new ArrayDeque<>();
        nums.addLast(0);
        Deque<Character> ops = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            char c = cs[i];
            if (c == '(') {
                ops.addLast(c);
            } else if (c == ')') {
                while (!ops.isEmpty()) {
                    if (ops.peekLast() != '(') {
                        calc(nums, ops);
                    } else {
                        ops.pollLast();
                        break;
                    }
                }
            } else {
                if (isNumber(c)) {
                    int u = 0;
                    int j = i;
                    while (j < n && isNumber(cs[j])) u = u * 10 + (cs[j++] - '0');
                    nums.addLast(u);
                    i = j - 1;
                } else {
                    if (i > 0 && (cs[i - 1] == '(' || cs[i - 1] == '+' || cs[i - 1] == '-')) {
                        nums.addLast(0);
                    }
                    while (!ops.isEmpty() && ops.peekLast() != '(') {
                        char prev = ops.peekLast();
                        if (map.get(prev) >= map.get(c)) {
                            calc(nums, ops);
                        } else {
                            break;
                        }
                    }
                    ops.addLast(c);
                }
            }
        }
        while (!ops.isEmpty() && ops.peekLast() != '(') calc(nums, ops);
        return nums.peekLast();
    }
    void calc(Deque<Integer> nums, Deque<Character> ops) {
        if (nums.isEmpty() || nums.size() < 2) return;
        if (ops.isEmpty()) return;
        int b = nums.pollLast(), a = nums.pollLast();
        char op = ops.pollLast();
        int ans = 0;
        if (op == '+') {
            ans = a + b;
        } else if (op == '-') {
            ans = a - b;
        } else if (op == '*') {
            ans = a * b;
        } else if (op == '/') {
            ans = a / b;
        } else if (op == '^') {
            ans = (int)Math.pow(a, b);
        } else if (op == '%') {
            ans = a % b;
        }
        nums.addLast(ans);
    }
    boolean isNumber(char c) {
        return Character.isDigit(c);
    }

    public static void main(String[] args) {
//        $224_BasicCalculator.solution("(1+(4+5+2)-3)+(6+8)");
//        System.out.println($224_BasicCalculator.basicCalc("-1+2-3"));
        $224_BasicCalculator test = new $224_BasicCalculator();
//        System.out.println(test.getNextInt("123+2"));
//        System.out.println(test.basicCalc("-123-1+125"));
        System.out.println(test.solution("5+3-4-(1+2-7+(10-1+3+5+(3-0+(8-(3+(8-(10-(6-10-8-7+(0+0+7)-10+5-3-2+(9+0+(7+(2-(2-(9)-2+5+4+2+(2+9+1+5+5-8-9-2-9+1+0)-(5-(9)-(0-(7+9)+(10+(6-4+6))+0-2+(10+7+(8+(7-(8-(3)+(2)+(10-6+10-(2)-7-(2)+(3+(8))+(1-3-8)+6-(4+1)+(6))+6-(1)-(10+(4)+(8)+(5+(0))+(3-(6))-(9)-(4)+(2))))))-1)))+(9+6)+(0))))+3-(1))+(7))))))))"));;
    }
}
