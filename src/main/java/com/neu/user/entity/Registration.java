package com.neu.user.entity;

public class Registration {
    private int id;
    private String regCode;
    private String regName;
    private int displayOrder;
    private int regFee;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegCode() {
        return regCode;
    }

    public void setRegCode(String regCode) {
        this.regCode = regCode;
    }

    public String getRegName() {
        return regName;
    }

    public void setRegName(String regName) {
        this.regName = regName;
    }

    public int getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }

    public int getRegFee() {
        return regFee;
    }

    public void setRegFee(int regFee) {
        this.regFee = regFee;
    }

    public Registration(int id, String regCode, String regName, int displayOrder, int regFee) {
        this.id = id;
        this.regCode = regCode;
        this.regName = regName;
        this.displayOrder = displayOrder;
        this.regFee = regFee;
    }

    public Registration() {

    }
}
