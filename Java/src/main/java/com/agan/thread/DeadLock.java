package com.agan.thread;

import lombok.SneakyThrows;

public class DeadLock {

    public static Object o1 = new Object();  //一定要实例化，不然锁导致NPE
    public static Object o2 = new Object();

    public static void main(String[] args) {
        Runnable r1 = new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                synchronized (o1) {
                    System.out.println("get o1");
                    Thread.sleep(100);
                    synchronized (o2) {
                        System.out.println("get o2");
                    }
                }
            }
        };
        Runnable r2 = new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                synchronized (o2) {
                    System.out.println("get o2");
                    Thread.sleep(100);
                    synchronized (o1) {
                        System.out.println("get o1");
                    }
                }
            }
        };

        //主程序运行
        new Thread(r1).start();
        new Thread(r2).start();

        System.out.println("end");
    }

}
