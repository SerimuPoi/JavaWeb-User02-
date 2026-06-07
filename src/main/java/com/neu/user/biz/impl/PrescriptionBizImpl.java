package com.neu.user.biz.impl;

import com.neu.user.biz.PrescriptionBiz;
import com.neu.user.dao.PrescriptionDao;
import com.neu.user.dao.impl.PrescriptionDaoImpl;
import com.neu.user.entity.Prescription;

import java.util.Collections;
import java.util.List;

public class PrescriptionBizImpl implements PrescriptionBiz {

    private PrescriptionDao pDao = new PrescriptionDaoImpl();

    @Override
    public boolean addPrescription(Prescription p) {
        return pDao.addPrescription(p) > 0;
    }

    @Override
    public boolean deletePrescription(int id) {
        return pDao.deletePrescription(id) > 0;
    }

    @Override
    public boolean updatePrescription(Prescription p) {
        return pDao.updatePrescription(p) > 0;
    }

    @Override
    public List<Prescription> findAll() {
        return pDao.findAll();
    }

}
