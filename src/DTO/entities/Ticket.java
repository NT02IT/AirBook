/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO.entities;

/**
 *
 * @author agond
 */
public class Ticket {
    protected String ticketID;
    protected String flightID;
    protected String gateID;
    protected String seatID;
    protected int importPrice;
    protected int sellingPrice;
    protected int soldout = 0;
    protected int isDelete = 0;

    public Ticket() {
    }

    public Ticket(String ticketID, String flightID, String gateID, String seatID, int importPrice, int sellingPrice) {
        this.ticketID = ticketID;
        this.flightID = flightID;
        this.gateID = gateID;
        this.seatID = seatID;
        this.importPrice = importPrice;
        this.sellingPrice = sellingPrice;
    }
    
    public String getTicketID() {
        return ticketID;
    }

    public String getFlightID() {
        return flightID;
    }

    public String getGateID() {
        return gateID;
    }

    public String getSeatID() {
        return seatID;
    }

    public int getImportPrice() {
        return importPrice;
    }

    public int getSellingPrice() {
        return sellingPrice;
    }

    public int getSoldout() {
        return soldout;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }

    public void setFlightID(String flightID) {
        this.flightID = flightID;
    }

    public void setGateID(String gateID) {
        this.gateID = gateID;
    }

    public void setSeatID(String seatID) {
        this.seatID = seatID;
    }

    public void setImportPrice(int importPrice) {
        this.importPrice = importPrice;
    }

    public void setSellingPrice(int sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public void setSoldout(int soldout) {
        this.soldout = soldout;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }
    
    public String getFlightIDGateID(){
        return this.flightID + this.gateID;
    }
    
    public void copyFrom(Ticket ticket){
        this.ticketID = ticket.getTicketID();
        this.flightID = ticket.getFlightID();
        this.gateID = ticket.getGateID();
        this.seatID = ticket.getSeatID();
        this.importPrice = ticket.getImportPrice();
        this.sellingPrice = ticket.getSellingPrice();
        this.soldout = ticket.getSoldout();
        this.isDelete = ticket.getIsDelete();
    }
}
