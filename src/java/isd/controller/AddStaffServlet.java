/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isd.controller;

import isd.wsd.Staff;
import isd.wsd.dao.StaffDBManager;
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
public class AddStaffServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String position = request.getParameter("position");
        session.setAttribute("existErr", null);

        StaffDBManager manager = (StaffDBManager) session.getAttribute("staffManager");
        validator.clear(session);

        if (!validator.validateEmail(email)) {
            session.setAttribute("emailErr", "Error: Email format incorrect");
            request.getRequestDispatcher("addStaff.jsp").include(request, response);
        } else if (!validator.validateName(name)) {
            session.setAttribute("nameErr", "Error: Name format incorrect");
            request.getRequestDispatcher("addStaff.jsp").include(request, response);
        } else if (!validator.validatePassword(password)) {
            session.setAttribute("passErr", "Error: Password format incorrect");
            request.getRequestDispatcher("addStaff.jsp").include(request, response);
        } else {
            try {
                Staff exist = manager.findStaff(email, password);
                if (exist != null) {
                    session.setAttribute("existErr", "Customer already in the Database!");
                    request.getRequestDispatcher("addStaff.jsp").include(request, response);
                } else {
                    manager.addStaff(email, password, name, phone, position);
                    session.setAttribute("staffAdded", name);
                    request.getRequestDispatcher("addStaff.jsp").include(request, response);
                }
            } catch (SQLException ex) {
                request.getRequestDispatcher("addStaff.jsp").include(request, response);
                Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
