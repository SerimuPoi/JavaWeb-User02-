package com.neu.user.entity;

public class DiagnosisReport {
    private int id;
    private String diseaseCode;
    private String diseaseName;
    private String icdCode;
    private String diseaseCategory;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDiseaseCode() {
        return diseaseCode;
    }

    public void setDiseaseCode(String diseaseCode) {
        this.diseaseCode = diseaseCode;
    }

    public String getIcdCode() {
        return icdCode;
    }

    public void setIcdCode(String icdCode) {
        this.icdCode = icdCode;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public String getDiseaseCategory() {
        return diseaseCategory;
    }

    public void setDiseaseCategory(String diseaseCategory) {
        this.diseaseCategory = diseaseCategory;
    }

    public DiagnosisReport(int id, String diseaseCode, String diseaseName, String icdCode, String diseaseCategory) {
        this.id = id;
        this.diseaseCode = diseaseCode;
        this.diseaseName = diseaseName;
        this.icdCode = icdCode;
        this.diseaseCategory = diseaseCategory;
    }

    public DiagnosisReport() {

    }
}
