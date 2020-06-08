/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isd.wsd.dao;

import isd.wsd.TimeLog;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author chris
 */
public class TimeLogDBManager {
    
    private Statement st;

    public TimeLogDBManager(Connection conn) throws SQLException {
        st = conn.createStatement();
    }
    
    public TimeLog findTimeLog(String email) throws SQLException {
        String read = "SELECT * FROM ISDSTAFF.TIMELOG WHERE USEREMAIL='" + email + "'";
        ResultSet rs = st.executeQuery(read);

        while (rs.next()) {
            String userEmail = rs.getString(1);
            if (userEmail.equals(email)) {
                String loginTime = rs.getString(2);

                return new TimeLog (userEmail, loginTime);
            }
        }

        return null;
    }
    
    public void addTimeLog(String loginTime, String email) throws SQLException {
        st.executeUpdate("INSERT INTO ISDSTAFF.TIMELOG " + "VALUES ('" + loginTime + "', '" + email + "')");
    }
    
    public ArrayList<TimeLog> fetchTimeLog() throws SQLException {
        String fetch = "SELECT * FROM ISDSTAFF.TIMELOG";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<TimeLog> temp = new ArrayList();

        while (rs.next()) {
            String email = rs.getString(1);
            String loginTime = rs.getString(2);
            temp.add(new TimeLog(email, loginTime));
        }
        return temp;
    }
}
