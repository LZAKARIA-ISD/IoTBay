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
public class EditUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String type = request.getParameter("type");

        session.setAttribute("customerEdit", null);
        session.setAttribute("staffEdit", null);

        System.out.println("email = " + email);
        System.out.println("pass = " + password);
        System.out.println("type = " + type);

        CustomerDBManager customerManager = (CustomerDBManager) session.getAttribute("customerManager");
        Customer customer = null;

        StaffDBManager staffManager = (StaffDBManager) session.getAttribute("staffManager");
        Staff staff = null;

        try {

            if (type.equals("customer")) {

                customer = customerManager.findCustomer(email, password);

            } else {
                staff = staffManager.findStaff(email, password);
            }

            if (customer != null) {

                session.setAttribute("customerEdit", customer);

                request.getRequestDispatcher("editCustomer.jsp").include(request, response);

            } else if (staff != null) {
                session.setAttribute("staffEdit", staff);
                request.getRequestDispatcher("editStaff.jsp").include(request, response);
            } else {
                session.setAttribute("existErr", "User does not exist in the database!");
                request.getRequestDispatcher("FetchUsersServlet").include(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EditUserServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getErrorCode() + " and " + ex.getMessage());
            System.out.println("this is cbeing called");
            request.getRequestDispatcher("FetchUsersServlet").include(request, response);
        }
    }

}
