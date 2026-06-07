package com.neu.user.dao.impl;

import com.neu.user.dao.MedicineChargesDao;
import com.neu.user.entity.MedicineCharges;
import com.neu.user.util.BaseDao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MedicineChargesDaoImpl extends BaseDao implements MedicineChargesDao {
    @Override
    public int addMedicineCharges(MedicineCharges mc) {
        String sql = "INSERT INTO medicine_charges (med_code, med_name, med_quantity, med_price) VALUES (?, ?, ?, ?)";
        return update(sql, mc.getMedCode(), mc.getMedName(), mc.getMedQuantity(), mc.getMedPrice());
    }
    @Override
    public int deleteMedicineCharges(int id) {
        return update("DELETE FROM medicine_charges WHERE id = ?", id);
    }
    @Override
    public int updateMedicineCharges(MedicineCharges mc) {
        String sql = "UPDATE medicine_charges SET med_code=?, med_name=?, med_quantity=?, med_price=? WHERE id=?";
        return update(sql, mc.getMedCode(), mc.getMedName(), mc.getMedQuantity(), mc.getMedPrice(), mc.getId());
    }
    @Override
    public List<MedicineCharges> findAll() {
        List<MedicineCharges> list = new ArrayList<>();
        ResultSet rs = query("SELECT * FROM medicine_charges");
        try {
            while (rs != null && rs.next()) {
                MedicineCharges mc = new MedicineCharges();
                mc.setId(rs.getInt("id"));
                mc.setMedCode(rs.getString("med_code"));
                mc.setMedName(rs.getString("med_name"));
                mc.setMedQuantity(rs.getInt("med_quantity"));
                mc.setMedPrice(rs.getInt("med_price"));
                list.add(mc);
            }
        } catch (Exception e) { e.printStackTrace(); } finally { close(); }
        return list;
    }
}
