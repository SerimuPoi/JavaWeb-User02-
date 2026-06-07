package com.neu.user.biz;

import com.neu.user.entity.MedicineCharges;

import java.util.List;

public interface MedicineChargesBiz {
    public boolean addMedicineCharges(MedicineCharges mc);
    public boolean deleteMedicineCharges(int id);
    public boolean updateMedicineCharges(MedicineCharges mc);
    public List<MedicineCharges> findAll();
}
