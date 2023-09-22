package com.agan.concurrent;

public class AlternatePrintAB {

    public static volatile boolean flag = true;
    public static int count = 0;
    public static void main(String[] args) {
        new Thread(() -> {
            while (true) {
                if (flag) {
                    if (count <= 100) {
                        System.out.println("A");
                        count++;
                        flag = false;
                    } else {
                        return;
                    }
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                if (!flag) {
                    if (count <= 100) {
                        System.out.println("B");
                        count++;
                        flag = true;
                    } else {
                        return;
                    }
                }
            }
        }).start();
    }
}
