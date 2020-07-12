package com.agan.task.thread;

import com.agan.pojo.Message;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 业务线程，对kafka的数据进行处理
 */
@Slf4j
public class BusinessThread implements Runnable{

    private LinkedBlockingQueue<String> cacheQueue;

    public BusinessThread(LinkedBlockingQueue cacheQueue) {
        this.cacheQueue = cacheQueue;
    }

    @Override
    public void run() {
        List<String> list = new ArrayList<>();
        while (true) {
            try {
                String str = cacheQueue.poll(2, TimeUnit.SECONDS);
                if (str != null) {
                    list.add(str);
                }

                if (list.size() == 100) {
                    Long startTime = System.currentTimeMillis();
                    for (String ele : list) {
                        Message message = JSON.parseObject(ele, Message.class);
//                        Thread.sleep(10);
                        log.info("处理数据" + message);
                    }
                    log.info("处理个数:{},时间{}", list.size(), System.currentTimeMillis() - startTime);
                    list.clear();
                }
            } catch (InterruptedException e) {
                log.error("获取信息失败", e);
            }

        }
    }
}
