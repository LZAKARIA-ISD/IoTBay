/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isd.controller;

import isd.wsd.Admin;
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
public class AdminLoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        AdminDBManager manager = (AdminDBManager) session.getAttribute("adminManager");
        Admin admin = null;
        validator.clear(session);

        if (!validator.validateAdminUsername(username)) {
            session.setAttribute("adminUserErr", "Error: Username format incorrect");
            request.getRequestDispatcher("login.jsp").include(request, response);
        } else if (!validator.validatePassword(password)) {
            session.setAttribute("adminPassErr", "Error: Password format incorrect");
            request.getRequestDispatcher("login.jsp").include(request, response);
        } else {
            System.out.println(manager != null ? "exists" : "doesnt exist");
            try {

                admin = manager.findAdmin(username, password);
                if (admin != null) {
                    session.setAttribute("admin", admin);
                    request.getRequestDispatcher("index.jsp").include(request, response);
                } else {
                    session.setAttribute("adminExistErr", "Admin login details are incorrect");
                    request.getRequestDispatcher("login.jsp").include(request, response);
                }
            } catch (SQLException | NullPointerException ex) {
                System.out.println(ex.getMessage() == null ? "Admin does not exist" : "welcome");
                session.setAttribute("adminExistErr", "Admin does not exist in the Database!");
                request.getRequestDispatcher("login.jsp").include(request, response);
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
            out.println("<title>Servlet AdminLoginServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminLoginServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
