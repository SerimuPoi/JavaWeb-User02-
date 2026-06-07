package com.neu.user.dao;

import com.neu.user.entity.Registration;

import java.util.List;

public interface RegistrationDao {
    public int addRegistration(Registration reg);
    public int deleteRegistration(int id);
    public int updateRegistration(Registration reg);
    public List<Registration> findAll();
}
