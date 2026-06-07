package com.neu.user.biz;

import com.neu.user.entity.Prescription;

import java.util.List;

public interface PrescriptionBiz {
    public boolean addPrescription(Prescription p);
    public boolean deletePrescription(int id);
    public boolean updatePrescription(Prescription p);
    public List<Prescription> findAll();
}
