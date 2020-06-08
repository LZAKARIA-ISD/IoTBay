/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isd.controller;

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
 * @author Sam
 */
public class AddProductServlet extends HttpServlet {

    @Override   
     protected void doPost(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {       
             
            //Retrieve current session and retrieve manager instance from session
             HttpSession session = request.getSession();
             ProductDBManager productManager = (ProductDBManager)session.getAttribute("productManager");
             //Create instance of the validator
             Validator validator = new Validator();
             
             //Capture product attributes from request
             String name = request.getParameter("name");
             String detail = request.getParameter("detail");
             String type = request.getParameter("type"); 
             String price = request.getParameter("price");
             String quantity = request.getParameter("quantity");
             
             //Reset validator
             validator.clear(session);
             
             //Validate inputs from user for product, send error if format is incorrect
             if (!validator.validatePrice(price)) {
                 session.setAttribute("priceErr", "Error: Incorrect price format");
                 request.getRequestDispatcher("addProduct.jsp").include(request, response);
             } else if (!validator.validateQuantity(quantity)) {
                 session.setAttribute("quantityErr", "Error: Incorrect quantity format");
                 request.getRequestDispatcher("addProduct.jsp").include(request, response);
             } else if (!validator.validateProductName(name)) {
                 session.setAttribute("nameErr", "Error: Incorrect name format");
                 request.getRequestDispatcher("addProduct.jsp").include(request, response);
             } else if (!validator.validateDetail(detail)) {
                 session.setAttribute("detailErr", "Error: Incorrect detail format");
                 request.getRequestDispatcher("addProduct.jsp").include(request, response);
             } else if (!validator.validateType(type)) {
                 session.setAttribute("typeErr", "Error: Incorrect type format");
                 request.getRequestDispatcher("addProduct.jsp").include(request, response);
             } else {
                     try {  
                         //Add product to database if no formatting errors
                         productManager.addProduct(name, detail, type, price, quantity);
                     } catch (SQLException ex) {           
                           Logger.getLogger(AddProductServlet.class.getName()).log(Level.SEVERE, null, ex);       
                     }
                //Redirect to Product Collection Servlet to list updated list of products
                response.sendRedirect("ProductCollectionServlet");
             }
      }
     }
