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

    private String name;
    private String phone;
    private String position;
    private String address;
    private boolean status;

    public Staff(String phone, String position, String address, boolean status, String username, String password) {
        super(username, password);
        this.phone = phone;
        this.position = position;
        this.address = address;
        this.status = status;
    }

}
