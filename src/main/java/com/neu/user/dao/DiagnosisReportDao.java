package com.neu.user.dao;
import com.neu.user.entity.DiagnosisReport;
import java.util.List;

public interface DiagnosisReportDao {
    public int addDiagnosisReport(DiagnosisReport report);
    public int deleteDiagnosisReport(int id);
    public int updateDiagnosisReport(DiagnosisReport report);
    public List<DiagnosisReport> findAll();
}