package com.agan.frequently.digital;

/**
 * 求：1+2+...+n
 * 不能用乘除法、for、while、if、else、switch、case等关键字及条件判断语句
 */
public class Sum {

    public static void main(String[] args) {
        System.out.println(solution1(5));
        System.out.println(solution2(5));
    }

    /**
     * 数学公式法
     * n(n+1)/2 = (n*2+n)>>1
     * @param n
     * @return
     */
    public static Integer solution1(Integer n) {
        n = (int)(Math.pow(n, 2) + n) >> 1;
        return n;
    }

    /**
     * 利用递归和短路求值原理
     * @param n
     * @return
     */
    public static int solution2(int n) {
        int sum = n;
        boolean flag = (sum > 0) && ((sum += solution2(n - 1)) > 0);
        return sum;
    }

}
