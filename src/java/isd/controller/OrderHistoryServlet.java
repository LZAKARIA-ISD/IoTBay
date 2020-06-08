
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isd.controller;

import isd.wsd.Order;
import isd.wsd.dao.DBOrderManager;
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
 * @author Sorakrit
 */
public class OrderHistoryServlet extends HttpServlet {

    @Override   
     protected void doGet(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {       
             
             HttpSession session = request.getSession();
             DBOrderManager ordManager = (DBOrderManager)session.getAttribute("ordManager");
             session.setAttribute("ordsearch", null);
             session.setAttribute("ordupdate", null);
             Validator validator = new Validator();
             validator.clear(session);
             
             ArrayList<Order> orders = new ArrayList();       
                     try {       
                         orders = ordManager.fectOrder();
                     } catch (SQLException ex) {           
                           Logger.getLogger(OrderHistoryServlet.class.getName()).log(Level.SEVERE, null, ex);       
                     }
         
                if (orders != null) {                                
                      session.setAttribute("orders", orders);
               }  
               request.getRequestDispatcher("orderHistory.jsp").include(request, response);
      }
     }
