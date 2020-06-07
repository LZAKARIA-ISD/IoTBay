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
public class Staff extends User {

    private String position;

    public Staff(String email, String password, String name, String phone, String position) {
        super(email, password, name, phone);
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

}
