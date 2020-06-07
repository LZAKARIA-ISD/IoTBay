/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isd.wsd.dao;

import isd.wsd.Product;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Sam
 */
public class ProductDBManager {
private Statement st;
   
public ProductDBManager(Connection conn) throws SQLException {       
   st = conn.createStatement();   
}

//Find product by id  
public Product findProduct(int id) throws SQLException {       
    
   String fetch = "SELECT * FROM ISDSTAFF.PRODUCTS WHERE product_id=" + id;
    ResultSet rs = st.executeQuery(fetch);
  
    while(rs.next()){
        String name = rs.getString("name");
        String detail = rs.getString("detail");
        String type = rs.getString("type");
        double price = rs.getDouble("price");
        int quantity = rs.getInt("quantity");
        
        Product product = new Product(id, name, detail, type, price, quantity);
        return product;
    }
   return null;   
}

//Add a product into the database   
public void addProduct(String name, String detail, String type, String price, String quantity) throws SQLException {                         
  st.executeUpdate("INSERT INTO ISDSTAFF.PRODUCTS (NAME, DETAIL, TYPE, PRICE, QUANTITY) VALUES ('" + name + "', '" + detail + "', '" + type + "', " + price + ", " + quantity + ")");   

}

//update a product in the database   
public void updateProduct(String id, String name, String detail, String type, String price, String quantity) throws SQLException {        
   st.executeUpdate("UPDATE ISDSTAFF.PRODUCTS SET name='" + name + "', detail='" + detail + "', type='" + type + "', price=" + price + ", quantity=" + quantity + " WHERE product_id=" + id);
}       

//delete a product from the database   
public void deleteProduct(int id) throws SQLException{          
   st.executeUpdate("DELETE FROM ISDSTAFF.PRODUCTS WHERE product_id=" + id);
}

//search for a product in the database by name or type
public ArrayList<Product> searchProducts(String search) throws SQLException{
    String fetch = "SELECT * FROM ISDSTAFF.PRODUCTS WHERE LOWER(name) LIKE LOWER('%" + search + "%') OR LOWER(type) LIKE LOWER('%" + search + "%')";
    ResultSet rs = st.executeQuery(fetch);
    ArrayList<Product> temp = new ArrayList();
    
    while(rs.next()){
        int id = rs.getInt("product_id");
        String name = rs.getString("name");
        String detail = rs.getString("detail");
        String type = rs.getString("type");
        double price = rs.getDouble("price");
        int quantity = rs.getInt("quantity");
        
        temp.add(new Product(id, name, detail, type, price, quantity));
    }
    return temp;
}

//fetch all products from the database
public ArrayList<Product> fetchProducts() throws SQLException{
    String fetch = "SELECT * FROM ISDSTAFF.PRODUCTS";
    ResultSet rs = st.executeQuery(fetch);
    ArrayList<Product> temp = new ArrayList();
    
    while(rs.next()){
        int id = rs.getInt("product_id");
        String name = rs.getString("name");
        String detail = rs.getString("detail");
        String type = rs.getString("type");
        double price = rs.getDouble("price");
        int quantity = rs.getInt("quantity");
        
        temp.add(new Product(id, name, detail, type, price, quantity));
    }
    return temp;
}
}

