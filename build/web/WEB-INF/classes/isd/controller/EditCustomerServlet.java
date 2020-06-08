/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isd.controller;

import isd.wsd.Customer;
import isd.wsd.dao.CustomerDBManager;
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
public class EditCustomerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        String email = request.getParameter("email");
        String oldPassword = request.getParameter("oldPassword");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String type = request.getParameter("type");

        CustomerDBManager customerManager = (CustomerDBManager) session.getAttribute("customerManager");
        Customer customer = null;

        validator.clear(session);

        if (!validator.validateEmail(email)) {
            session.setAttribute("emailErr", "Error: Email format incorrect");
            request.getRequestDispatcher("addCustomer.jsp").include(request, response);
        } else if (!validator.validateName(name)) {
            session.setAttribute("nameErr", "Error: Name format incorrect");
            request.getRequestDispatcher("addCustomer.jsp").include(request, response);
        } else if (!validator.validatePassword(password)) {
            session.setAttribute("passErr", "Error: Password format incorrect");
            request.getRequestDispatcher("addCustomer.jsp").include(request, response);
        } else {
            try {
                customer = customerManager.findCustomer(email, oldPassword);

                if (customer != null) {
                    customerManager.updateCustomer(email, password, name, phone, type);
                    session.setAttribute("customerEdit", new Customer(email, password, name, phone, type));
                    session.setAttribute("customerUpdated", name);
                    request.getRequestDispatcher("editCustomer.jsp").include(request, response);

                } else {
                    session.setAttribute("existErr", "User does not exist in the database!");
                    request.getRequestDispatcher("FetchUsersServlet").include(request, response);
                }
            } catch (SQLException ex) {
                Logger.getLogger(EditCustomerServlet.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.getErrorCode() + " and " + ex.getMessage());

                request.getRequestDispatcher("FetchUsersServlet").include(request, response);
            }
        }
    }

}
