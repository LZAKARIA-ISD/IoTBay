/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isd.controller;

import isd.wsd.dao.DBConnector;
import isd.wsd.dao.CustomerDBManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chris
 */
public class Temp {
    private static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) {

        try {

            DBConnector connector = new DBConnector();

            Connection conn = connector.openConnection();

            CustomerDBManager db = new CustomerDBManager(conn);

            System.out.print("User email: ");

            String email = in.nextLine();

            System.out.print("User name: ");

            String name = in.nextLine();

            System.out.print("User password: ");

            String password = in.nextLine();

<<<<<<< HEAD
<<<<<<< HEAD
            System.out.print("User phone: ");

            String phone = in.nextLine();
=======
            System.out.print("User gender: ");

            String gender = in.nextLine();
>>>>>>> 5bbc72751c30e956fe1fed2303de06a0cb7db626
=======
            System.out.print("User gender: ");

            String gender = in.nextLine();
>>>>>>> 5bbc72751c30e956fe1fed2303de06a0cb7db626

            System.out.print("User date of birth: ");

            String dob = in.nextLine();

<<<<<<< HEAD
<<<<<<< HEAD
            db.addCustomer(email, name, password, phone, dob);
=======
            db.addCustomer(email, name, gender, dob, password);
>>>>>>> 5bbc72751c30e956fe1fed2303de06a0cb7db626
=======
            db.addCustomer(email, name, gender, dob, password);
>>>>>>> 5bbc72751c30e956fe1fed2303de06a0cb7db626

            System.out.println("User is added to the database.");

            connector.closeConnection();

        } catch (ClassNotFoundException | SQLException ex) {

            Logger.getLogger(Temp.class.getName()).log(Level.SEVERE, null, ex);

        }

    }
}
