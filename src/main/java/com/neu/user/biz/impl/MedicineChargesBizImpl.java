package com.neu.user.biz.impl;
import com.neu.user.biz.MedicineChargesBiz;
import com.neu.user.dao.MedicineChargesDao;
import com.neu.user.dao.impl.MedicineChargesDaoImpl;
import com.neu.user.entity.MedicineCharges;
import java.util.List;

public class MedicineChargesBizImpl implements MedicineChargesBiz {
    private MedicineChargesDao mcDao = new MedicineChargesDaoImpl();

    @Override
    public boolean addMedicineCharges(MedicineCharges mc) {
        return mcDao.addMedicineCharges(mc) > 0;
    }

    @Override
    public boolean deleteMedicineCharges(int id) {
        return mcDao.deleteMedicineCharges(id) > 0;
    }

    @Override
    public boolean updateMedicineCharges(MedicineCharges mc) {
        return mcDao.updateMedicineCharges(mc) > 0;
    }

    @Override
    public List<MedicineCharges> findAll() {
        return mcDao.findAll();
    }
}