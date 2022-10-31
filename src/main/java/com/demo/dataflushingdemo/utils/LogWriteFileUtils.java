package com.demo.dataflushingdemo.utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author: ruitao.wei
 * @description: TODO
 * @date: 2022/10/31 11:11
 */
public class LogWriteFileUtils implements AutoCloseable {

    private static final String PATH = "D:\\IdeaProject\\DataFlushingDemo\\data\\temp_log.log";
    FileOutputStream output;

    public LogWriteFileUtils() throws FileNotFoundException {
        output = new FileOutputStream(PATH);
    }

    public void write(String aLog) {
        try {
            output.write((aLog + "\n").getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void close() {
        try {
            output.close();
            System.out.println(LogGenerator.infoLog(this.getClass().getName()+"退出"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
