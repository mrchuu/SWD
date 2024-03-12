/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author FPT
 */
public class RecordStatusDAO extends DBContext {

    public boolean isCanDischarge(int patientId) {
        String sql = "select pr.record_status_id from Patient_record pr\n"
                + "where pr.record_status_id = 1 and pr.patient_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, patientId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public static void main(String[] args) {
        RecordStatusDAO r = new RecordStatusDAO(); 
        System.out.println(r.isCanDischarge(21));
    }
}
