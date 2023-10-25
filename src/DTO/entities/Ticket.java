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
    protected int price;
    protected int soldout;

    public Ticket() {
    }

    public Ticket(String ticketID, String flightID, String gateID, String seatID, int price, int soldout) {
        this.ticketID = ticketID;
        this.flightID = flightID;
        this.gateID = gateID;
        this.seatID = seatID;
        this.price = price;
        this.soldout = soldout;
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

    public int getPrice() {
        return price;
    }

    public int getSoldout() {
        return soldout;
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

    public void setPrice(int price) {
        this.price = price;
    }

    public void setSoldout(int soldout) {
        this.soldout = soldout;
    }
    
}
