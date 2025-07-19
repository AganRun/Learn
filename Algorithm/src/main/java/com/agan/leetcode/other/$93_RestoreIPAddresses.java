package com.agan.leetcode.other;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 示例 2：
 *
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class $93_RestoreIPAddresses {

    //暴力破解
    public static List<String> solution(String source) {
        Set<String> ipNum = new HashSet<>();
        for (int i = 0; i <= 255; i++) {
            ipNum.add(String.valueOf(i));
        }
        if (source.length() < 4) {
            return new ArrayList<>();
        }
        int n = source.length();
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n-3; i++) {
            String s1 = source.substring(0, i);
            if (!ipNum.contains(s1)) {
                break;
            }
            for (int j = i+1; j <= n-2; j++) {
                String s2 = source.substring(i, j);
                if (!ipNum.contains(s2)) {
                    break;
                }
                for (int k = j+1; k <= n-1; k++) {
                    String s3 = source.substring(j, k);
                    if (!ipNum.contains(s3)) {
                        break;
                    }
                    String s4 = source.substring(k, n);
                    if (ipNum.contains(s4)) {
                        result.add(source.substring(0, i) + '.' + source.substring(i, j) + "." + source.substring(j, k) + "." + source.substring(k, n));
                    }
                }
            }
        }
        return result;
    }

    //带剪枝
    public static List<String> solution2(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) {
            return result;
        }
        fun(result, "", s,4);
        return result;
    }

    public static void fun(List<String> result, String pre, String left, int num) {
        if (num == 0) {
            if (left.equals("")) {
                result.add(pre);
            }
            return;
        }

        if (left.length() >= 1) {
            String tmp = pre.equals("") ? pre + left.substring(0,1) : pre + "." + left.substring(0,1);
            fun(result, tmp, left.substring(1), num - 1);
        }

        if (left.length() >= 2 && left.charAt(0) != '0') {
            String tmp = pre.equals("") ? left.substring(0,2) : pre + "." + left.substring(0,2);
            fun(result, tmp, left.substring(2), num - 1);
        }

        if (left.length() >= 3 && !left.substring(0,2).equals("00") && left.charAt(0) != '0' && Integer.parseInt(left.substring(0,3)) <= 255) {
            String tmp = pre.equals("") ? left.substring(0,3) : pre + "." + left.substring(0,3);
            fun(result, tmp, left.substring(3), num - 1);
        }
    }


    public static void main(String[] args) {
//        System.out.println($93_RestoreIPAddresses.solution("25525511135"));
        System.out.println($93_RestoreIPAddresses.solution2("101023"));

    }
}
