/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isd.controller;

import isd.wsd.Staff;
import isd.wsd.Customer;
import isd.wsd.User;
import isd.wsd.dao.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author lucas
 */
public class FetchUsersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();

        //session.setAttribute("userSearch", null);
        String search = request.getParameter("search");

        CustomerDBManager customerManager = (CustomerDBManager) session.getAttribute("customerManager");
        StaffDBManager staffManager = (StaffDBManager) session.getAttribute("staffManager");

        validator.clear(session);

        ArrayList<Customer> customers = new ArrayList();
        ArrayList<Staff> staff = new ArrayList();
        ArrayList<User> users = new ArrayList();

        System.out.println("Is fetch users even being called???????");

        try {
            System.out.println("test1");
            customers = customerManager.fetchCustomers();
            System.out.println("test3");
            staff = staffManager.fetchStaff();
            System.out.println("test4");

            System.out.println("Customers size = " + customers.size());
            System.out.println("Staff size = " + staff.size());

            users.addAll(customers);
            users.addAll(staff);

            System.out.println("Users size = " + users.size());

            if (users.size() > 0) {
                session.setAttribute("users", users);
                request.getRequestDispatcher("users.jsp").include(request, response);
            } else {
                session.setAttribute("usersExistErr", "No Users exist");
                request.getRequestDispatcher("users.jsp").include(request, response);
            }
        } catch (SQLException | NullPointerException ex) {
            System.out.println(ex.getMessage() == null ? "No users exist" : "welcome");
            session.setAttribute("userExistErr", "Admin does not exist in the Database!");
            request.getRequestDispatcher("users.jsp").include(request, response);
        }
    }
}