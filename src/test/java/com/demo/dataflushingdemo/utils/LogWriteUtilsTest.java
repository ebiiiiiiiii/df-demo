package com.demo.dataflushingdemo.utils;

import org.junit.jupiter.api.Test;

import java.io.IOException;

class LogWriteUtilsTest {

    @Test
    void write() {
        try (LogWriteFileUtils logWriteUtils = new LogWriteFileUtils();) {
            for (int i = 0; i < 10; i++) {
                String log = LogGenerator.getRandomLog();
                logWriteUtils.write(log);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}