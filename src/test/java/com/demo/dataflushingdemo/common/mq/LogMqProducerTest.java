package com.demo.dataflushingdemo.common.mq;

import com.demo.dataflushingdemo.common.constant.KafkaTopic;
import com.demo.dataflushingdemo.utils.LogGenerator;
import org.junit.jupiter.api.Test;

class LogMqProducerTest {

    @Test
    void testLoggerProducer() {
        String        topic         = KafkaTopic.TEST_TOPIC_1;
        LogMqProducer logMqProducer = MqFactory.getLogMqProducer();
        try {
            for (int i = 0; i < 10; i++) {
                String randomLog = LogGenerator.getRandomLog();
                logMqProducer.produce(topic, randomLog);
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            logMqProducer.close();
        }
    }

}