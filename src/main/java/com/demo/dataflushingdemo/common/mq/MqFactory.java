package com.demo.dataflushingdemo.common.mq;

/**
 * @author: ruitao.wei
 * @description: TODO
 * @date: 2022/10/31 13:57
 */
public class MqFactory {

    public static LogMqConsumer getLogMqConsumer(String groupId) {
        return new LogMqConsumer(groupId);
    }

    public static LogMqProducer getLogMqProducer() {
        return new LogMqProducer();
    }

}
