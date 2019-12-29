package com.agan.async.service;

import java.util.concurrent.Future;

public interface AsyncService {

    void asyncEvent() throws InterruptedException;

    Future<String> asyncEventWithReturn() throws InterruptedException;

    void syncEvent() throws InterruptedException;
}
