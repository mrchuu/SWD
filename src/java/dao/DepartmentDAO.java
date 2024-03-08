/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.MyDAO;
import java.util.ArrayList;
import java.util.List;
import model.Department;

/**
 *
 * @author FPT
 */
public class DepartmentDAO extends MyDAO {

    public List<Department> getAll() {
        List<Department> departments = new ArrayList<>();
        xSql = "Select * from Department";
        String name;
        Integer departmentId;
        Department department;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                department = new Department(rs.getInt("department_id"), rs.getString("name"));
                departments.add(department);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return departments;
    }

}
