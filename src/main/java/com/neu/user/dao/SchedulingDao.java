package com.neu.user.dao;

import com.neu.user.entity.Scheduling;

import java.util.List;

public interface SchedulingDao {
    public int addScheduling(Scheduling s);
    public int deleteScheduling(int id);
    public int updateScheduling(Scheduling s);
    public List<Scheduling> findAll();
}
