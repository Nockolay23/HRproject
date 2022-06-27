package com.example.HRproject.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Request {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer requestId;

    private Date date;
    private Integer studentId;
    private Integer requestStatusId;

    public Request(){
    }

    public Request(Date date, Integer studentId, Integer requestStatusId) {
        this.date = date;
        this.studentId = studentId;
        this.requestStatusId = requestStatusId;
    }

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getRequestStatusId() {
        return requestStatusId;
    }

    public void setRequestStatusId(Integer requestStatusId) {
        this.requestStatusId = requestStatusId;
    }
}
