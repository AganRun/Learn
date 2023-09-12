package com.agan.reqLimit;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FixedWindow {

    //时间窗口，单位毫秒
    public int windowUnit;

    //当前窗口计数
    public int count = 0;

    //阈值
    public int threshold;

    //窗口开始时间
    public long lastReqTime;

    /**
     * create a new FixedWindow limit
     * @param windowUnit
     * @param threshold
     */
    public FixedWindow(int windowUnit, int threshold) {
        this.windowUnit = windowUnit;
        this.threshold = threshold;
    }

    public boolean tryAcquire() {
        //获得系统当前时间
        long current = System.currentTimeMillis();
        if (current - lastReqTime > windowUnit) {
            lastReqTime = current;
            count = 0;
        }
        //小于阈值
        if (count < threshold) {
            count++;
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws InterruptedException {
        //计数器 1s,3个
        FixedWindow fixedWindow = new FixedWindow(1000, 3);
        for (int i = 0; i < 10; i++) {
            log.info("time: " + System.currentTimeMillis() + ",result: " + fixedWindow.tryAcquire());
            Thread.sleep(200);
        }

    }
}
