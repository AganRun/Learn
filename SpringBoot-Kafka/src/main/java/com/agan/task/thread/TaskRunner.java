package com.agan.task.thread;

import com.agan.task.TaskShare;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class TaskRunner implements CommandLineRunner {

    private static Integer TASK_SUM = 3;

    private TaskShare[] cacheQueues = new TaskShare[TASK_SUM];
    private Thread[] tasks = new Thread[TASK_SUM];
    private int count = 0;

    public void putEle(String str) throws InterruptedException {
        switch (count) {
            case 0:
                cacheQueues[0].getCacheQueue().put(str);
                count++;
                break;
            case 1:
                cacheQueues[1].getCacheQueue().put(str);
                count++;
                break;
            case 2:
                cacheQueues[2].getCacheQueue().put(str);
                count = 0;
                break;
        }
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < TASK_SUM; i++) {
            cacheQueues[i] = new TaskShare();
            tasks[i] = new Thread(new BusinessThread(cacheQueues[i].getCacheQueue()), "处理线程-" + i);
            tasks[i].start();
        }
    }
}
