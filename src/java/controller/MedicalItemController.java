/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.DepartmentDAO;
import dao.MedicalItemDAO;
import dao.StorageDAO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import model.Department;
import model.MedicalItem;
import model.Storage;

/**
 *
 * @author FPT
 */
@WebServlet(name = "MedicalItemController", urlPatterns = {"/MedicalItemController"})
@MultipartConfig
public class MedicalItemController extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MedicalItemController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MedicalItemController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        PrintWriter out = response.getWriter();
        DepartmentDAO departmentDAO = new DepartmentDAO();
        StorageDAO storageDAO = new StorageDAO();
        MedicalItemDAO medicalItemDAO = new MedicalItemDAO();
        Department department = departmentDAO.getById(0);
        if (department == null) {
            out.println("department does not exist");
            return;
        }
        Storage storage = storageDAO.findByDepartmentId(department.getDepartmentId());
        if (storage == null) {
            out.println("storage does not exist");
            return;
        }
        List<MedicalItem> medicalItems = medicalItemDAO.getMedicalItemsOfStorage(storage.getStorageId());

        medicalItems.forEach((medicalItem) -> {
            medicalItem.setStorage(storage);
            out.println(medicalItem.toString() + "\n");
        });
        request.setAttribute("medicalItemsOfStorage", medicalItems);
        request.getRequestDispatcher("MedicalItems.jsp").forward(request, response);

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
        PrintWriter out = response.getWriter();
        String name = getValueFromPart(request.getPart("name"));
        String image = getValueFromPart(request.getPart("image"));
        String provider = getValueFromPart(request.getPart("provider"));
        String quantiy = getValueFromPart(request.getPart("quantity"));
        String id = getValueFromPart(request.getPart("id"));
        if (name.length() == 0 || image.length() == 0 || provider.length() == 0 || quantiy.length() == 0 || id.length() == 0) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.print("Invalid Input");
            return;
        }
        MedicalItemDAO medicalItemDAO = new MedicalItemDAO();
        boolean result = medicalItemDAO.updateMedicalItem(new MedicalItem(Integer.parseInt(id), name, image, provider, Integer.parseInt(quantiy)));
        if(result){
            out.print("updated successfully");
        }else{
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.print("Something went wrong!!");
        }
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

    private String getValueFromPart(Part part) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(part.getInputStream(), "UTF-8"));
        StringBuilder value = new StringBuilder();
        char[] buffer = new char[1024];
        int bytesRead;
        while ((bytesRead = reader.read(buffer)) != -1) {
            value.append(buffer, 0, bytesRead);
        }
        return value.toString();
    }
}
