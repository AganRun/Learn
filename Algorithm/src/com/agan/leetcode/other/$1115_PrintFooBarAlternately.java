package com.agan.leetcode.other;

/**
 * 给你一个类：
 *
 * class FooBar {
 *   public void foo() {
 *     for (int i = 0; i < n; i++) {
 *       print("foo");
 *     }
 *   }
 *
 *   public void bar() {
 *     for (int i = 0; i < n; i++) {
 *       print("bar");
 *     }
 *   }
 * }
 *
 * 两个不同的线程将会共用一个 FooBar 实例：
 *
 * 线程 A 将会调用 foo() 方法，而
 * 线程 B 将会调用 bar() 方法
 * 请设计修改程序，以确保 "foobar" 被输出 n 次。
 *
 */
public class $1115_PrintFooBarAlternately {

    static class FooBar {
        private int n;

        public Object lock = new Object();
        public volatile Integer status = 0;

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                synchronized (lock) {
                    while (status % 2 != 0) {
                        lock.wait();
                    }
                    status++;
                    // printFoo.run() outputs "foo". Do not change or remove this line.
                    printFoo.run();
                    lock.notifyAll();
                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                synchronized (lock) {
                    while (status % 2 == 0) {
                        lock.wait();
                    }
                    status++;
                    // printBar.run() outputs "bar". Do not change or remove this line.
                    printBar.run();
                    lock.notifyAll();
                }
            }
        }
    }
    public static void main(String[] args) {

    }
}
