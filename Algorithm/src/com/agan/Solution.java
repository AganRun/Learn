package com.agan;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param s string字符串
     * @return int整型ArrayList
     */
    public static ArrayList<Integer> extraNum(String s) {
        ArrayList<Integer> res = new ArrayList<>();
        int item = 0;
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            int itemChar = s.charAt(i);
            if (itemChar >= '0' && itemChar <= '9') {
                item = item * 10 + (itemChar - (int) '0');
                flag = true;
                continue;
            }

            if (item > 0 || (item == 0 && flag)) {
                res.add(item);
                flag = false;
                item = 0;
            }
        }
        if (item > 0 || (item == 0 && flag)) {
            res.add(item);
        }
        return res;
    }

    /**
     * cm任意插入
     * 1 [c] 2 [m] 3
     * @param s
     * @return
     */
    public static boolean magicString(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Deque<Character> stack = new LinkedList();
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            if (sChar == 'c') {
                stack.addLast(sChar);
            } else if (sChar == 'm') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.removeLast();
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
//        System.out.println(extraNum("0kur1su alan0233"));
        System.out.println(magicString("ccm"));
    }
}