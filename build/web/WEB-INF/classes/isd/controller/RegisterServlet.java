/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isd.controller;

import isd.wsd.Customer;
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
public class RegisterServlet extends HttpServlet {

     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String dob = request.getParameter("dob");
        
        CustomerDBManager manager = (CustomerDBManager) session.getAttribute("manager");
        validator.clear(session);
        
        if (!validator.validateEmail(email)){
           session.setAttribute("emailErr", "Error: Email format incorrect");
           request.getRequestDispatcher("register.jsp").include(request, response);
       } else if (!validator.validateName(name)) {
           session.setAttribute("nameErr", "Error: Name format incorrect");
           request.getRequestDispatcher("register.jsp").include(request, response);
       } else if (!validator.validatePassword(password)) {
           session.setAttribute("passErr", "Error: Password format incorrect");
           request.getRequestDispatcher("register.jsp").include(request, response);
       } else {
           try {
               Customer exist = manager.findCustomer(email, password);
               if (exist !=null) {
                   session.setAttribute("existErr", "Customer already in the Database!") ;
                   request.getRequestDispatcher("login.jsp").include(request, response);
               } else {
                   manager.addCustomer(email, name, password, phone, dob);
               }
           } catch (SQLException | NullPointerException ex) {
               System.out.println(ex.getMessage() == null ? "Customer does not exist" : "welcome");
               session.setAttribute("existErr", "Customer already in the Database!") ;
               request.getRequestDispatcher("register.jsp").include(request, response);
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
            out.println("<title>Servlet RegisterServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegisterServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }



}
