package com.agan.reqLimit;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LimitDemo {

    public static void main(String[] args) throws InterruptedException {
        //计数器 1s,3个
        FixedWindow fixedWindow = new FixedWindow(1000, 3);
        for (int i = 0; i < 10; i++) {
            log.info("time: " + System.currentTimeMillis() + ",result: " + fixedWindow.tryAcquire());
            Thread.sleep(200);
        }

    }
}
