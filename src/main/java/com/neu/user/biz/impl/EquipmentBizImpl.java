package com.neu.user.biz.impl;

import com.neu.user.biz.EquipmentBiz;
import com.neu.user.dao.EquipmentDao;
import com.neu.user.dao.impl.EquipmentDaoImpl;
import com.neu.user.entity.Equipment;

import java.util.Collections;
import java.util.List;

public class EquipmentBizImpl implements EquipmentBiz {

    private EquipmentDao equipDao = new EquipmentDaoImpl();

    @Override
    public boolean addEquipment(Equipment equip) {
        return equipDao.addEquipment(equip) > 0;
    }

    @Override
    public boolean deleteEquipment(int id) {
        return equipDao.deleteEquipment(id) > 0;
    }

    @Override
    public boolean updateEquipment(Equipment equip) {
        return equipDao.updateEquipment(equip) > 0;
    }

    @Override
    public List<Equipment> findAll() {
        return equipDao.findAll();
    }
}
