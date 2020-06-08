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
public class EditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        CustomerDBManager customerManager = (CustomerDBManager) session.getAttribute("customerManager");
        StaffDBManager staffManager = (StaffDBManager) session.getAttribute("staffManager");
        
        Customer customer = null;
        Staff staff = null;
        
        try {
            customer = customerManager.findCustomer(email, password);
            staff = staffManager.findStaff(email, password);
            
            if (customer != null) {
                session.setAttribute("customer", customer);
                request.getRequestDispatcher("edit.jsp").include(request, response);
            } else if (staff != null) {
                session.setAttribute("staff", staff);
                request.getRequestDispatcher("edit.jsp").include(request, response);
            } else {
                session.setAttribute("existErr", "User does not exist in the database!");
                request.getRequestDispatcher("edit.jsp").include(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EditServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getErrorCode() + " and " + ex.getMessage());
        }
        request.getRequestDispatcher("edit.jsp").include(request, response);
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

}
