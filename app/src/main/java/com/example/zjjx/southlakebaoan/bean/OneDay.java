package com.example.zjjx.southlakebaoan.bean;

public class OneDay {
    private String day;//哪一天
    private String weekDay;//星期几
    private String workType;

    public OneDay(String day, String weekDay, String workType) {
        this.day = day;
        this.weekDay = weekDay;
        this.workType = workType;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }
}
