package com.neu.user.dao;

import com.neu.user.entity.Record;

import java.util.List;

public interface RecordDao {
    public int addRecord(Record r);
    public int deleteRecord(int id);
    public int updateRecord(Record r);
    public List<Record> findAll();
}
