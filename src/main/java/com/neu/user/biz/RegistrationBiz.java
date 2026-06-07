package com.neu.user.biz;
import com.neu.user.entity.Registration;
import java.util.List;

public interface RegistrationBiz {
    public boolean addRegistration(Registration reg);
    public boolean deleteRegistration(int id);
    public boolean updateRegistration(Registration reg);
    public List<Registration> findAll();
}