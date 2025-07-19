package com.agan.leetcode.hash;

/**
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 *
 * 如果可以，返回 true ；否则返回 false 。
 *
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：ransomNote = "a", magazine = "b"
 * 输出：false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/ransom-note
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class $383_RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[126];
        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i)] += 1;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (arr[ransomNote.charAt(i)] > 0) {
                arr[ransomNote.charAt(i)] --;
            } else {
                return false;
            }
        }
        return true;
    }

}
