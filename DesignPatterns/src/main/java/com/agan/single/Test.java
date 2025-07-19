package com.agan.single;

public class Test {

    public static void main(String[] args) {
        testSingle1();
    }

    private static void testSingle1() {
        SingleTon1 singleTon1 = SingleTon1.getInstance();
        SingleTon1 singleTon2 = SingleTon1.getInstance();
        System.out.println("是否单例:" + (singleTon1 == singleTon2));
    }
}
