package com.neu.user.dao.impl;

import com.neu.user.dao.RecordDao;
import com.neu.user.entity.Record;
import com.neu.user.util.BaseDao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecordDaoImpl extends BaseDao implements RecordDao {

    @Override
    public int addRecord(Record r) {
        String sql = "INSERT INTO record (record_code, record_date, patient_name) VALUES (?, ?, ?)";
        return update(sql, r.getRecordCode(), r.getRecordDate(), r.getPatientName());
    }
    @Override
    public int deleteRecord(int id) {
        return update("DELETE FROM record WHERE id = ?", id);
    }
    @Override
    public int updateRecord(Record r) {
        String sql = "UPDATE record SET record_code=?, record_date=?, patient_name=? WHERE id=?";
        return update(sql, r.getRecordCode(), r.getRecordDate(), r.getPatientName(), r.getId());
    }
    @Override
    public List<Record> findAll() {
        List<Record> list = new ArrayList<>();
        ResultSet rs = query("SELECT * FROM record");
        try {
            while (rs != null && rs.next()) {
                Record r = new Record();
                r.setId(rs.getInt("id"));
                r.setRecordCode(rs.getString("record_code"));
                r.setRecordDate(rs.getDate("record_date"));
                r.setPatientName(rs.getString("patient_name"));
                list.add(r);
            }
        } catch (Exception e) { e.printStackTrace(); } finally { close(); }
        return list;
    }
}
