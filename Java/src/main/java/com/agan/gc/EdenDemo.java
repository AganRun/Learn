package com.agan.gc;

public class EdenDemo {

    /**
     * java -XX:+PrintGCDetails
     * @param args
     */
    public static void main(String[] args) {
        byte[] allocation1, allocation2;
//        //可以把新生代占满
//        allocation1 = new byte[60024*1024];
//        //太大了，直接进入老年代
//        allocation1 = new byte[103568*1024];
    }
}
