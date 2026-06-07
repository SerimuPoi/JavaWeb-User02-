package com.neu.user.entity;

import java.util.Date;

public class Prescription {
    private int id;
    private String presCode;
    private Date presDate;
    private String patientName;
    private int presFee;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPresCode() {
        return presCode;
    }

    public void setPresCode(String presCode) {
        this.presCode = presCode;
    }

    public Date getPresDate() {
        return presDate;
    }

    public void setPresDate(Date presDate) {
        this.presDate = presDate;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public int getPresFee() {
        return presFee;
    }

    public void setPresFee(int presFee) {
        this.presFee = presFee;
    }

    public Prescription(int id, String presCode, Date presDate, String patientName, int presFee) {
        this.id = id;
        this.presCode = presCode;
        this.presDate = presDate;
        this.patientName = patientName;
        this.presFee = presFee;
    }

    public Prescription() {

    }
}
