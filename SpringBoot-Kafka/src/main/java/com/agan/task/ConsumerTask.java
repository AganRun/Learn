package com.agan.task;

import com.agan.common.Constants;
import com.agan.config.KafkaConsumerConfig;
import com.agan.task.thread.TaskRunner;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Collections;

@Component
@Slf4j
public class ConsumerTask implements CommandLineRunner {

    @Autowired
    KafkaConsumerConfig kafkaConsumerConfig;

    @Autowired
    TaskRunner taskRunner;
    @Override
    public void run(String... args) throws Exception {
        startConsumer();
    }

    public void startConsumer() {
        new Thread( () -> {
            KafkaConsumer<String, String> consumer = kafkaConsumerConfig.getConsumer();
            consumer.subscribe(Collections.singleton(Constants.TOPIC));
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(2000);
                log.info("一次拉去数据大小为" + records.count());
                for (ConsumerRecord<String, String> record : records) {
                    try {
                        taskRunner.putEle(record.value());
                    } catch (InterruptedException e) {
                        log.error("该条告警入库失败{}", record.value());
                    }
                }
            }
        }).start();
    }
}
