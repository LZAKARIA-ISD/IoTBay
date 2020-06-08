/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isd.wsd;

/**
 *
 * @author Sorakrit
 */
public class Order {
    private int ordId;
    private int proId;
    private String name;
    private String detail    ;
    private int quantity;
    private double price;
    private String type;
    private String ordDate;
    private String ordStatus;
    
    

    public Order(int ordId, int proId, String name, String detail, int quantity, double price, String type, String ordDate, String ordStatus) {
        this.ordId = ordId;
        this.proId = proId;
        this.name = name;
        this.detail = detail;
        this.quantity = quantity;
        this.price = price;
        this.type = type;
        this.ordDate = ordDate;
        this.ordStatus = ordStatus;
    }

   

    public int getId() {
        return ordId;
    }
    
    public int getProId() {
        return proId ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuan() {
        return quantity;
    }

    public void setQuan(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public String getOrdDate() {
        return ordDate;
    }

    public void setOrdDate(String ordDate) {
        this.ordDate = ordDate;
    }
    
      public String getOrdStatus() {
        return ordStatus;
    }

    public void setOrdStatus(String ordStatus) {
        this.ordStatus = ordStatus;
    }
    
}
