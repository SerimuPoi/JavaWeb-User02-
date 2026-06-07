package com.neu.user.dao.impl;
import com.neu.user.dao.EquipmentDao;
import com.neu.user.entity.Equipment;
import com.neu.user.util.BaseDao;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EquipmentDaoImpl extends BaseDao implements EquipmentDao {
    @Override
    public int addEquipment(Equipment equip) {
        String sql = "INSERT INTO equipment (equip_code, equip_name, equip_category, equip_quantity) VALUES (?, ?, ?, ?)";
        return update(sql, equip.getEquipCode(), equip.getEquipName(), equip.getEquipCategory(), equip.getEquipQuantity());
    }
    @Override
    public int deleteEquipment(int id) {
        return update("DELETE FROM equipment WHERE id = ?", id);
    }
    @Override
    public int updateEquipment(Equipment equip) {
        String sql = "UPDATE equipment SET equip_code=?, equip_name=?, equip_category=?, equip_quantity=? WHERE id=?";
        return update(sql, equip.getEquipCode(), equip.getEquipName(), equip.getEquipCategory(), equip.getEquipQuantity(), equip.getId());
    }
    @Override
    public List<Equipment> findAll() {
        List<Equipment> list = new ArrayList<>();
        ResultSet rs = query("SELECT * FROM equipment");
        try {
            while (rs != null && rs.next()) {
                Equipment equip = new Equipment();
                equip.setId(rs.getInt("id"));
                equip.setEquipCode(rs.getString("equip_code"));
                equip.setEquipName(rs.getString("equip_name"));
                equip.setEquipCategory(rs.getString("equip_category"));
                equip.setEquipQuantity(rs.getInt("equip_quantity"));
                list.add(equip);
            }
        } catch (Exception e) { e.printStackTrace(); } finally { close(); }
        return list;
    }
}