package com.agan.stack;

import java.util.Stack;

public class StackDemo {

    public static void main(String[] args) {
        testDemo();
    }

    static void testDemo() {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
