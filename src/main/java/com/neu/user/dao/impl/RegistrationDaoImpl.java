package com.neu.user.dao.impl;

import com.neu.user.dao.RegistrationDao;
import com.neu.user.entity.Registration;
import com.neu.user.util.BaseDao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RegistrationDaoImpl extends BaseDao implements RegistrationDao {

    @Override
    public int addRegistration(Registration reg) {
        String sql = "INSERT INTO registration (reg_code, reg_name, display_order, reg_fee) VALUES (?, ?, ?, ?)";
        return update(sql, reg.getRegCode(), reg.getRegName(), reg.getDisplayOrder(), reg.getRegFee());
    }
    @Override
    public int deleteRegistration(int id) {
        return update("DELETE FROM registration WHERE id = ?", id);
    }
    @Override
    public int updateRegistration(Registration reg) {
        String sql = "UPDATE registration SET reg_code=?, reg_name=?, display_order=?, reg_fee=? WHERE id=?";
        return update(sql, reg.getRegCode(), reg.getRegName(), reg.getDisplayOrder(), reg.getRegFee(), reg.getId());
    }
    @Override
    public List<Registration> findAll() {
        List<Registration> list = new ArrayList<>();
        ResultSet rs = query("SELECT * FROM registration");
        try {
            while (rs != null && rs.next()) {
                Registration reg = new Registration();
                reg.setId(rs.getInt("id"));
                reg.setRegCode(rs.getString("reg_code"));
                reg.setRegName(rs.getString("reg_name"));
                reg.setDisplayOrder(rs.getInt("display_order"));
                reg.setRegFee(rs.getInt("reg_fee"));
                list.add(reg);
            }
        } catch (Exception e) { e.printStackTrace(); } finally { close(); }
        return list;
    }
}
