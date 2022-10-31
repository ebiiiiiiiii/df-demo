package com.demo.dataflushingdemo.common.mq;

import com.demo.dataflushingdemo.common.constant.KafkaProperties;
import com.demo.dataflushingdemo.utils.LogGenerator;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * @author: ruitao.wei
 * @description: TODO
 * @date: 2022/10/29 14:38
 */
public class LogMqProducer {

    KafkaProducer<String, String> producer;

    public LogMqProducer() {
        producer = new KafkaProducer<>(KafkaProperties.getProducerProperties());;
    }

    LogMqProducer(Properties properties) {
        producer = new KafkaProducer<>(properties);
    }

    public void produce(String topic, String data) {
        produce(topic, null, null, data, null);
    }

    public void produce(String topic, String msgKey, String data) {
        produce(topic, null, msgKey, data, null);
    }

    public void produce(String topic, String msgKey, String data, Long timestamp) {
        produce(topic, null, msgKey, data, timestamp);
    }

    public void produce(String topic, Integer partition, String msgKey, String data) {
        produce(topic, partition, msgKey, data, null);
    }

    private void produce(String topic, Integer partition, String msgKey, String data, Long timestamp) {
        ProducerRecord<String, String> kafkaRecord =
                timestamp == null ?
                        new ProducerRecord<>(topic, partition, msgKey, data) :
                        new ProducerRecord<>(topic, partition, timestamp, msgKey, data);
        sendMsg(kafkaRecord);
        System.out.println(LogGenerator.infoLog("生产: " + data));
    }

    private void sendMsg(ProducerRecord<String, String> kafkaRecord) {
        producer.send(kafkaRecord, (rm, e) -> {
            if (null == e) {
                return;
            }
            System.out.println(LogGenerator.errorLog("kafka发送异常"));
        });
    }

    public void close() {
        producer.close();
    }
}
