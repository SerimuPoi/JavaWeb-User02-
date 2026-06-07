package com.neu.user.entity;

import java.util.Date;

public class Record {
    private int id;
    private String recordCode;
    private Date recordDate;
    private String patientName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRecordCode() {
        return recordCode;
    }

    public void setRecordCode(String recordCode) {
        this.recordCode = recordCode;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Record(int id, String recordCode, Date recordDate, String patientName) {
        this.id = id;
        this.recordCode = recordCode;
        this.recordDate = recordDate;
        this.patientName = patientName;
    }

    public Record() {

    }
}
