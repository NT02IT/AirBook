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
    protected String promoID;
    protected LocalDateTime dateOrder;

    public Order() {
    }

    public Order(String orderID, String userID, String promoID, LocalDateTime dateOrder) {
        this.orderID = orderID;
        this.userID = userID;
        this.promoID = promoID;
        this.dateOrder = dateOrder;
    }

    public String getOrderID() {
        return orderID;
    }

    public String getUserID() {
        return userID;
    }

    public String getPromoID() {
        return promoID;
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

    public void setPromoID(String promoID) {
        this.promoID = promoID;
    }

    public void setDateOrder(LocalDateTime dateOrder) {
        this.dateOrder = dateOrder;
    }
    
}
