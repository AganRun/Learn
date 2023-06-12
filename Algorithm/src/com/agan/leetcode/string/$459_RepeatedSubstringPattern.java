package com.agan.leetcode.string;

/**
 * 459. 重复的子字符串
 * 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "abab"
 * 输出: true
 * 解释: 可由子串 "ab" 重复两次构成。
 * 示例 2:
 *
 * 输入: s = "aba"
 * 输出: false
 * 示例 3:
 *
 * 输入: s = "abcabcabcabc"
 * 输出: true
 * 解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)
 */
public class $459_RepeatedSubstringPattern {

    public boolean repeatedSubstringPattern(String s) {
        int[] next = new int[s.length()];
        int j = 0;
        next[j] = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        if (next[s.length() - 1] > 0 && s.length() % (s.length() - next[s.length() - 1]) == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        $459_RepeatedSubstringPattern s = new $459_RepeatedSubstringPattern();
        System.out.println(s.repeatedSubstringPattern("ababab"));
    }
}
