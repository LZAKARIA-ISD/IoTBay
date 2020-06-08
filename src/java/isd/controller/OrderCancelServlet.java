package isd.controller;

import isd.wsd.dao.DBOrderManager;
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

/**
 *
 * @author Sorakrit
 */
public class OrderCancelServlet extends HttpServlet {
    @Override   
     protected void doGet(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {       
             
             HttpSession session = request.getSession();   
             DBOrderManager ordManager = (DBOrderManager)session.getAttribute("ordManager");
             
             int ordId = Integer.parseInt(request.getParameter("ordId"));
                    
                     try {       
                         ordManager.cancelOrder(ordId);
                     } catch (SQLException ex) {           
                           Logger.getLogger(DeleteProductServlet.class.getName()).log(Level.SEVERE, null, ex);       
                     }
                    response.sendRedirect("OrderHistory.jsp");
      
     }
}
