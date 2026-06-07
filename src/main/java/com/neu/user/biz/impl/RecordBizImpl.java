package com.neu.user.biz.impl;

import com.neu.user.biz.RecordBiz;
import com.neu.user.dao.RecordDao;
import com.neu.user.dao.impl.RecordDaoImpl;
import com.neu.user.entity.Record;

import java.util.List;

public class RecordBizImpl implements RecordBiz {
    private RecordDao rDao = new RecordDaoImpl();

    @Override
    public boolean addRecord(Record r) {
        return rDao.addRecord(r) > 0;
    }

    @Override
    public boolean deleteRecord(int id) {
        return rDao.deleteRecord(id) > 0;
    }

    @Override
    public boolean updateRecord(Record r) {
        return rDao.updateRecord(r) > 0;
    }

    @Override
    public List<Record> findAll() {
        return rDao.findAll();
    }

}
