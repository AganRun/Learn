package com.agan.leetcode.stack;

import java.util.Stack;

/**
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 *
 * 实现 MyQueue 类：
 *
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 * 说明：
 *
 * 你 只能 使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/implement-queue-using-stacks
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class $232_ImplementQueueUsingStacks {
    /**
     * 一个栈用来保存，一个栈用来输出
     * 比单传的临时栈要好的多
     */
    public static class MyQueue {

        Stack<Integer> stackIn = new Stack<>();
        Stack<Integer> stackOut = new Stack<>();

        public MyQueue() {

        }

        public void push(int x) {
            stackIn.push(x);
        }

        public int pop() {
            if (!stackOut.isEmpty()) {
                return stackOut.pop();
            } else if (!stackIn.isEmpty()) {
                while (!stackIn.isEmpty()) {
                    stackOut.push(stackIn.pop());
                }
                return stackOut.pop();
            } else {
                return -1;
            }
        }

        public int peek() {
            if (!stackOut.isEmpty()) {
                return stackOut.peek();
            } else if (!stackIn.isEmpty()) {
                while (!stackIn.isEmpty()) {
                    stackOut.push(stackIn.pop());
                }
                return stackOut.peek();
            } else {
                return -1;
            }
        }

        public boolean empty() {
            return stackIn.isEmpty() && stackOut.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);
        System.out.println(q.pop());
        System.out.println(q.peek());
        System.out.println(q.pop());
    }
}
