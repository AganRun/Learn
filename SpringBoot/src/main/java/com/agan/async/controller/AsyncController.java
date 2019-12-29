package com.agan.async.controller;

import com.agan.async.service.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@RestController
@Slf4j
public class AsyncController {

    @Autowired
    private AsyncService asyncService;

    @GetMapping("async")
    public Object doAsync() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        log.info("方法开始执行---{}", startTime);

        asyncService.syncEvent();
        long syncTime = System.currentTimeMillis();
        log.info("同步方法执行用时--{}", syncTime - startTime);

        asyncService.asyncEvent();
        long asyncTime = System.currentTimeMillis();
        log.info("异步方法执行用时--{}", asyncTime - syncTime);

        log.info("方法执行结束--{}", System.currentTimeMillis());
        return "success";
    }

    @GetMapping("asyncInOne")
    public Object doAsyncInOne() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        log.info("方法开始执行---{}", startTime);

        asyncService.syncEvent();
        long syncTime = System.currentTimeMillis();
        log.info("同步方法执行用时--{}", syncTime - startTime);

        asyncEventInOne();
        long asyncTime = System.currentTimeMillis();
        log.info("异步方法执行用时--{}", asyncTime - syncTime);

        log.info("方法执行结束--{}", System.currentTimeMillis());
        return "success";
    }

    @GetMapping("asyncWithReturn")
    public Object doAsyncWithReturn() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        log.info("方法开始执行---{}", startTime);

        asyncService.syncEvent();
        long syncTime = System.currentTimeMillis();
        log.info("同步方法执行用时--{}", syncTime - startTime);

        Future<String> stringFuture = asyncService.asyncEventWithReturn();
        while (true) {
            if (stringFuture.isDone()) {
                break;
            }
        }
//        try {
//            stringFuture.get(100, TimeUnit.MILLISECONDS);
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (TimeoutException e) {
//            log.error("超时");
//            e.printStackTrace();
//        }
        long asyncTime = System.currentTimeMillis();
        log.info("异步方法执行用时--{}", asyncTime - syncTime);

        log.info("方法执行结束--{}", System.currentTimeMillis());
        return "success";
    }

    @Async
    public void asyncEventInOne() throws InterruptedException{
        Thread.sleep(1000);
        log.info("async-controller--{}", System.currentTimeMillis());

    }

}
