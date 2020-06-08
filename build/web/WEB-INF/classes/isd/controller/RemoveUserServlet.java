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
public class RemoveUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String type = request.getParameter("type");

        CustomerDBManager customerManager = (CustomerDBManager) session.getAttribute("customerManager");
        boolean customer = true;

        StaffDBManager staffManager = (StaffDBManager) session.getAttribute("staffManager");
        boolean staff = true;

        try {

            if (type.equals("customer")) {
                customerManager.deleteCustomer(email);
                customer = customerManager.checkCustomer(email, password);
            } else {
                staffManager.deleteStaff(email);
                staff = staffManager.checkStaff(email, password);
            }

            if (!(staff && customer)) {
                session.setAttribute("userRemoved", email);

                response.sendRedirect("FetchUsersServlet");

            } else {
                System.out.println("called2");
                session.setAttribute("existErr", "User failed to remove!");
                response.sendRedirect("FetchUsersServlet");
            }
        } catch (SQLException ex) {
            Logger.getLogger(RemoveUserServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getErrorCode() + " and " + ex.getMessage());

            response.sendRedirect("FetchUsersServlet");
        }
    }

}
