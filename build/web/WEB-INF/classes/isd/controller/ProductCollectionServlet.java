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
             
             HttpSession session = request.getSession();
             ProductDBManager productManager = (ProductDBManager)session.getAttribute("productManager");
             session.setAttribute("productSearch", null);
             session.setAttribute("productUpdate", null);
             Validator validator = new Validator();
             validator.clear(session);
             
             ArrayList<Product> products = new ArrayList();       
                     try {       
                         products = productManager.fetchProducts();
                     } catch (SQLException ex) {           
                           Logger.getLogger(ProductCollectionServlet.class.getName()).log(Level.SEVERE, null, ex);       
                     }
         
                if (products != null) {                                
                      session.setAttribute("products", products);
               } else {                                  
                      session.setAttribute("productsErr", "Error: No Products");
               }   
               request.getRequestDispatcher("productCollection.jsp").include(request, response);
      }
     }
