package com.demo.dataflushingdemo.common.mq;

import com.demo.dataflushingdemo.common.constant.KafkaTopic;
import com.demo.dataflushingdemo.common.constant.MillisConstant;
import com.demo.dataflushingdemo.common.mq.LogMqConsumer;
import com.demo.dataflushingdemo.utils.LogGenerator;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.assertj.core.util.Strings;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Collections;

class LogMqConsumerTest {

    @Test
    void testLoggerConsumer() {
        String topic = KafkaTopic.TEST_TOPIC_1;
        LogMqConsumer logMqConsumer = MqFactory.getLogMqConsumer("df-test");
        //订阅topic
        logMqConsumer.consume(Collections.singletonList(topic));
        //开启消费者：1次/秒 10秒
        try {
            for (int i = 0; i < 10; i++) {
                ConsumerRecords<String, String> records = logMqConsumer.poll(Duration.ofMillis(MillisConstant.ONE_SECOND));
                System.out.println(LogGenerator.infoLog(Strings.formatIfArgs("本次消费条数：%d", records.count())));
                if (records.isEmpty()) {
                    continue;
                }
                for (ConsumerRecord<String, String> record : records) {
                    System.out.println(record.value());
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            logMqConsumer.close();
        }

    }

}