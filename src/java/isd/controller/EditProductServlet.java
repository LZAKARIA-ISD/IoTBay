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
             
             HttpSession session = request.getSession();   
             ProductDBManager productManager = (ProductDBManager)session.getAttribute("productManager");
            
             int id = Integer.parseInt(request.getParameter("id"));
             Product product = null;
                     try {       
                         product = productManager.findProduct(id);
                     } catch (SQLException ex) {           
                           Logger.getLogger(EditProductServlet.class.getName()).log(Level.SEVERE, null, ex);       
                     }
             if (product != null){
                 session.setAttribute("product", product);
                 request.getRequestDispatcher("editProduct.jsp").include(request, response);
             } else {
                 session.setAttribute("productErr", "Product does not exist");
                 request.getRequestDispatcher("ProductCollectionServlet").include(request, response);
             }
         
      }
     }