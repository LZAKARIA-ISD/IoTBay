/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isd.controller;

import isd.wsd.Customer;
import isd.wsd.dao.CustomerDBManager;
import java.io.IOException;
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
 * @author lucas
 */
public class AddCustomerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String type = request.getParameter("type");
        session.setAttribute("existErr", null);

        CustomerDBManager manager = (CustomerDBManager) session.getAttribute("customerManager");
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
                System.out.println("test1");
                Customer exist = manager.findCustomer(email, password);
                System.out.println("test2");
                if (exist != null) {
                    session.setAttribute("existErr", "Customer already in the Database!");
                    request.getRequestDispatcher("addCustomer.jsp").include(request, response);
                } else {
                    manager.addCustomer(email, password, name, phone, type);
                    session.setAttribute("customerAdded", name);
                    request.getRequestDispatcher("addCustomer.jsp").include(request, response);
                }
            } catch (SQLException ex) {

                Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
