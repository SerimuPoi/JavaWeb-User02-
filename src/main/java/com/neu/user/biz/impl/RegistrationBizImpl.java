package com.neu.user.biz.impl;
import com.neu.user.biz.RegistrationBiz;
import com.neu.user.dao.RegistrationDao;
import com.neu.user.dao.impl.RegistrationDaoImpl;
import com.neu.user.entity.Registration;
import java.util.List;

public class RegistrationBizImpl implements RegistrationBiz {
    private RegistrationDao regDao = new RegistrationDaoImpl();

    @Override
    public boolean addRegistration(Registration reg) {
        return regDao.addRegistration(reg) > 0;
    }

    @Override
    public boolean deleteRegistration(int id) {
        return regDao.deleteRegistration(id) > 0;
    }

    @Override
    public boolean updateRegistration(Registration reg) {
        return regDao.updateRegistration(reg) > 0;
    }

    @Override
    public List<Registration> findAll() {
        return regDao.findAll();
    }

}