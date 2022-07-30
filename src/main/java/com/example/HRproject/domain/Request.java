package com.example.HRproject.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Request {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long requestId;

    private Date date;
    private Integer studentId;
    private StatusRequest requestStatus;

    public Request(){
    }

    public Request(Date date, Integer studentId, StatusRequest requestStatus) {
        this.date = date;
        this.studentId = studentId;
        this.requestStatus = requestStatus;
    }

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
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

    public StatusRequest getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(StatusRequest requestStatus) {
        this.requestStatus = requestStatus;
    }
}
