/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * Sorakrit
 */
package isd.controller;

import isd.wsd.dao.DBOrderManager;
import isd.wsd.dao.ProductDBManager;
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
import isd.wsd.Order;
import isd.wsd.Product;

/**
 *
 * @author Sam
 */
public class OrderAddServlet extends HttpServlet {

    @Override   
     protected void doPost(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {       
             
             HttpSession session = request.getSession();  
             ProductDBManager productManager = (ProductDBManager)session.getAttribute("productManager");
             DBOrderManager ordManager = (DBOrderManager)session.getAttribute("ordManager");
             Validator validator = new Validator();
             Order order = null;
              int id = Integer.parseInt(request.getParameter("id"));
             String name = request.getParameter("name");
             String detail = request.getParameter("detail");
             String type = request.getParameter("type"); 
             double price = Double.parseDouble(request.getParameter("price"));
             int quantity = Integer.parseInt(request.getParameter("quantity"));
               validator.clear(session);
            
            
                     try {       
                         ordManager.addOrder(id, name, detail, quantity, price, type);
                         session.setAttribute("order", order);
                         response.sendRedirect("orderHistory.jsp");
                        
                     } catch (SQLException ex) {           
                           Logger.getLogger(AddProductServlet.class.getName()).log(Level.SEVERE, null, ex);       
                     }
             
            
      }
     }
