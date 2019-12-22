package com.agan.service;

import com.agan.pojo.Message;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class KafkaSender {

    protected static final String TOPIC = "myTopic";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(String name) {
        Message message = new Message();
        message.setId(UUID.randomUUID().toString()).setName(name).setSendTime(LocalDateTime.now());
        kafkaTemplate.send(TOPIC, JSON.toJSONString(message));
    }
}
