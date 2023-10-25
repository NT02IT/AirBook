/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO.entities;

/**
 *
 * @author agond
 */
public class OrderDetail {
    protected String orderDetailID;
    protected String orderID;
    protected String moreLuggageID;
    protected String receiverID;
    protected String ticketID;

    public OrderDetail() {
    }

    public OrderDetail(String orderDetailID, String orderID, String moreLuggageID, String receiverID, String ticketID) {
        this.orderDetailID = orderDetailID;
        this.orderID = orderID;
        this.moreLuggageID = moreLuggageID;
        this.receiverID = receiverID;
        this.ticketID = ticketID;
    }

    public OrderDetail(String orderDetailID, String orderID, String receiverID, String ticketID) {
        this.orderDetailID = orderDetailID;
        this.orderID = orderID;
        this.receiverID = receiverID;
        this.ticketID = ticketID;
    }

    public String getOrderDetailID() {
        return orderDetailID;
    }

    public String getOrderID() {
        return orderID;
    }

    public String getMoreLuggageID() {
        return moreLuggageID;
    }

    public String getReceiverID() {
        return receiverID;
    }

    public String getTicketID() {
        return ticketID;
    }

    public void setOrderDetailID(String orderDetailID) {
        this.orderDetailID = orderDetailID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public void setMoreLuggageID(String moreLuggageID) {
        this.moreLuggageID = moreLuggageID;
    }

    public void setReceiverID(String receiverID) {
        this.receiverID = receiverID;
    }

    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }
    
}
