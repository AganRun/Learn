package com.agan.leetcode.stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 225. 用队列实现栈
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 *
 * 实现 MyStack 类：
 *
 * void push(int x) 将元素 x 压入栈顶。
 * int pop() 移除并返回栈顶元素。
 * int top() 返回栈顶元素。
 * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 *
 *
 * 注意：
 *
 * 你只能使用队列的基本操作 —— 也就是 push to back、peek/pop from front、size 和 is empty 这些操作。
 * 你所使用的语言也许不支持队列。 你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 */
public class $225_ImplementStackUsingQueues {
    /**
     * 其实这里可以使用一个队列来实现的。将元素取出来重新入队列
     */
    public static class MyStack {
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> queueBack = new LinkedList<>();

        public MyStack() {
        }

        public void push(int x) {
            queue.add(x);
        }

        public int pop() {
            while (queue.size() != 1) {
                queueBack.add(queue.poll());
            }
            int result = queue.poll();
            queue = new LinkedList<>(queueBack);
            queueBack.clear();
            return result;
        }

        public int top() {
            int x = -1;
            while (queue.size() != 0) {
                x = queue.poll();
                queueBack.add(x);
            }
            queue = new LinkedList<>(queueBack);
            queueBack.clear();
            return x;
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        System.out.println(myStack.pop());
        System.out.println(myStack.top());
    }
}
