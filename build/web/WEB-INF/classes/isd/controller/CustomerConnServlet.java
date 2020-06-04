/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import isd.wsd.dao.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

/**
 *
 * @author chris
 */
public class CustomerConnServlet extends HttpServlet {

    private DBConnector db;
    private CustomerDBManager manager;
    private Connection conn;
    
    @Override
    
    public void init() {
        try {
            db = new DBConnector();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CustomerConnServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        conn = db.openConnection();
        try {
            manager = new CustomerDBManager(conn);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerConnServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        session.setAttribute("manager", manager);
    }
    
    @Override
    
    public void destroy() {
        try {
            db.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerConnServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CustomerConnServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CustomerConnServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
