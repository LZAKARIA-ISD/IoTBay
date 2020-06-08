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
public class SearchProductsServlet extends HttpServlet {

    @Override   
     protected void doGet(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {       
             
             //Retrieve current session and retrieve manager instance from session
             HttpSession session = request.getSession();  
             ProductDBManager productManager = (ProductDBManager)session.getAttribute("productManager");
             
             //Capture search query from request
             String search = request.getParameter("productSearch"); 
             ArrayList<Product> products = new ArrayList(); 
             
                     try {   
                         //Find all products that contain search query in product name or type
                         products = productManager.searchProducts(search);
                     } catch (SQLException ex) {           
                           Logger.getLogger(ProductCollectionServlet.class.getName()).log(Level.SEVERE, null, ex);       
                     }
         
                if (products != null) {  
                    //If products are found, save list of products and search query in session
                      session.setAttribute("products", products);
                      session.setAttribute("productSearch", search);
               } else {  
                    //If no products found, set error message
                      session.setAttribute("searchErr", "Error: No Products");
               }   
                //Redirect to product collection page
               request.getRequestDispatcher("productCollection.jsp").include(request, response);
      }
     }