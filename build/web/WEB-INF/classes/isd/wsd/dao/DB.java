package isd.wsd.dao;

import java.sql.Connection;

/**
 *
 * @author chris
 */
public abstract class DB {
    protected String URL = "jdbc:derby://localhost:1527/";
    protected String db = "IoTBayDB";
    protected String dbuser = "isdstaff";
    protected String dbpass = "admin";
    protected String driver = "org.apache.derby.jdbc.ClientDriver";
    protected Connection conn;
}
