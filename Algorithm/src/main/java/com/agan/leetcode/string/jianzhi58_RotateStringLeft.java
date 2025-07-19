package com.agan.leetcode.string;

import java.util.Arrays;

/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class jianzhi58_RotateStringLeft {

    /**
     * 解法可以直接使用库函数的截取，或者使用三次旋转，这样空间复杂度是O(1)，不过对于java意义不大
     *
     * 努力难度是：不申请额外的空间，在原字符串上操作
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords(String s, int n) {
        char[] chars = s.toCharArray();
        revert(chars, 0, s.length() - 1);
        revert(chars, 0, s.length() - 1 - n);
        revert(chars, s.length() - n, s.length() - 1);
        return new String(chars);
    }

    public char[] revert(char[] arr, int start, int end) {
        while (start < end) {
            char t = arr[start];
            arr[start] = arr[end];
            arr[end] = t;
            start++; end--;
        }
        return arr;
    }
}
