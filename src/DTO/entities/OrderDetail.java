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
    protected String promoID;
    protected int notPaid;
    protected int isDelete;

    public OrderDetail() {
    }

    public OrderDetail(String orderDetailID, String orderID, String moreLuggageID, String receiverID, String ticketID, String promoID, int notPaid, int isDelete) {
        this.orderDetailID = orderDetailID;
        this.orderID = orderID;
        this.moreLuggageID = moreLuggageID;
        this.receiverID = receiverID;
        this.ticketID = ticketID;
        this.promoID = promoID;
        this.notPaid = notPaid;
        this.isDelete = isDelete;
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

    public String getPromoID() {
        return promoID;
    }

    public int getNotPaid() {
        return notPaid;
    }

    public int getIsDelete() {
        return isDelete;
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

    public void setPromoID(String promoID) {
        this.promoID = promoID;
    }

    public void setNotPaid(int notPaid) {
        this.notPaid = notPaid;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }    
    
    public static String generateID(){
        long millis = System.currentTimeMillis();
        String time = String.valueOf(millis);
        String id = "ODD" + time.substring(time.length()-8);
        return id;
    }
}
