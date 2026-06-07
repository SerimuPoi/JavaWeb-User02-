package com.neu.user.dao.impl;

import com.neu.user.dao.DepartmentDao;
import com.neu.user.entity.Department;
import com.neu.user.util.BaseDao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoImpl extends BaseDao implements DepartmentDao {
    @Override
    public int addDepartment(Department dept) {
        String sql = "INSERT INTO department (dept_code, dept_name, dept_category, dept_type) VALUES (?, ?, ?, ?)";
        return update(sql, dept.getDeptCode(), dept.getDeptName(), dept.getDeptCategory(), dept.getDeptType());
    }

    @Override
    public int deleteDepartment(int id) {
        String sql = "DELETE FROM department WHERE id = ?";
        return update(sql, id);
    }

    @Override
    public int updateDepartment(Department dept) {
        String sql = "UPDATE department SET dept_code=?, dept_name=?, dept_category=?, dept_type=? WHERE id=?";
        return update(sql, dept.getDeptCode(), dept.getDeptName(), dept.getDeptCategory(), dept.getDeptType(), dept.getId());
    }

    @Override
    public List<Department> findAll() {
        List<Department> list = new ArrayList<Department>();
        String sql = "SELECT * FROM department";
        ResultSet rs = query(sql);
        try{
            while (rs != null && rs.next()){
                Department dept = new Department();
                dept.setId(rs.getInt("id"));
                dept.setDeptCode(rs.getString("dept_code"));
                dept.setDeptName(rs.getString("dept_name"));
                dept.setDeptCategory(rs.getString("dept_category"));
                dept.setDeptType(rs.getString("dept_type"));
                list.add(dept);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            close();
        }
        return list;
    }
}
