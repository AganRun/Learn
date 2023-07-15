package com.agan.leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 131. 分割回文串
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 *
 * 回文串 是正着读和反着读都一样的字符串。
 *
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 *
 */
public class $131_Palindrome_Partitioning {

    List<List<String>> result = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();
    public List<List<String>> partition(String s) {
        backtracking(s, 0);
        return result;
    }

    public void backtracking(String s, Integer index) {
        if (index >= s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            //判断第一部分[startIndex,i]在s中的子串是回文串，才判断后面
            String str = s.substring(index, i+1);
            if (isPalindrome(str)) {
                path.add(str);
            } else {  // 如果不是则直接跳过
                continue;
            }
            backtracking(s, i+1);  // 寻找i+1为起始位置的子串
            path.removeLast();  // 回溯过程，弹出本次已经填在的子串
        }
    }

    public boolean isPalindrome(String s) {
        int p = 0;
        int q = s.length() - 1;
        while (p <= q) {
            if (s.charAt(p++) != s.charAt(q--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        $131_Palindrome_Partitioning p = new $131_Palindrome_Partitioning();
        System.out.println(p.partition("aab"));
    }
}
