package com.neu.user.entity;

public class Equipment {
    private int id;
    private String equipCode;
    private String equipName;
    private String equipCategory;
    private int equipQuantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEquipCode() {
        return equipCode;
    }

    public void setEquipCode(String equipCode) {
        this.equipCode = equipCode;
    }

    public String getEquipName() {
        return equipName;
    }

    public void setEquipName(String equipName) {
        this.equipName = equipName;
    }

    public String getEquipCategory() {
        return equipCategory;
    }

    public void setEquipCategory(String equipCategory) {
        this.equipCategory = equipCategory;
    }

    public int getEquipQuantity() {
        return equipQuantity;
    }

    public void setEquipQuantity(int equipQuantity) {
        this.equipQuantity = equipQuantity;
    }

    public Equipment(int id, String equipCode, String equipName, String equipCategory, int equipQuantity) {
        this.id = id;
        this.equipCode = equipCode;
        this.equipName = equipName;
        this.equipCategory = equipCategory;
        this.equipQuantity = equipQuantity;
    }

    public Equipment() {

    }
}
