package com.neu.user.dao.impl;

import com.neu.user.dao.PrescriptionDao;
import com.neu.user.entity.Prescription;
import com.neu.user.util.BaseDao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrescriptionDaoImpl extends BaseDao implements PrescriptionDao {

    @Override
    public int addPrescription(Prescription p) {
        String sql = "INSERT INTO prescription (pres_code, pres_date, patient_name, pres_fee) VALUES (?, ?, ?, ?)";
        return update(sql, p.getPresCode(), p.getPresDate(), p.getPatientName(), p.getPresFee());
    }
    @Override
    public int deletePrescription(int id) {
        return update("DELETE FROM prescription WHERE id = ?", id);
    }
    @Override
    public int updatePrescription(Prescription p) {
        String sql = "UPDATE prescription SET pres_code=?, pres_date=?, patient_name=?, pres_fee=? WHERE id=?";
        return update(sql, p.getPresCode(), p.getPresDate(), p.getPatientName(), p.getPresFee(), p.getId());
    }
    @Override
    public List<Prescription> findAll() {
        List<Prescription> list = new ArrayList<>();
        ResultSet rs = query("SELECT * FROM prescription");
        try {
            while (rs != null && rs.next()) {
                Prescription p = new Prescription();
                p.setId(rs.getInt("id"));
                p.setPresCode(rs.getString("pres_code"));
                p.setPresDate(rs.getDate("pres_date"));
                p.setPatientName(rs.getString("patient_name"));
                p.setPresFee(rs.getInt("pres_fee"));
                list.add(p);
            }
        } catch (Exception e) { e.printStackTrace(); } finally { close(); }
        return list;
    }
}
