/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isd.wsd.dao;


import isd.wsd.Staff;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author chris
 */
public class StaffDBManager {
    private Statement st;
    
    public StaffDBManager (Connection conn) throws SQLException {
        st = conn.createStatement();
    }
    
    public Staff findStaff(String email, String password) throws SQLException {
        String read = "SELECT * FROM ISDSTAFF.Staff WHERE STAFFEMAIL="+email+" AND STAFPASSWORD="+password;
        ResultSet rs = st.executeQuery(read);
        
        while (rs.next()){
            String staffEmail = rs.getString(1);
            String staffPass = rs.getString(5);
            if (staffEmail.equals(email) && staffPass.equals(password)){
                String staffName = rs.getString(2);
                String staffGender = rs.getString(3);
                String staffDOB = rs.getString(4);
                
                return new Staff(staffEmail, staffName, staffPass, staffDOB, staffGender);
            }
        }
        
        return null;
    }
    
    public void addStaff(String email, String name, String password, String dob, String gender) throws SQLException {
        st.executeUpdate("INSERT INTO ISDSTAFF.STAFF " + "VALUES ('" + email +"', '" + name + "', '" + gender + "', '" + dob + "', '" + password + "')");
    }
    
    public void updateStaff(String email, String name, String password, String dob, String gender) throws SQLException {
        st.executeUpdate("UPDATE ISDSTAFF.STAFF SET STAFFNAME='" + name + "', STAFFPASSWORD='" + password + "', STAFFGENDER='" + gender + "', STAFFDOB='" + dob + "' WHERE STAFFEMAIL='" + email + "'");
    }
    
    public void deleteStaff(String email) throws SQLException {
        st.executeUpdate("DELETE FROM ISDSTAFF.STAFF WHERE STAFFEMAIL='" + email + "'");
    }
    
    public ArrayList<Staff> fetchStaff() throws SQLException {
        String fetch = "SELECT * FROM STAFF";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Staff> temp = new ArrayList();
        
        while (rs.next()){
            String email = rs.getString(1);
            String name = rs.getString(2);
            String dob = rs.getString(3);
            String gender = rs.getString(4);
            String password = rs.getString(5);
            temp.add(new Staff(email, name, password, dob, gender));
        }
        return temp;
    }
    
     public boolean checkStaff(String email, String password) throws SQLException {
        String fetch = "SELECT * FROM ISDSTAFF.STAFF WHERE STAFFEMAIL = '" + email + "' AND STAFFPASSWORD='" + password + "'";
        ResultSet rs = st.executeQuery(fetch);
        
        while (rs.next()){
            String staffEmail = rs.getString(2);
            String staffPass = rs.getString(3);
            if (staffEmail.equals(email) && staffPass.equals(password)) {
            return true;
            }
        }
        return false;
    }
}
