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
public abstract class User {

    private String email;
    private String password;
    private String name;
    private String phone;
    private Address address;

    public User(String email, String password, String name, String phone) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.address = new Address();
    }

    public boolean searchUser(String search) {
        String s = search.toLowerCase();
        return email.toLowerCase().contains(search) || name.toLowerCase().contains(search) || phone.toLowerCase().contains(search) || password.toLowerCase().contains(search);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(String stNo, String stType, String stAddr, String state, String postcode, String deliveryInstructions) {
        address.setStNo(stNo); //etc etc
    }
}
