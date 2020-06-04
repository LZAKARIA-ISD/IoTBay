/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isd.wsd;

/**
 *
 * @author lucas
 */
public class Customer {
    private String email;
    private String name;
    private String password;
    private String dob;
<<<<<<< HEAD
    private String phone;

    public Customer(String email, String name, String password, String phone, String dob) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.dob = dob;
        
=======
    private String gender;

    public Customer(String email, String name, String password, String dob, String gender) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.dob = dob;
        this.gender = gender;
>>>>>>> 5bbc72751c30e956fe1fed2303de06a0cb7db626
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

<<<<<<< HEAD
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
=======
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    
    
>>>>>>> 5bbc72751c30e956fe1fed2303de06a0cb7db626
}
