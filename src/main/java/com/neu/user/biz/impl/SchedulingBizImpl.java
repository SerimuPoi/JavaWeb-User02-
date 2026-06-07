package com.neu.user.biz.impl;
import com.neu.user.biz.SchedulingBiz;
import com.neu.user.dao.SchedulingDao;
import com.neu.user.dao.impl.SchedulingDaoImpl;
import com.neu.user.entity.Scheduling;
import java.util.List;

public class SchedulingBizImpl implements SchedulingBiz {
    private SchedulingDao sDao = new SchedulingDaoImpl();

    @Override
    public boolean addScheduling(Scheduling s) {
        return sDao.addScheduling(s) > 0;
    }

    @Override
    public boolean deleteScheduling(int id) {
        return sDao.deleteScheduling(id) > 0;
    }

    @Override
    public boolean updateScheduling(Scheduling s) {
        return sDao.updateScheduling(s) > 0;
    }

    @Override
    public List<Scheduling> findAll() {
        return sDao.findAll();
    }
}