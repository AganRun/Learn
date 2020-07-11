package com.agan.task.thread;

import com.agan.common.Constants;
import com.agan.pojo.Message;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class ProducerThread implements Runnable{

    private KafkaTemplate kafkaTemplate;

    public static final int SLEEP_TIME = 1;

    public ProducerThread(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void run() {
        boolean flag = true;
        while (flag) {
            Message message = new Message();
            message.setId(UUID.randomUUID().toString()).setName(Thread.currentThread().getName()).setSendTime(LocalDateTime.now());
            kafkaTemplate.send(Constants.TOPIC, JSON.toJSONString(message));
            try {
                TimeUnit.SECONDS.sleep(SLEEP_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
