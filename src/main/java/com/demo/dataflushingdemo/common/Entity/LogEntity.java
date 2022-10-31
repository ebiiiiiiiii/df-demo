package com.demo.dataflushingdemo.common.Entity;

public class LogEntity {
    private String createDay;
    private String createTime;
    private String level;
    private String data;

    public String getCreateDay() {
        return createDay;
    }

    public void setCreateDay(String createDay) {
        this.createDay = createDay;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "LogEntity{" +
                "createDay='" + createDay + '\'' +
                ", createTime='" + createTime + '\'' +
                ", level='" + level + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
