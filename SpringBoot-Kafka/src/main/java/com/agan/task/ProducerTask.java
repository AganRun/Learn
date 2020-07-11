package com.agan.task;

import com.agan.task.thread.ProducerThread;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Slf4j
public class ProducerTask implements CommandLineRunner {

//    @PostConstruct
//    public void init() {
//
//    }

    @Autowired
    KafkaTemplate kafkaTemplate;

    @Override
    public void run(String... args) throws Exception {
        startProducer();
    }

    public void startProducer() {
        ProducerThread pt = new ProducerThread(kafkaTemplate);
        Thread thread = new Thread(pt);
        Thread thread2 = new Thread(pt);
        thread.start();
        thread2.start();
    }
}
