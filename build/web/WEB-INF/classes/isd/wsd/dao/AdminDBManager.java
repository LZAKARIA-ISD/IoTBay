/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isd.wsd.dao;

import isd.wsd.Admin;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author chris
 */
public class AdminDBManager {

    private Statement st;

    public AdminDBManager(Connection conn) throws SQLException {
        st = conn.createStatement();
    }

    public Admin findAdmin(String username, String password) throws SQLException {
        String read = "SELECT * FROM ISDSTAFF.ADMINUSERS WHERE USERNAME='" + username + "' AND PASSWORD='" + password + "'";
        ResultSet rs = st.executeQuery(read);

        while (rs.next()) {
            String adminUser = rs.getString(1);
            String adminPass = rs.getString(2);
            if (adminUser.equals(username) && adminPass.equals(password)) {
                return new Admin(adminUser, adminPass);
            }
        }

        return null;
    }

    public void addAdmin(String username, String password) throws SQLException {
        st.executeUpdate("INSERT INTO ISDSTAFF.ADMINUSERS " + "VALUES ('" + username + "', '" + password + "')");
    }

    public void updatePassword(String username, String password) throws SQLException {
        st.executeUpdate("UPDATE ISDSTAFF.ADMINUSERS SET PASSWORD='" + password + "' WHERE USERNAME='" + username + "'");
    }

    public void deleteAdmin(String username) throws SQLException {
        if (!username.equals("admin")) {
            st.executeUpdate("DELETE FROM ISDSTAFF.ADMINUSERS WHERE USERNAME='" + username + "'");
        }
    }

    public ArrayList<Admin> fetchAdmins() throws SQLException {
        String fetch = "SELECT * FROM ADMINUSERS";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Admin> temp = new ArrayList();

        while (rs.next()) {
            String username = rs.getString(1);
            String password = rs.getString(2);
            temp.add(new Admin(username, password));
        }
        return temp;
    }

    public boolean checkAdmin(String username, String password) throws SQLException {
        String fetch = "SELECT * FROM ISDSTAFF.ADMINUSERS WHERE USERNAME = '" + username + "' AND PASSWORD='" + password + "'";
        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            String adminUser = rs.getString(1);
            String adminPass = rs.getString(2);
            if (adminUser.equals(username) && adminPass.equals(password)) {
                return true;
            }
        }
        return false;
    }
}
