/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isd.controller;

import isd.wsd.Staff;
import isd.wsd.dao.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author chris
 */
public class StaffLoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        StaffDBManager manager = (StaffDBManager) session.getAttribute("manager");
        Staff staff = null;
        validator.clear(session);
        
        if (!validator.validateEmail(email)){
             session.setAttribute("emailErr", "Error: Email format incorrect");
           request.getRequestDispatcher("staff/login.jsp").include(request, response);
       } else if (!validator.validatePassword(password)) {
           session.setAttribute("passErr", "Error: Password format incorrect");
           request.getRequestDispatcher("staff/login.jsp").include(request, response);
       } else {
           try {
               staff = manager.findStaff(email, password);
               if (staff !=null) {
                   session.setAttribute("staff", staff);
                   request.getRequestDispatcher("staff/main.jsp").include(request, response);
               } else {
                   session.setAttribute("existErr", "Staff does not exist in the Database!") ;
                   request.getRequestDispatcher("staff/login.jsp").include(request, response);
               }
           } catch (SQLException | NullPointerException ex) {
               System.out.println(ex.getMessage() == null ? "Staff does not exist" : "welcome");
               session.setAttribute("existErr", "Staff does not exist in the Database!") ;
               request.getRequestDispatcher("staff/login.jsp").include(request, response);
           }
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
            out.println("<title>Servlet StaffLoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet StaffLoginServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
