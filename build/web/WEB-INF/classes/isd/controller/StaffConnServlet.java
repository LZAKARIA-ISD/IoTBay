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
public class StaffConnServlet extends HttpServlet {
    
    private DBConnector db;
    private StaffDBManager manager;
    private Connection conn;
    
    @Override
    
    public void init() {
        try {
            db = new DBConnector();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StaffConnServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        conn = db.openConnection();
        try {
            manager = new StaffDBManager(conn);
        } catch (SQLException ex) {
            Logger.getLogger(StaffConnServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        session.setAttribute("manager", manager);
    }
    
    @Override
    
    public void destroy() {
        try {
            db.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(StaffConnServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            out.println("<title>Servlet StaffConServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet StaffConServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

}
