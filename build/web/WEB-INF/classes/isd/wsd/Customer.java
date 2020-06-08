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
public class Customer extends User {

    private String type;

    public Customer(String email, String password, String name, String phone, String type) {
        super(email, password, name, phone);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public boolean isIndividual() {
        return type.equals("individual");
    }

    public boolean isCompany() {
        return type.equals("company");
    }

    public void setType(String type) {
        this.type = type;
    }

}
