package com.neu.user.dao;

import com.neu.user.entity.Department;

import java.util.List;

public interface DepartmentDao {

    public int addDepartment(Department dept);

    public int deleteDepartment(int id);

    public int updateDepartment(Department dept);

    public List<Department> findAll();
}
