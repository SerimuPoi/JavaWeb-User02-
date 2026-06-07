package com.neu.user.dao;

import com.neu.user.entity.Equipment;

import java.util.List;

public interface EquipmentDao {
    public int addEquipment(Equipment equip);
    public int updateEquipment(Equipment equip);
    public int deleteEquipment(int id);
    public List<Equipment> findAll();
}
