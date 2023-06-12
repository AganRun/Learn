package com.agan.leetcode.doublePointer.string;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 */
public class jianzhi05_replaceSpace {

    public String replaceSpace(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                result.append("%20");
            } else {
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }
}
