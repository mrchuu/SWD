/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import config.DBContext;
import model.Patient;

/**
 *
 * @author FPT
 */
public class PatientRecordDAO extends DBContext{
     public List<Patient> getListPatient() {
        String sql = "select p.patient_id, p.name, p.address, rs.name [status_name]\n"
                + "from Patient p , Patient_record pr, recordStatus rs\n"
                + "where p.patient_id = pr.patient_id and rs.record_status_id = pr.record_status_id";
        List<Patient> result = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                Patient patient = new Patient();
                patient.setPatientId(rs.getInt("patient_id"));
                patient.setName(rs.getString("name"));
                patient.setAddress(rs.getString("address"));
                patient.setStatusName(rs.getString("status_name"));
                result.add(patient);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }

    public static void main(String[] args) {
        PatientRecordDAO dao = new PatientRecordDAO();
        List<Patient> result = dao.getListPatient();
        System.out.println(result.get(0).getName());
    }
}
