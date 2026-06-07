package com.neu.user.biz.impl;

import com.neu.user.biz.DepartmentBiz;
import com.neu.user.dao.DepartmentDao;
import com.neu.user.dao.impl.DepartmentDaoImpl;
import com.neu.user.entity.Department;

import java.util.Collections;
import java.util.List;

public class DepartmentBizImpl implements DepartmentBiz {
    private DepartmentDao deptDao = new DepartmentDaoImpl();

    @Override
    public boolean addDepartment(Department dept) {
        return deptDao.addDepartment(dept)>0;
    }

    @Override
    public boolean deleteDepartment(int id) {
        return deptDao.deleteDepartment(id)>0;
    }

    @Override
    public boolean updateDepartment(Department dept) {
        return deptDao.updateDepartment(dept)>0;
    }

    @Override
    public List<Department> finaAll() {
        return deptDao.findAll();
    }

    @Override
    public List<Department> findAll() {
        return Collections.emptyList();
    }
}
