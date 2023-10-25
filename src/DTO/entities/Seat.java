/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO.entities;

/**
 *
 * @author agond
 */
public class Seat {
    protected String seatID;
    protected String ticketClassID;
    protected String seatName;

    public Seat() {
    }

    public Seat(String seatID, String ticketClassID, String seatName) {
        this.seatID = seatID;
        this.ticketClassID = ticketClassID;
        this.seatName = seatName;
    }

    public String getSeatID() {
        return seatID;
    }

    public String getTicketClassID() {
        return ticketClassID;
    }

    public String getSeatName() {
        return seatName;
    }

    public void setSeatID(String seatID) {
        this.seatID = seatID;
    }

    public void setTicketClassID(String ticketClassID) {
        this.ticketClassID = ticketClassID;
    }

    public void setSeatName(String seatName) {
        this.seatName = seatName;
    }
    
}
