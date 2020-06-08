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
 * @author Sam
 */
public class ProductCollectionServlet extends HttpServlet {

    @Override   
     protected void doGet(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {       
             
            //Retrieve current session and retrieve manager instance from session
             HttpSession session = request.getSession();
             ProductDBManager productManager = (ProductDBManager)session.getAttribute("productManager");
             
             //Clear search and update messages
             session.setAttribute("productSearch", null);
             session.setAttribute("productUpdate", null);
             
             //Create instance of validator and reset
             Validator validator = new Validator();
             validator.clear(session);
             
             ArrayList<Product> products = new ArrayList();       
                     try {     
                         //Fetch all product in database
                         products = productManager.fetchProducts();
                     } catch (SQLException ex) {           
                           Logger.getLogger(ProductCollectionServlet.class.getName()).log(Level.SEVERE, null, ex);       
                     }
         
                if (!products.isEmpty()) {  
                    //If product list is not empty, save to session
                      session.setAttribute("products", products);
               } else {
                    //If product list is empty, set error message
                      session.setAttribute("productsErr", "Error: No Products Available");
               }   
                //Redirect to product collection page
               request.getRequestDispatcher("productCollection.jsp").include(request, response);
      }
     }
