/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isd.controller;

/**
 *
 * @author chris
 */
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpSession;

public class Validator implements Serializable {

    private String emailPattern = "([a-zA-Z0-9]+)(([._-])([a-zA-Z0-9]+))*(@)([a-z]+)(.)([a-z]{3})((([.])[a-z]{0,2})*)";
    private String namePattern = "([A-Z][a-z]+[\\s])+[A-Z][a-z]*";
    private String passwordPattern = "[a-zA-Z0-9]{4,}";

    //Product Patterns
    private String productNamePattern = "[^\'\"]+";
    private String detailPattern = "[^\'\"]+";
    private String typePattern = "^[a-zA-Z\\s]+$";
    private String pricePattern = "^[0-9]{1,10}(.[0-9]{1,2})?$";
    private String quantityPattern = "^[0-9]{1,10}$";

    public Validator() {
    }

    public boolean validate(String pattern, String input) {
        Pattern regEx = Pattern.compile(pattern);
        Matcher match = regEx.matcher(input);

        return match.matches();
    }

    public boolean checkEmpty(String email, String password) {
        return email.isEmpty() || password.isEmpty();
    }

    public boolean validateEmail(String email) {
        return validate(emailPattern, email);
    }

    public boolean validateName(String name) {
        return validate(namePattern, name);
    }

    public boolean validatePassword(String password) {
        return validate(passwordPattern, password);
    }

    public boolean validateProductName(String name) {
        return validate(productNamePattern, name);
    }

    public boolean validateType(String type) {
        return validate(typePattern, type);
    }

    public boolean validateDetail(String detail) {
        return validate(detailPattern, detail);
    }

    public boolean validatePrice(String price) {
        return validate(pricePattern, price);
    }

    public boolean validateQuantity(String quantity) {
        return validate(quantityPattern, quantity);
    }

    public void clear(HttpSession session) {
        session.setAttribute("emailErr", "Enter email");
        session.setAttribute("passErr", "Enter password");
        session.setAttribute("existErr", "");
        session.setAttribute("nameErr", "Enter name");

        session.setAttribute("productNameErr", null);
        session.setAttribute("detailErr", null);
        session.setAttribute("typeErr", null);
        session.setAttribute("priceErr", null);
        session.setAttribute("quantityErr", null);
    }
}
