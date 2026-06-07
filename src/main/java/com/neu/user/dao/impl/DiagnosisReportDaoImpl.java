package com.neu.user.dao.impl;

import com.neu.user.dao.DiagnosisReportDao;
import com.neu.user.entity.DiagnosisReport;
import com.neu.user.util.BaseDao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DiagnosisReportDaoImpl extends BaseDao implements DiagnosisReportDao {

    @Override
    public int addDiagnosisReport(DiagnosisReport report) {
        String sql = "INSERT INTO diagnosis_report (disease_code, disease_name, icd_code, disease_category) VALUES (?, ?, ?, ?)";
        return update(sql, report.getDiseaseCode(), report.getDiseaseName(), report.getIcdCode(), report.getDiseaseCategory());
    }
    @Override
    public int deleteDiagnosisReport(int id) {
        return update("DELETE FROM diagnosis_report WHERE id = ?", id);
    }
    @Override
    public int updateDiagnosisReport(DiagnosisReport report) {
        String sql = "UPDATE diagnosis_report SET disease_code=?, disease_name=?, icd_code=?, disease_category=? WHERE id=?";
        return update(sql, report.getDiseaseCode(), report.getDiseaseName(), report.getIcdCode(), report.getDiseaseCategory(), report.getId());
    }
    @Override
    public List<DiagnosisReport> findAll() {
        List<DiagnosisReport> list = new ArrayList<>();
        ResultSet rs = query("SELECT * FROM diagnosis_report");
        try {
            while (rs != null && rs.next()) {
                DiagnosisReport report = new DiagnosisReport();
                report.setId(rs.getInt("id"));
                report.setDiseaseCode(rs.getString("disease_code"));
                report.setDiseaseName(rs.getString("disease_name"));
                report.setIcdCode(rs.getString("icd_code"));
                report.setDiseaseCategory(rs.getString("disease_category"));
                list.add(report);
            }
        } catch (Exception e) { e.printStackTrace(); } finally { close(); }
        return list;
    }
}
