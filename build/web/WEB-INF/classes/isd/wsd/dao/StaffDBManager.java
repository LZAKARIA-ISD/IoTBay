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

    public StaffDBManager(Connection conn) throws SQLException {
        st = conn.createStatement();
    }

    public Staff findStaff(String email, String password) throws SQLException {
        String read = "SELECT * FROM ISDSTAFF.STAFFS WHERE STAFFEMAIL=" + email + " AND STAFPASSWORD=" + password;
        ResultSet rs = st.executeQuery(read);

        while (rs.next()) {
            String staffEmail = rs.getString(1);
            String staffPass = rs.getString(3);
            if (staffEmail.equals(email) && staffPass.equals(password)) {
                String staffName = rs.getString(2);
                String staffPhone = rs.getString(4);
                String staffDOB = rs.getString(5);
                String staffPos = rs.getString(6);

                return new Staff(staffEmail, staffName, staffPass, staffPhone, staffDOB, staffPos);
            }
        }

        return null;
    }

    public void addStaff(String email, String name, String password, String phone, String dob) throws SQLException {
        st.executeUpdate("INSERT INTO ISDSTAFF.STAFFS " + "VALUES ('" + email + "', '" + name + "', '" + password + "', '" + phone + "', '" + dob + "')");
    }

    public void updateStaff(String email, String name, String password, String phone, String dob) throws SQLException {
        st.executeUpdate("UPDATE ISDSTAFF.STAFFS SET STAFFNAME='" + name + "', STAFFPASSWORD='" + password + "', STAFFPHONE='" + phone + "', STAFFDOB='" + dob + "' WHERE STAFFEMAIL='" + email + "'");
    }

    public void deleteStaff(String email) throws SQLException {
        st.executeUpdate("DELETE FROM ISDSTAFF.STAFFS WHERE STAFFEMAIL='" + email + "'");
    }

    public ArrayList<Staff> fetchStaff() throws SQLException {
        String fetch = "SELECT * FROM STAFFS";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Staff> temp = new ArrayList();

        while (rs.next()) {
            String email = rs.getString(1);
            String name = rs.getString(2);
            String password = rs.getString(3);
            String phone = rs.getString(4);
            String dob = rs.getString(5);
            String pos = rs.getString(6);
            temp.add(new Staff(email, name, password, phone, dob, pos));
        }
        return temp;
    }

    public boolean checkStaff(String email, String password) throws SQLException {
        String fetch = "SELECT * FROM ISDSTAFF.STAFFS WHERE STAFFEMAIL = '" + email + "' AND STAFFPASSWORD='" + password + "'";
        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            String staffEmail = rs.getString(1);
            String staffPass = rs.getString(3);
            if (staffEmail.equals(email) && staffPass.equals(password)) {
                return true;
            }
        }
        return false;
    }
}
