package com.dharshiny.application.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="log")
public class LogModel{

    @Id
    @Column(name="id")
    private String id;
    @Column(name="name")
    private String name;
    @Column(name="log_type")
    private String logType;
    @Column(name="date")
    private String date;
    @Column(name="time")
    private String time;

    public LogModel(){}

    public LogModel(String id, String name, String logType, String date, String time) {
        this.id = id;
        this.name = name;
        this.logType = logType;
        this.date = date;
        this.time = time;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getLogType() {
        return logType;
    }
    public void setLogType(String logType) {
        this.logType = logType;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    

}