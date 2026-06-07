package com.neu.user.biz.impl;

import com.neu.user.biz.DiagnosisReportBiz;
import com.neu.user.dao.DiagnosisReportDao;
import com.neu.user.dao.impl.DiagnosisReportDaoImpl;
import com.neu.user.entity.DiagnosisReport;

import java.util.Collections;
import java.util.List;

public class DiagnosisReportBizImpl implements DiagnosisReportBiz {

    private DiagnosisReportDao reportDao = new DiagnosisReportDaoImpl();

    @Override
    public boolean addDiagnosisReport(DiagnosisReport report) {
        return reportDao.addDiagnosisReport(report) > 0;
    }

    @Override
    public boolean deleteDiagnosisReport(int id) {
        return reportDao.deleteDiagnosisReport(id) > 0;
    }

    @Override
    public boolean updateDiagnosisReport(DiagnosisReport report) {
        return reportDao.updateDiagnosisReport(report) > 0;
    }

    @Override
    public List<DiagnosisReport> findAll() {
        return reportDao.findAll();
    }
}
