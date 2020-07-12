package com.agan.config;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class KafkaConsumerConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    public KafkaConsumer getConsumer() {
        System.out.println("---------------" + bootstrapServers);
        KafkaConsumer<String, String> consumer = null;
        Properties properties = new Properties();
        properties.put("bootstrap.servers", bootstrapServers);
        properties.put("group.id", "agan");
        properties.put("enable.auto.commit", true);//注意这里设置为手动提交方式
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("max.poll.records", "1000");
        properties.put("max.poll.interval.ms", "300000");
        consumer = new KafkaConsumer<>(properties);
        return consumer;
    }
}
