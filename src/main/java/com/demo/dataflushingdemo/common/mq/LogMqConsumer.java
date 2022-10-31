package com.demo.dataflushingdemo.common.mq;

import com.demo.dataflushingdemo.common.constant.KafkaProperties;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.List;

/**
 * @author: ruitao.wei
 * @description: TODO
 * @date: 2022/10/29 14:38
 */
public class LogMqConsumer {

    private KafkaConsumer<String, String> consumer;

    public LogMqConsumer(String groupId) {
        this.consumer = new KafkaConsumer<>(KafkaProperties.getConsumerProperties(groupId));
    }

    public void consume(List<String> topic) {
        this.consumer.subscribe(topic);
    }

    public ConsumerRecords<String, String> poll(Duration timout) {
        return this.consumer.poll(timout);
    }

    public void close() {
        this.consumer.close();
    }

}
