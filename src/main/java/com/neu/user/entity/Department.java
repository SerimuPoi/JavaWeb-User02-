package com.neu.user.entity;

public class Department {
    private int id;
    private String deptCode;
    private String deptName;
    private String deptCategory;
    private String deptType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptCategory() {
        return deptCategory;
    }

    public void setDeptCategory(String deptCategory) {
        this.deptCategory = deptCategory;
    }

    public String getDeptType() {
        return deptType;
    }

    public void setDeptType(String deptType) {
        this.deptType = deptType;
    }

    public Department(int id, String deptCode, String deptName, String deptCategory, String deptType) {
        this.id = id;
        this.deptCode = deptCode;
        this.deptName = deptName;
        this.deptCategory = deptCategory;
        this.deptType = deptType;
    }

    public Department() {

    }
}
