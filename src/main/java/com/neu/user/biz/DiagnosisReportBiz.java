package com.neu.user.biz;

import com.neu.user.entity.DiagnosisReport;

import java.util.List;

public interface DiagnosisReportBiz {
    public boolean addDiagnosisReport(DiagnosisReport report);
    public boolean deleteDiagnosisReport(int id);
    public boolean updateDiagnosisReport(DiagnosisReport report);
    public List<DiagnosisReport> findAll();
}
