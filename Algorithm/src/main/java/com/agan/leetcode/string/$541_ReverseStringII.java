package com.agan.leetcode.string;

/**
 * 541. 反转字符串 II
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 *
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *
 *
 * 示例 1：
 *
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 * 示例 2：
 *
 * 输入：s = "abcd", k = 2
 * 输出："bacd"
 */
public class $541_ReverseStringII {

    public String reverseStr(String s, int k) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i = i+2*k) {
            if (i + k < s.length()) {
                result.append(reverseString(s.substring(i,i+k).toCharArray()));
                result.append(s, i+k, Math.min(i+2*k,s.length()));
            } else {
                //剩下的不到K了
                result.append(reverseString(s.substring(i).toCharArray()));
            }
        }
        return result.toString();
    }

    public char[] reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;
        while (l <= r) {
            char tmp = s[l];
            s[l] = s[r];
            s[r] = tmp;
            l++;
            r--;
        }
        return s;
    }

    /**
     * 更优秀的人写的
     * 作者：AC_OIer
     *     链接：https://leetcode.cn/problems/reverse-string-ii/solution/gong-shui-san-xie-jian-dan-zi-fu-chuan-m-p88f/
     *     来源：力扣（LeetCode）
     *     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param args
     */
    public String reverseStr2(String s, int k) {
        char[] cs = s.toCharArray();
        int n = s.length();
        for (int l = 0; l < n; l = l + 2 * k) {
            int r = l + k - 1;
            reverse(cs, l, Math.min(r, n - 1));
        }
        return String.valueOf(cs);
    }
    void reverse(char[] cs, int l, int r) {
        while (l < r) {
            char c = cs[l];
            cs[l] = cs[r];
            cs[r] = c;
            l++; r--;
        }
    }


    public static void main(String[] args) {
        $541_ReverseStringII r = new $541_ReverseStringII();
        System.out.println(r.reverseStr("abcdefg", 2));
    }
}
