package com.demo.dataflushingdemo.consumer;

import com.demo.dataflushingdemo.common.constant.KafkaTopic;
import com.demo.dataflushingdemo.common.constant.MillisConstant;
import com.demo.dataflushingdemo.common.mq.LogMqConsumer;
import com.demo.dataflushingdemo.utils.LogGenerator;
import com.demo.dataflushingdemo.utils.LogWriteFileUtils;
import org.apache.juli.logging.Log;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Collections;
import java.util.concurrent.*;

/**
 * @author: ruitao.wei
 * @description: TODO
 * @date: 2022/10/31 15:46
 */
@Component
public class LogFlowFlushingConsumer {

    @PostConstruct
    public void init() {
        // 消费线程
        startConsumer();
    }

    private void startConsumer() {
        Executors.newFixedThreadPool(1).execute(()->{
            LogMqConsumer logMqConsumer = new LogMqConsumer("df-log");
            logMqConsumer.consume(Collections.singletonList(KafkaTopic.TEST_TOPIC_1));
            try (LogWriteFileUtils logWriteFileUtils = new LogWriteFileUtils()){
                System.out.println(LogGenerator.infoLog("日志消费者开始执行"));
                while (true) {
                    ConsumerRecords<String, String> records = logMqConsumer.poll(Duration.ofMillis(MillisConstant.ONE_SECOND));
                    if (records.isEmpty()) {
                        continue;
                    }
                    for (ConsumerRecord<String, String> record : records) {
                        logWriteFileUtils.write(record.value());
                        System.out.println(LogGenerator.infoLog("消费: " + record.value()));
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println(LogGenerator.errorLog("日志消费者异常退出"));
                throw new RuntimeException(e);
            }
        });
    }
}
