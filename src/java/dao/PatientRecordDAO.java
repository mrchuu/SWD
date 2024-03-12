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
public class PatientRecordDAO extends DBContext {

    public List<Patient> getListPatient(int... recordStatusIds) {
        String statusIdCondition = "";
        for (int i = 0; i < recordStatusIds.length; i++) {
            if (i == recordStatusIds.length - 1) {
                statusIdCondition += "rs.record_status_id = " + recordStatusIds[i];
            } else {
                statusIdCondition += "rs.record_status_id = " + recordStatusIds[i] + " or ";

            }

        }
        String sql = "select p.patient_id, p.name, p.address, rs.name [status_name]\n"
                + "from Patient p , Patient_record pr, recordStatus rs\n"
                + "where p.patient_id = pr.patient_id and rs.record_status_id = pr.record_status_id and ( " + statusIdCondition + " )";
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

    public void updateIsCreatedInvoice(int patientId, boolean isCreateInvoice) {
        String sql = "UPDATE [dbo].[Patient_record]\n"
                + "   SET [isCreateInvoice] = ?\n"
                + " WHERE patient_id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setBoolean(1, isCreateInvoice);
            statement.setInt(2, patientId);
            statement.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        PatientRecordDAO dao = new PatientRecordDAO();
        int[] recordStatusIds = {1};
        List<Patient> result = dao.getListPatient(recordStatusIds);
        System.out.println(result.get(0).getName());
    }
}
