package com.agan.frequently.array;

/**
 * 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。
 *
 * 注意：如果对空文本输入退格字符，文本继续为空。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "ab#c", t = "ad#c"
 * 输出：true
 * 解释：s 和 t 都会变成 "ac"。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/backspace-string-compare
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BackspaceStringCompare$844 {

    /**
     * 双指针法。从后向前比较
     * @param s
     * @param t
     * @return
     */
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        int skipI = 0, skipJ = 0;
        while (i >= 0 || j >= 0) {
            //需要比较的i
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    skipI++;
                    i--;
                } else if (skipI > 0) {
                    skipI --;
                    i--;
                } else {
                    break;
                }
            }

            //需要比较的j
            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    skipJ++;
                    j--;
                } else if (skipJ > 0) {
                    skipJ--;
                    j--;
                } else {
                    break;
                }
            }

            if (i >= 0 && j >= 0) { //这里容易写错。意思是都还可以比较
                if (s.charAt(i) != t.charAt(j)) {
                    return false;
                }
            } else if (i >= 0 || j >= 0) {  //这里容易写错。意思是同时走完可以，有一个没有走完不行
                return false;
            }
            i--;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        BackspaceStringCompare$844 b =  new BackspaceStringCompare$844();
        System.out.println(b.backspaceCompare("ab##", "c#d#"));
    }
}
