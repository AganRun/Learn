package com.agan.thread;

import java.io.IOException;

public class ThreadSleep {

    private int i = 10;
    private final Object object = new Object();

    public static void main(String[] args) throws IOException {
        ThreadSleep test = new ThreadSleep();
        MyThread thread1 = test.new MyThread();
        MyThread thread2 = test.new MyThread();
        thread1.start();
        thread2.start();
    }

    class MyThread extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                i++;
                System.out.println("i:" + i);
                try {
                    System.out.println("Thread" + Thread.currentThread().getName() + " into sleep");
                    sleep(2000);
                } catch (InterruptedException e) {
                    // TODO: handle exception
                }
                System.out.println("Thread" + Thread.currentThread().getName() + " sleep end");
                i++;
                System.out.println("i:" + i);
            }
        }
    }
}
