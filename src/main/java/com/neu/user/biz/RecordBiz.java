package com.neu.user.biz;

import com.neu.user.entity.Record;

import java.util.List;

public interface RecordBiz {
    public boolean addRecord(Record r);
    public boolean deleteRecord(int id);
    public boolean updateRecord(Record r);
    public List<Record> findAll();
}
