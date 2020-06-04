/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isd.wsd;

/**
 *
 * @author chris & lucas
 */
<<<<<<< HEAD
public class Staff {
    private String email;
    private String name;
    private String password;
    private String dob;
    private String phone;

    public Staff(String email, String name, String password, String phone, String dob) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.dob = dob;
        
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
=======
public class Staff extends User {

    public Staff(String email, String name, String password, String dob, String phone) {
        super(email, name, password, dob, phone);
    }

}
>>>>>>> 5bbc72751c30e956fe1fed2303de06a0cb7db626
