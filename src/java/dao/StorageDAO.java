/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.MyDAO;
import model.Department;
import model.Storage;

/**
 *
 * @author FPT
 */
public class StorageDAO extends MyDAO {
    
    public Storage findById(Integer storageId) {
       
        xSql = "Select * from Medical_Item_Storage where storage_id = " + storageId;
         Storage storage = null;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            if (rs.next()) {
               storage = new Storage(rs.getInt("storage_id"), rs.getString("code"));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return storage;
    }
     
    public Storage findByDepartmentId(Integer storageId) {
       
        xSql = "Select * from Medical_Item_Storage where department_id = " + storageId;
         Storage storage = null;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            if (rs.next()) {
               storage = new Storage(rs.getInt("storage_id"), rs.getString("code"));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return storage;
    }

}
