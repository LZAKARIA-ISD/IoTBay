/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isd.controller;

import isd.wsd.Customer;
import isd.wsd.Staff;
import isd.wsd.TimeLog;
import isd.wsd.dao.TimeLogDBManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class FetchLogsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();

        //session.setAttribute("userSearch", null);
        String search = request.getParameter("search");

        Customer customer = (Customer) session.getAttribute("customer");
        Staff staff = (Staff) session.getAttribute("staff");
        TimeLogDBManager timeLogManager = (TimeLogDBManager) session.getAttribute("timeLogManager");

        validator.clear(session);
        ArrayList<TimeLog> timeLogs = new ArrayList();
        String userEmail;
        if (customer != null) {
            userEmail = customer.getEmail();
        } else {
            userEmail = staff.getEmail();
        }
        
        
        
        System.out.println("Is this even being called???????");

        try {
            
            timeLogs = timeLogManager.fetchTimeLog(userEmail);
            System.out.println("test3");

            

            timeLogs = timeLogManager.fetchTimeLog();
            System.out.println("test3");

            if (timeLogs.size() > 0) {
                session.setAttribute("timeLogs", timeLogs);
                request.getRequestDispatcher("viewAccount.jsp").include(request, response);
                System.out.println("gotted");
            } else {
                session.setAttribute("logsExistErr", "No logs exist");
                request.getRequestDispatcher("viewAccount.jsp").include(request, response);
                System.out.println("gone");
            }
        } catch (SQLException | NullPointerException ex) {
            System.out.println(ex.getMessage() == null ? "No logs exist" : "welcome");
            session.setAttribute("logsExistErr", "Logs does not exist in the Database!");
            request.getRequestDispatcher("viewAccount.jsp").include(request, response);
            Logger.getLogger(FetchLogsServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
