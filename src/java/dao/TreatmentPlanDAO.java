/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import java.util.List;

import config.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.TreatmentPlan;

/**
 *
 * @author FPT
 */
public class TreatmentPlanDAO extends DBContext {

    public List<TreatmentPlan.Invoice> getInvoiceDetailByPatientId(int patientId) {
        List<TreatmentPlan.Invoice> result = new ArrayList<>();
        String sql = "select s.name [service_name], s.unit, s.price[price_per_unit], tp.quantity, (quantity * s.price) [total]\n"
                + "from Service s, Patient_record pr, Treatment_Plan tp\n"
                + "where pr.record_id = tp.record_id and s.service_id = tp.service_id and pr.patient_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, patientId);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                TreatmentPlan.Invoice invoice = new TreatmentPlan.Invoice();
                invoice.setQuantity(rs.getInt("quantity"));
                invoice.setPricePerUnit(rs.getDouble("price_per_unit"));
                invoice.setServiceName(rs.getString("service_name"));
                invoice.setUnitName(rs.getString("unit"));
                invoice.setTotal(rs.getDouble("total"));
                result.add(invoice);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }

    public static void main(String[] args) {
        TreatmentPlanDAO dao = new TreatmentPlanDAO();
        List<TreatmentPlan.Invoice> result = dao.getInvoiceDetailByPatientId(21);
        System.out.println(result.get(0).getServiceName());
    }
}
