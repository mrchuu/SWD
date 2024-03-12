/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.MyDAO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.MedicalItem;
import model.Storage;

/**
 *
 * @author FPT
 */
public class MedicalItemDAO extends MyDAO {

    public List<MedicalItem> getMedicalItemsOfStorage(int departmentId) {
        List<MedicalItem> medicalItems = new ArrayList<>();
        xSql = "Select * from Medical_Item where storage_id = " + departmentId;
        MedicalItem mi;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                medicalItems.add(new MedicalItem(
                        rs.getInt("medical_item_id"),
                        rs.getString("name"),
                        rs.getString("image"),
                        rs.getString("provider"),
                        rs.getInt("quantity")));
            };
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return medicalItems;
    }

    public boolean updateMedicalItem(MedicalItem updatedItem) {
        String updateSql = "UPDATE Medical_Item SET name=?, image=?, provider=?, quantity=? WHERE medical_item_id=?";

        try ( PreparedStatement ps = con.prepareStatement(updateSql)) {
            ps.setString(1, updatedItem.getName());
            ps.setString(2, updatedItem.getImage());
            ps.setString(3, updatedItem.getProvider());
            ps.setInt(4, updatedItem.getQuantity());
            ps.setInt(5, updatedItem.getMedicalItemId());
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("MedicalItem updated successfully.");
                return true;
            } else {
                System.out.println("Failed to update MedicalItem.");
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
    }

    

}
