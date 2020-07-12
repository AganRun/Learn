package com.agan.task;

import java.util.concurrent.LinkedBlockingQueue;

public class TaskShare {

    private LinkedBlockingQueue cacheQueue;

    public TaskShare() {
        this.cacheQueue = new LinkedBlockingQueue(1000);
    }

    public LinkedBlockingQueue getCacheQueue() {
        return cacheQueue;
    }
}
