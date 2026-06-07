package com.neu.user.dao;

import com.neu.user.entity.Prescription;

import java.util.List;

public interface PrescriptionDao {
    public int addPrescription(Prescription p);
    public int deletePrescription(int id);
    public int updatePrescription(Prescription p);
    public List<Prescription> findAll();
}
