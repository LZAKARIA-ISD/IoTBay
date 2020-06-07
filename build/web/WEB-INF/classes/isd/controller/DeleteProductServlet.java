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
public class DeleteProductServlet extends HttpServlet {

    @Override   
     protected void doGet(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {       
             
             HttpSession session = request.getSession();   
             ProductDBManager productManager = (ProductDBManager)session.getAttribute("productManager");
             
             int id = Integer.parseInt(request.getParameter("id"));
                    
                     try {       
                         productManager.deleteProduct(id);
                     } catch (SQLException ex) {           
                           Logger.getLogger(DeleteProductServlet.class.getName()).log(Level.SEVERE, null, ex);       
                     }
         
         
               response.sendRedirect("ProductCollectionServlet");
      }
     }
