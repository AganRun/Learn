package com.agan.async.service.impl;

import com.agan.async.service.AsyncService;
import com.fasterxml.jackson.core.JsonParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;


@Service
@Slf4j
public class AsyncServiceImpl implements AsyncService {

    @Override
    @Async("asyncPoolTaskExecutor")
//    @Async
    public void asyncEvent() throws InterruptedException{
        Thread.sleep(1000);
        log.info("async---{}", System.currentTimeMillis());
        log.info("async---线程名称{}", Thread.currentThread().getName());
    }

    @Async
    public Future<String> asyncEventWithReturn() throws InterruptedException{
        Thread.sleep(1000);
        log.info("async---{}", System.currentTimeMillis());
        log.info("async---线程名称{}", Thread.currentThread().getName());
        return new AsyncResult<>("异步方法返回");
    }

    @Override
    public void syncEvent() throws InterruptedException{
        Thread.sleep(1000);
        log.info("sync---{}", System.currentTimeMillis());
    }
}
