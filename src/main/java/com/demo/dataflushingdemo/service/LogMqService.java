package com.demo.dataflushingdemo.service;

import com.demo.dataflushingdemo.common.constant.KafkaTopic;
import com.demo.dataflushingdemo.common.mq.LogMqProducer;
import com.demo.dataflushingdemo.utils.LogGenerator;
import org.springframework.stereotype.Service;

/**
 * @author: ruitao.wei
 * @description: TODO
 * @date: 2022/10/31 16:26
 */
@Service
public class LogMqService {

    public boolean produceRandomLogs(Integer num) {
        if (null == num || num <= 0) {
            return false;
        }
        LogMqProducer logMqProducer = new LogMqProducer();
        for (int i = 0; i < num; i++) {
            logMqProducer.produce(
                    KafkaTopic.TEST_TOPIC_1,
                    LogGenerator.getRandomLog()
            );
        }
        return true;
    }

}
