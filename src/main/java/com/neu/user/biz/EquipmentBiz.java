package com.neu.user.biz;

import com.neu.user.entity.Equipment;

import java.util.List;

public interface EquipmentBiz {
    public boolean addEquipment(Equipment equip);
    public boolean deleteEquipment(int id);
    public boolean updateEquipment(Equipment equip);
    public List<Equipment> findAll();
}
