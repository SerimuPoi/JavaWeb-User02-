package com.neu.user.biz;

import com.neu.user.entity.Scheduling;

import java.util.List;

public interface SchedulingBiz {
    public boolean addScheduling(Scheduling s);
    public boolean deleteScheduling(int id);
    public boolean updateScheduling(Scheduling s);
    public List<Scheduling> findAll();
}
