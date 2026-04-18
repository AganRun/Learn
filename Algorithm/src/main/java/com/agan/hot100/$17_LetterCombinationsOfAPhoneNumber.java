package com.agan.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class $17_LetterCombinationsOfAPhoneNumber {

    /**
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
     * <p>
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     * <p>
     * <p>
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：digits = "23"
     * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
     * <p>
     * <p>
     * 示例 2：
     * <p>
     * <p>
     * 输入：digits = "2"
     * 输出：["a","b","c"]
     * <p>
     * <p>
     * <p>
     * <p>
     * 提示：
     * <p>
     * <p>
     * 1 <= digits.length <= 4
     * digits[i] 是范围 ['2', '9'] 的一个数字。
     * <p>
     * <p>
     * Related Topics 哈希表 字符串 回溯 👍 3234 👎 0
     */

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //设置全局列表存储最后的结果
        List<String> list = new ArrayList<>();

        public List<String> letterCombinations(String digits) {
            if (digits == null || digits.length() == 0) {
                return list;
            }
            //初始对应所有的数字，为了直接对应2-9，新增了两个无效的字符串""
            String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
            //迭代处理
            backTracking(digits, numString, 0);
            return list;

        }

        //每次迭代获取一个字符串，所以会涉及大量的字符串拼接，所以这里选择更为高效的 StringBuilder
        StringBuilder temp = new StringBuilder();

        //比如digits如果为"23",num 为0，则str表示2对应的 abc
        public void backTracking(String digits, String[] numString, int num) {
            //遍历全部一次记录一次得到的字符串
            if (num == digits.length()) {
                list.add(temp.toString());
                return;
            }
            //str 表示当前num对应的字符串
            String str = numString[digits.charAt(num) - '0'];
            for (int i = 0; i < str.length(); i++) {
                temp.append(str.charAt(i));
                //递归，处理下一层
                backTracking(digits, numString, num + 1);
                //剔除末尾的继续尝试
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        List result = new $17_LetterCombinationsOfAPhoneNumber().new Solution().letterCombinations("23");
        System.out.println(result);
    }
//leetcode submit region end(Prohibit modification and deletion)

}