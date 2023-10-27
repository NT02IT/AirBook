/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO.entities;

/**
 *
 * @author agond
 */
public class Plane {
    protected String planeID;
    protected String airlineID;
    protected String planeName;
    protected int seats;
    protected String planeDesc;
    protected int isDelete;

    public Plane() {
    }

    public Plane(String planeID, String airlineID, String planeName, int seats, String planeDesc) {
        this.planeID = planeID;
        this.airlineID = airlineID;
        this.planeName = planeName;
        this.seats = seats;
        this.planeDesc = planeDesc;
    }

    public Plane(String planeID, String airlineID, String planeName, int seats) {
        this.planeID = planeID;
        this.airlineID = airlineID;
        this.planeName = planeName;
        this.seats = seats;
    }

    public String getPlaneID() {
        return planeID;
    }

    public String getAirlineID() {
        return airlineID;
    }

    public String getPlaneName() {
        return planeName;
    }

    public int getSeats() {
        return seats;
    }

    public String getPlaneDesc() {
        return planeDesc;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setPlaneID(String planeID) {
        this.planeID = planeID;
    }

    public void setAirlineID(String airlineID) {
        this.airlineID = airlineID;
    }

    public void setPlaneName(String planeName) {
        this.planeName = planeName;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public void setPlaneDesc(String planeDesc) {
        this.planeDesc = planeDesc;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }
    
}
