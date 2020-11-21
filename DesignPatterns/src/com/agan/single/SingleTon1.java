package com.agan.single;

public class SingleTon1 {

    private static SingleTon1 instance;

    private SingleTon1() {}

    public static SingleTon1 getInstance() {
        if (instance == null) {
            instance = new SingleTon1();
            return instance;
        }
        return instance;
    }
}
