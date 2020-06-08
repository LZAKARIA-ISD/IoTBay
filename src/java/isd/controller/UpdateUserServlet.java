/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isd.controller;

import isd.wsd.Customer;
import isd.wsd.Staff;
import isd.wsd.dao.CustomerDBManager;
import isd.wsd.dao.StaffDBManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author chris
 */
public class UpdateUserServlet extends HttpServlet {
    
    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String type = request.getParameter("type");
        String pos = request.getParameter("pos");
        
        Customer customer = new Customer(email, password, name, phone, type);
        Staff staff = new Staff(email, password, name, phone, pos);
        
        CustomerDBManager customerManager = (CustomerDBManager) session.getAttribute("customerManager");
        StaffDBManager staffManager = (StaffDBManager) session.getAttribute("staffManager");
        
        try {
            if (customer != null) {
                session.setAttribute("customer", customer);
                customerManager.updateCustomer(email, name, password, phone, type);
                session.setAttribute("updated", "Update was successful");
                request.getRequestDispatcher("edit.jsp").include(request, response);
            } else if (staff != null) {
                session.setAttribute("staff", staff);
                staffManager.updateStaff(email, name, password, phone, pos);
                session.setAttribute("updated", "Update was successful");
                request.getRequestDispatcher("edit.jsp").include(request, response);
            } else {
                session.setAttribute("updated", "Update was unsuccessful");
                request.getRequestDispatcher("edit.jsp").include(request, response);
            } 
        } catch (SQLException ex) {
            Logger.getLogger(EditServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateUserServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateUserServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


}
