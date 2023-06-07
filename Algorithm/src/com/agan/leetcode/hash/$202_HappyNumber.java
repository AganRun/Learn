package com.agan.leetcode.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * <p>
 * 「快乐数」 定义为：
 * <p>
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为 1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/happy-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 输入：n = 19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
public class $202_HappyNumber {

//    public boolean isHappy(int n) {
//        if (n == 1) {
//            return true;
//        }
//        int t = n;
//        int sum = 0;
//        while (t != 0) {
//            int x = t % 10;
//            sum += x * x;
//            t = t / 10;
//        }
//        if (sum == n) {
//            return false;
//        } else {
//            return isHappy(sum);
//        }
//    }

    public boolean isHappy(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        while (n != 1) {
            int temp = n;
            int sum = 0;
            while (temp != 0) {
                int x = temp % 10;
                sum += x * x;
                temp = temp / 10;
            }
            if (map.containsKey(sum)) {
                return false;
            } else {
                map.put(sum, sum);
            }
            n = sum;
        }
        return true;
    }

    public static void main(String[] args) {
        $202_HappyNumber happyNumber = new $202_HappyNumber();
        System.out.println(happyNumber.isHappy(19));
    }
}
