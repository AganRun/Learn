package com.agan.leetcode.hash;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 *
 * 字母异位词：例如origin, riogin
 */
public class $242_ValidAnagram {

    public boolean isAnagram(String s, String t) {
        int[] arr = new int[128];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)] += 1;
        }
        for (int i = 0; i < t.length(); i++) {
            arr[t.charAt(i)] -= 1;
        }
        for (int i = 0; i < 128; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        $242_ValidAnagram v = new $242_ValidAnagram();
        System.out.println(v.isAnagram("anagram", "nagaram"));
    }
}
