/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isd.wsd.dao;

import isd.wsd.Customer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author chris
 */
public class CustomerDBManager {

    private Statement st;

    public CustomerDBManager(Connection conn) throws SQLException {
        st = conn.createStatement();
    }

    //read
    public Customer findCustomer(String email, String password) throws SQLException {
        String read = "SELECT * FROM ISDSTAFF.CUSTOMERS WHERE CUSEMAIL = '" + email + "' AND CUSPASSWORD = '" + password + "'";
        ResultSet rs = st.executeQuery(read);

        while (rs.next()) {
            String customerEmail = rs.getString(1);
            String customerPass = rs.getString(3);
            if (customerEmail.equals(email) && customerPass.equals(password)) {
                String customerName = rs.getString(2);
                String customerPhone = rs.getString(4);
                String customerType = rs.getString(5);

                return new Customer(customerEmail, customerPass, customerName, customerPhone, customerType);
            }
        }

        return null;
    }

    //create
    public void addCustomer(String email, String name, String password, String phone, String type) throws SQLException {
        st.executeUpdate("INSERT INTO ISDSTAFF.CUSTOMERS " + "VALUES ('" + email + "', '" + name + "', '" + password + "', '" + phone + "', '" + type + "')");
    }

    //update
    public void updateCustomer(String email, String name, String password, String phone, String type) throws SQLException {
        st.executeUpdate("UPDATE ISDSTAFF.CUSTOMERS SET CUSNAME='" + name + "', CUSPASSWORD='" + password + "', CUSPHONE='" + phone + "', CUSTYPE='" + type + "' WHERE CUSEMAIL='" + email + "'");
    }

    //delete
    public void deleteCustomer(String email) throws SQLException {
        st.executeUpdate("DELETE FROM ISDSTAFF.CUSTOMERS WHERE CUSEMAIL='" + email + "'");
    }

    public ArrayList<Customer> fetchCustomer() throws SQLException {
        String fetch = "SELECT * FROM CUSTOMERS";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Customer> temp = new ArrayList();

        while (rs.next()) {
            String email = rs.getString(1);
            String name = rs.getString(2);
            String password = rs.getString(3);
            String phone = rs.getString(4);
            String customerType = rs.getString(5);
            temp.add(new Customer(email, name, password, phone, customerType));
        }
        return temp;
    }

    public boolean checkCustomer(String email, String password) throws SQLException {
        String fetch = "SELECT * FROM ISDSTAFF.CUSTOMERS WHERE CUSEMAIL = '" + email + "' AND CUSPASSWORD='" + password + "'";
        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            String customerEmail = rs.getString(1);
            String customerPass = rs.getString(3);
            if (customerEmail.equals(email) && customerPass.equals(password)) {
                return true;
            }
        }
        return false;
    }
}
