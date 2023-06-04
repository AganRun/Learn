package com.agan.leetcode.array;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 *  
 *
 * 注意：
 *
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *  
 *
 * 示例 1：
 *
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class $76_MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        //很灵魂。记录需要的字符数
        int[] need = new int[128];
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }
        int count = t.length(); //记录当前需要的满足条件的字符数
        int min = Integer.MAX_VALUE;
        String result = "";
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            //只有需要才计数器减一，重复遇到就不能减少了
            if (need[currentChar] > 0) {
                count--;
            }
            need[currentChar]--;
            if (count == 0) {
                //这里很重要，满足的条件是，左侧的元素多余。当等于0就不能再减少了
                while (left < i && need[s.charAt(left)] < 0) {
                    need[s.charAt(left)]++;
                    left++;
                }
                if ((i - left + 1) < min) {
                    min = i - left + 1;
                    result = s.substring(left, i+1);
                }
                need[s.charAt(left)]++;
                left++;
                count++; //很关键，左侧已经继续移动到不满足条件了
            }
        }
        return result;
    }

    public static void main(String[] args) {
        $76_MinimumWindowSubstring m = new $76_MinimumWindowSubstring();
        System.out.println(m.minWindow("ADOBECODEBANC","ABC"));
    }
}
