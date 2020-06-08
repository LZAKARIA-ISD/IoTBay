/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isd.controller;

import isd.wsd.Product;
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
public class EditProductServlet extends HttpServlet {

    @Override   
     protected void doGet(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {       
             
            //Retrieve current session and retrieve manager instance from session
             HttpSession session = request.getSession();   
             ProductDBManager productManager = (ProductDBManager)session.getAttribute("productManager");
            
             //Capture product ID from request
             int id = Integer.parseInt(request.getParameter("id"));
             Product product = null;
                     try {   
                         //Find product in database by ID
                         product = productManager.findProduct(id);
                     } catch (SQLException ex) {           
                           Logger.getLogger(EditProductServlet.class.getName()).log(Level.SEVERE, null, ex);       
                     }
             if (product != null){
                 //If product is found, save to session and redirect user to edit page
                 session.setAttribute("product", product);
                 request.getRequestDispatcher("editProduct.jsp").include(request, response);
             } else {
                 //If product is not found, set productErr message and redirect to product collection page
                 session.setAttribute("productErr", "Product does not exist");
                 response.sendRedirect("ProductCollectionServlet");
             }
         
      }
     }