/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isd.controller;

import isd.wsd.Order;
import isd.wsd.Product;
import isd.wsd.dao.DBOrderManager;
import isd.wsd.dao.ProductDBManager;
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
public class OrderSearchServlet extends HttpServlet {

    @Override   
     protected void doGet(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {       
             
             HttpSession session = request.getSession();  
             DBOrderManager ordManager = (DBOrderManager)session.getAttribute("ordManager");
             
             String search = request.getParameter("ordSearch"); 
             ArrayList<Order> order = new ArrayList(); 
             
                     try {       
                         order = ordManager.searchOrder(search);
                     } catch (SQLException ex) {           
                           Logger.getLogger(OrderSearchServlet.class.getName()).log(Level.SEVERE, null, ex);       
                     }
         
                if (order != null) {                                
                      session.setAttribute("order", order);
                      session.setAttribute("ordSearch", search);
               } else {                                  
                      session.setAttribute("findERR", "Error: No result found");
               }   
               request.getRequestDispatcher("orderHistory.jsp").include(request, response);
      }
     }
