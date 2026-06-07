package com.neu.user.dao.impl;

import com.neu.user.dao.SchedulingDao;
import com.neu.user.entity.Scheduling;
import com.neu.user.util.BaseDao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SchedulingDaoImpl extends BaseDao implements SchedulingDao {
    @Override
    public int addScheduling(Scheduling s) {
        String sql = "INSERT INTO scheduling (doctor_id, doctor_name, doctor_type, schedule_date) VALUES (?, ?, ?, ?)";
        return update(sql, s.getDoctorId(), s.getDoctorName(), s.getDoctorType(), s.getScheduleDate());
    }
    @Override
    public int deleteScheduling(int id) {
        return update("DELETE FROM scheduling WHERE id = ?", id);
    }
    @Override
    public int updateScheduling(Scheduling s) {
        String sql = "UPDATE scheduling SET doctor_id=?, doctor_name=?, doctor_type=?, schedule_date=? WHERE id=?";
        return update(sql, s.getDoctorId(), s.getDoctorName(), s.getDoctorType(), s.getScheduleDate(), s.getId());
    }
    @Override
    public List<Scheduling> findAll() {
        List<Scheduling> list = new ArrayList<>();
        ResultSet rs = query("SELECT * FROM scheduling");
        try {
            while (rs != null && rs.next()) {
                Scheduling s = new Scheduling();
                s.setId(rs.getInt("id"));
                s.setDoctorId(rs.getInt("doctor_id"));
                s.setDoctorName(rs.getString("doctor_name"));
                s.setDoctorType(rs.getString("doctor_type"));
                s.setScheduleDate(rs.getDate("schedule_date"));
                list.add(s);
            }
        } catch (Exception e) { e.printStackTrace(); } finally { close(); }
        return list;
    }
}
