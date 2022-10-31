package com.demo.dataflushingdemo.common.constant;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;

import java.util.Properties;

/**
 * @author: ruitao.wei
 * @description: TODO
 * @date: 2022/10/29 14:45
 */
public class KafkaProperties {

    private static final String BOOTSTRAP_SERVERS_CONFIG    = "127.0.0.1:9092";
    private static final String ACKS_CONFIG                   = "all";
    private static final String KEY_SERIALIZER_CLASS_CONFIG   = "org.apache.kafka.common.serialization.StringSerializer";
    private static final String KEY_DESERIALIZER_CLASS_CONFIG = "org.apache.kafka.common.serialization.StringDeserializer";
    private static final String VALUE_SERIALIZER_CLASS_CONFIG   = "org.apache.kafka.common.serialization.StringSerializer";
    private static final String VALUE_DESERIALIZER_CLASS_CONFIG = "org.apache.kafka.common.serialization.StringDeserializer";
    private static final String BUFFER_MEMORY_CONFIG            = "33554432";
    private static final String RETRIES_CONFIG           = "3";
    private static final String AUTO_OFFSET_RESET_CONFIG = "earliest";

    public static Properties getProducerProperties() {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS_CONFIG);
        properties.put(ProducerConfig.ACKS_CONFIG, ACKS_CONFIG);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, KEY_SERIALIZER_CLASS_CONFIG);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, VALUE_SERIALIZER_CLASS_CONFIG);
        properties.put(ProducerConfig.BUFFER_MEMORY_CONFIG, BUFFER_MEMORY_CONFIG);
        properties.put(ProducerConfig.RETRIES_CONFIG, RETRIES_CONFIG);
        return properties;
    }

    public static Properties getConsumerProperties(String groupId) {
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS_CONFIG);
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, KEY_DESERIALIZER_CLASS_CONFIG);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, VALUE_DESERIALIZER_CLASS_CONFIG);
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, AUTO_OFFSET_RESET_CONFIG);
        return properties;
    }
}
