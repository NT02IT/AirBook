/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO.entities;

import java.time.LocalDateTime;

/**
 *
 * @author agond
 */
public class Order {
    protected String orderID;
    protected String userID;
    protected LocalDateTime dateOrder;

    public Order() {
    }

    public Order(String orderID, String userID, LocalDateTime dateOrder) {
        this.orderID = orderID;
        this.userID = userID;
        this.dateOrder = dateOrder;
    }

    public String getOrderID() {
        return orderID;
    }

    public String getUserID() {
        return userID;
    }

    public LocalDateTime getDateOrder() {
        return dateOrder;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setDateOrder(LocalDateTime dateOrder) {
        this.dateOrder = dateOrder;
    }
    
    public static String generateID(){
        long millis = System.currentTimeMillis();
        String time = String.valueOf(millis);
        String id = "OD" + time.substring(time.length()-8);
        return id;
    }
}
