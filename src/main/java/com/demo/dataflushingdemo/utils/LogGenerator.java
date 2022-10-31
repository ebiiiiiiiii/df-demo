package com.demo.dataflushingdemo.utils;

import org.assertj.core.util.Strings;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author: ruitao.wei
 * @description: TODO
 * @date: 2022/10/31 10:50
 */
public class LogGenerator {

    private static String logTemplate = "%s %s [%s] %s";

    private static String[] LEVEL = new String[] { "INFO", "DEBUG", "ERROR" };

    private static String[] MESSAGE = new String[] { "这是一条正常日志", "这是一条DEBUG日志", "这是一条报错日志" };

    public static String getRandomLog() {
        Random random = new Random();
        int    index  = random.nextInt(LEVEL.length);
        return formatLog(index, MESSAGE[index]);
    }

    public static String infoLog(String message) {
        return formatLog(0, message);
    }

    public static String debugLog(String message) {
        return formatLog(1, message);
    }

    public static String errorLog(String message) {
        return formatLog(2, message);
    }

    private static String formatLog(int index, String message) {
        return Strings.formatIfArgs(logTemplate, getDay(), getTime(), LEVEL[index], message);
    }

    private static String getDay() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    private static String getTime() {
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }

}
