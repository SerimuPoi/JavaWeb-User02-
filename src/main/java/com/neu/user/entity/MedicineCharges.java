package com.neu.user.entity;

public class MedicineCharges {
    private int id;
    private String medCode;
    private String medName;
    private int medQuantity;
    private int medPrice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMedCode() {
        return medCode;
    }

    public void setMedCode(String medCode) {
        this.medCode = medCode;
    }

    public String getMedName() {
        return medName;
    }

    public void setMedName(String medName) {
        this.medName = medName;
    }

    public int getMedQuantity() {
        return medQuantity;
    }

    public void setMedQuantity(int medQuantity) {
        this.medQuantity = medQuantity;
    }

    public int getMedPrice() {
        return medPrice;
    }

    public void setMedPrice(int medPrice) {
        this.medPrice = medPrice;
    }

    public MedicineCharges(int id, String medCode, String medName, int medQuantity, int medPrice) {
        this.id = id;
        this.medCode = medCode;
        this.medName = medName;
        this.medQuantity = medQuantity;
        this.medPrice = medPrice;
    }
    public MedicineCharges(){

    }
}
