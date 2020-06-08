package isd.wsd.dao;

import java.sql.*;
import isd.wsd.Order;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import isd.wsd.Order;
/* 
* DBManager is the primary DAO class to interact with the database. 
* Complete the existing methods of this classes to perform CRUD operations with the db.
*/

public class DBOrderManager {

    private Statement st;
   
    public DBOrderManager(Connection conn) throws SQLException {       
        st = conn.createStatement();   
}

//Find uStser by email and password in the database   
 public Order findOrder(int ordId) throws SQLException {       
   String fetch= "SELECT * FROM ISDSTAFF.ORDERS WHERE ORDID="+ ordId ;
   ResultSet rs = st.executeQuery(fetch);
        
   // Read through each coloum
        while(rs.next()){
                int proId = rs.getInt("proId");
                String name = rs.getString("name");
                String detail = rs.getString("detail");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");
                String type = rs.getString("type");
                String ordDate = rs.getString("ordDate");
                String ordStatus = rs.getString("ordStatus");
                Order order = new Order( ordId, proId, name, detail, quantity, price, type, ordDate, ordStatus);
         return order; 
               
        }
        return null;
}

//Add a user-data into the database   
public void addOrder(int proId, String name, String detail, int quantity, double price, String type) throws SQLException {                   //code for add-operation       
 st.executeUpdate("INSERT INTO ISDSTAFF.ORDERS " + "VALUES ('" + proId + "','" + name + "', '" + detail + "', '" + quantity + "', '" + price +"', '" + type +"')");

}

//update a user details in the database   
public void updateOrder( int ordId, String name, String detail, String quantity, String price, String type, String ordDate) throws SQLException {       
  st.executeUpdate("UPDATE ISDSTAFF.ORDERS SET PRONAME =" + name + ", PRODETAIL =" + detail + ", PROQUANTITY =" + quantity + ", PROTYPE =" + type + ", ORDDATE =" + ordDate + "WHERE ORDID =" + ordId );
}       

//delete a user from the database   
public void cancelOrder(int ordId) throws SQLException{       
   st.executeUpdate("UPDATE ISDSTAFF.ORDERS SET ORDSTATUS = 'Cancelled' WHERE ORDID =" + ordId);

}
public void addBack(String ordStatus, int quantity) throws SQLException{       
   st.executeUpdate("UPDATE ISDSTAFF.PRODUCTS SET QUANTITY =" + quantity+ "WHERE ISDSTAFF.ORDERS.ORDSTATUS = 'Cancelled'");

}
// Order History by Id or Date

public ArrayList<Order> fectOrder() throws SQLException{
    String fetch = "Select * from ORDERS";
    ResultSet rs = st.executeQuery(fetch);
    ArrayList<Order> order = new ArrayList();
    
    while(rs.next()){
        int ordId = rs.getInt(1);
        int proId = rs.getInt(2);
        String name = rs.getString(3);
        String detail = rs.getString(4);
        int quantity = rs.getInt(5);
        double price = rs.getDouble(6);
        String type = rs.getString(7);
        String ordDate = rs.getString(8);
        String ordStatus = rs.getString(9);
        
        order.add(new Order(ordId, proId, name, detail, quantity, price, type, ordDate, ordStatus));
    }
    return order;
  }
public ArrayList<Order> searchOrder(String ordSearch) throws SQLException{
    String fetch = "SELECT * FROM ISDSTAFF.ORDERS WHERE LOWER(ordId) LIKE LOWER('%" + ordSearch + "%') OR LOWER(ordDate) LIKE LOWER('%" + ordSearch + "%')";
    ResultSet rs = st.executeQuery(fetch);
    ArrayList<Order> order = new ArrayList();
    
    while(rs.next()){
        int ordId = rs.getInt("ordId");
        int proId = rs.getInt("proId");
        String name = rs.getString("name");
        String detail = rs.getString("detail");
        int quantity = rs.getInt("quanity");
        double price = rs.getDouble("price");
        String type = rs.getString("type");
        String ordDate = rs.getString("ordDate");
        String ordStatus = rs.getString("ordStatus");
        
        order.add(new Order(ordId, proId, name, detail, quantity, price, type, ordDate, ordStatus));
    }
    return order;
}
}
