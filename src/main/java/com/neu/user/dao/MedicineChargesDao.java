package com.neu.user.dao;

import com.neu.user.entity.MedicineCharges;

import java.util.List;

public interface MedicineChargesDao {
    public int addMedicineCharges(MedicineCharges mc);
    public int deleteMedicineCharges(int id);
    public int updateMedicineCharges(MedicineCharges mc);
    public List<MedicineCharges> findAll();
}
