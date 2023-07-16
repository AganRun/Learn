package com.agan.leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 */
public class $93_Restore_IP_Addresses {

    List<String> result = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();
    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        // 如果长度不够，不搜索
        if (len < 4 || len > 12) {
            return result;
        }
        backtracking(s, 0);
        return result;
    }

    public void backtracking(String s, int index) {
        if (index >= s.length()) {
            if (path.size() == 4) {
                result.add(String.join(".", path));
            }
            return;
        }
        //剪枝  1.剩的不够了， 2，剩的太多了
        if (s.length() - index < (4-path.size()) || s.length() - index > 3 *(4-path.size())) {
            return;
        }
        //i从index向后最多移动三位就行，再多了也没有意义
        for (int i = index; i < Math.min(s.length(),index + 3); i++) {
            if (isIp(s, index, i)) {
                path.add(s.substring(index, i+1));
            } else {
                continue;
            }
            backtracking(s, i + 1);
            path.removeLast();
        }
    }

    public boolean isIp(String s, int start, int end) {
        String substring = s.substring(start, end + 1);
        if ((substring.length() > 1 && substring.startsWith("0")) || substring.length() > 3) {
            return false;
        }
        int ip = Integer.parseInt(substring);
        if (ip >= 0 && ip <= 255) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        $93_Restore_IP_Addresses ip = new $93_Restore_IP_Addresses();
        System.out.println(ip.restoreIpAddresses("25525511135"));
    }
}
