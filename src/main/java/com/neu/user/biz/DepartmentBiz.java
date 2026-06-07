package com.neu.user.biz;

import com.neu.user.entity.Department;

import java.util.List;

public interface DepartmentBiz {
    public boolean addDepartment(Department dept);
    public boolean deleteDepartment(int id);
    public boolean updateDepartment(Department dept);
    public List<Department> finaAll();

    public List<Department> findAll();
}
