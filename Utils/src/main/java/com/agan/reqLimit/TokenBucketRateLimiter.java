package com.agan.reqLimit;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * 令牌桶限流算法
 */
@Slf4j
public class TokenBucketRateLimiter {

    private LinkedBlockingDeque<String> tokenBlockingDeque;

    public TokenBucketRateLimiter(int permitsPerSecond) {
        // 创建令牌桶 设定固定的容量
        tokenBlockingDeque = new LinkedBlockingDeque<String>(permitsPerSecond);
        // 初始化
        init(permitsPerSecond);
        start();
    }

    public static TokenBucketRateLimiter create(int permitsPerSecond) {
        return new TokenBucketRateLimiter(permitsPerSecond);
    }

    public void init(int permitsPerSecond) {
        for (int i = 0; i < permitsPerSecond; i++) {
            tokenBlockingDeque.offer("#");
        }
    }
    /**
     * 从队列中获取token
     *
     * @return
     */
    public boolean tryAcquire() {
        return tokenBlockingDeque.poll() == null ? false : true;
    }

    /**
     * 单独开启一个向令牌桶投递 token
     */
    private void start() {
        /**
         * 每隔1s时间  向队列中投递固定容量大小的token
         */
        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                addToken();
            }
        }, 1, 1, TimeUnit.SECONDS);

    }

    public void addToken() {
        /**
         * 向队列投递token
         */
        tokenBlockingDeque.offer("#");

    }

    public static void main(String[] args) {
        TokenBucketRateLimiter mayiktRateLimiter = TokenBucketRateLimiter.create(1);
        for (int i = 0; i < 5; i++) {
            log.info("result " + mayiktRateLimiter.tryAcquire());
            try {
                Thread.sleep(500);
            } catch (Exception e) {

            }
        }
    }
}
