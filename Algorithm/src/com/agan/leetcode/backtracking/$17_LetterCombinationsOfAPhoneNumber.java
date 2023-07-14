package com.agan.leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 */
public class $17_LetterCombinationsOfAPhoneNumber {

    List<String> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return result;
        }
        backtracking(digits, 0);
        return result;
    }

    int count1 = 0;
    public void backtracking(String digits, int startIndex) {
        count1++;
        if (startIndex == digits.length()) {
            result.add(sb.toString());
            return;
        }
        //这里虽然有两个需要递归的。2-9，数字对应的字符串。但是这里可以直接获取当前数组的字符串，根据startIndex去向后寻找下一个字符。所以一层循环就行了
        String str = numString[digits.charAt(startIndex) - '0'];   // 将index指向的数字转为int，取数字对应的字符集
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            backtracking(digits, startIndex + 1); //递归，注意index+1，一下层要处理下一个数字了
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public static void main(String[] args) {
        $17_LetterCombinationsOfAPhoneNumber s = new $17_LetterCombinationsOfAPhoneNumber();
        System.out.println(s.letterCombinations("23"));
        System.out.println(s.count1);
    }
}
