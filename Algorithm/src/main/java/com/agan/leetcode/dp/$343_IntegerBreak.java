package com.agan.leetcode.dp;

import java.util.Arrays;

/**
 * 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
 *
 * 返回 你可以获得的最大乘积 。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: n = 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 *
 * 输入: n = 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/integer-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class $343_IntegerBreak {

    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            System.out.println("======i=" + i + "====");
            for (int j = 1; j < i; j++) {
                System.out.println(">>>>> j=" + j + ">>>>>");
                int a = j * (i - j);
                int b = j * dp[i - j];
                System.out.println("j * (i - j) = " + j + " * (" + i + "-" + j + ") = " + j + " * " + (i-j) + " = " + a);
                System.out.println("j * dp[i - j] = " + j + " * dp[" + (i-j) + "] = " + j + " * " + dp[i-j] + " = " + b);
                dp[i] = Math.max(dp[i], Math.max(a, b));
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[n];
    }

    public static void main(String[] args) {
        $343_IntegerBreak b = new $343_IntegerBreak();
        System.out.println(b.integerBreak(10));
    }
}
