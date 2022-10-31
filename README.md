# Kafka数据清洗Demo

## Log flow data flushing
- 阶段一| 2022-10-31
  - Springboot接口触发生成日志，producer发送Kafka
  - 消费者自启动while true消费topic，记录/data/temp_log.log
  - test

- 阶段二| 
  - Flink清洗日志：
    - 三类日志区分
    - 异常日志报警