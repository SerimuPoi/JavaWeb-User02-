package com.neu.user.entity;

import java.util.Date;

public class Scheduling {
    private int id;
    private int doctorId;
    private String doctorName;
    private String doctorType;
    private Date scheduleDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorType() {
        return doctorType;
    }

    public void setDoctorType(String doctorType) {
        this.doctorType = doctorType;
    }

    public Date getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(Date scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public Scheduling(int id, int doctorId, String doctorName, String doctorType, Date scheduleDate) {
        this.id = id;
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.doctorType = doctorType;
        this.scheduleDate = scheduleDate;
    }

    public Scheduling() {

    }
}
