/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

/**
 *
 * @author Sorakrit
 */
public class OrderUpdateServlet extends HttpServlet {

    @Override   
     protected void doPost(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {       
             
             HttpSession session = request.getSession();  
             ProductDBManager productManager = (ProductDBManager)session.getAttribute("productManager");
             DBOrderManager ordManager = (DBOrderManager)session.getAttribute("ordManager");
             Validator validator = new Validator();
             
             String id = request.getParameter("id");
             String name = request.getParameter("name");
             String detail = request.getParameter("detail");
             String type = request.getParameter("type"); 
             String price = request.getParameter("price");
             String quantity = request.getParameter("quantity");
             
            validator.clear(session);
            if (!validator.validateQuantity(quantity)) {
                 session.setAttribute("quantityErr", "Error: Incorrect quantity format");
                 session.setAttribute("productUpdate", "Update Unsuccessful");
                 request.getRequestDispatcher("orderEdit.jsp").include(request, response);
             
             } else {
                     try {       
                         productManager.updateProduct(id, name, detail, type, price, quantity);
                         session.setAttribute("productUpdate", "Update Successful");
                         response.sendRedirect("OrderEditServlet?id=" + id);
                     } catch (SQLException ex) {           
                           Logger.getLogger(AddProductServlet.class.getName()).log(Level.SEVERE, null, ex);       
                     }
             }
            
      }
     }
