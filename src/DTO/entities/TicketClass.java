/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO.entities;

/**
 *
 * @author agond
 */
public class TicketClass {
    protected String ticketClassID;
    protected String planeID;
    protected String className;
    protected int seatsQuantity;
    protected int isDelete = 0;

    public TicketClass() {
    }

    public TicketClass(String ticketClassID, String planeID, String className, int seatsQuantity) {
        this.ticketClassID = ticketClassID;
        this.planeID = planeID;
        this.className = className;
        this.seatsQuantity = seatsQuantity;
    }

    public String getTicketClassID() {
        return ticketClassID;
    }

    public String getPlaneID() {
        return planeID;
    }

    public String getClassName() {
        return className;
    }

    public int getSeatsQuantity() {
        return seatsQuantity;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setTicketClassID(String ticketClassID) {
        this.ticketClassID = ticketClassID;
    }

    public void setPlaneID(String planeID) {
        this.planeID = planeID;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setSeatsQuantity(int seatsQuantity) {
        this.seatsQuantity = seatsQuantity;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }
    
}
