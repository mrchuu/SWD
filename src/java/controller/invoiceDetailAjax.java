/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.TreatmentPlanDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.DecimalFormat;
import java.util.List;
import model.TreatmentPlan;

/**
 *
 * @author Nhat Anh
 */
@WebServlet(name = "invoiceDetailAjax", urlPatterns = {"/invoiceDetailAjax"})
public class invoiceDetailAjax extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        TreatmentPlanDAO dao = new TreatmentPlanDAO();

        int patientId = Integer.parseInt(request.getParameter("patientId"));
        List<TreatmentPlan.Invoice> invoices = dao.getInvoiceDetailByPatientId(patientId);

        int index = 1;
        int sum = 0;
        try ( PrintWriter out = response.getWriter()) {
            out.println("<table class=\"table\">\n"
                    + "                                <thead>\n"
                    + "                                    <tr>\n"
                    + "                                        <th scope=\"col\">STT</th>\n"
                    + "                                        <th scope=\"col\">Tên Dịch Vụ</th>\n"
                    + "                                        <th scope=\"col\">Đơn vị thanh toán</th>\n"
                    + "                                        <th scope=\"col\">Giá tiền trên 1 đơn vị (đồng)</th>\n"
                    + "                                        <th scope=\"col\">Số lượng</th>\n"
                    + "                                        <th scope=\"col\">Tổng tiền (đồng)</th>\n"
                    + "                                    </tr>\n"
                    + "                                </thead>\n"
                    + "                                <tbody >");
            for (TreatmentPlan.Invoice invoice : invoices) {
                out.println("<tr>\n"
                        + "                                        <th scope=\"row\">" + (index++) + "</th>\n"
                        + "                                        <td>" + invoice.getServiceName() + "</td>\n"
                        + "                                        <td>" + invoice.getUnitName() + "</td>\n"
                        + "                                        <td>" + formatDouble(invoice.getPricePerUnit()) + "</td>\n"
                        + "                                        <td>" + invoice.getQuantity() + "</td>\n"
                        + "                                        <td>" + formatDouble(invoice.getTotal()) + "</td>\n"
                        + "                                    </tr>");
                sum += invoice.getTotal();
            }

            out.println("</tbody>\n"
                    + "\n"
                    + "                            </table>\n"
                    + "                            <div style=\"text-align: end;\n"
                    + "                            font-size: 20px;\n"
                    + "                            font-weight: 700;\">\n"
                    + "                                Tổng tiền: <span>" + formatDouble(sum) + " (đồng)</span>\n"
                    + "                            </div>");

        }
    }
    
     public static String formatDouble(double value) {
         DecimalFormat decimalFormat = new DecimalFormat("###,###.###");
        return decimalFormat.format(value);
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
