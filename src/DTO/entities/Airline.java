/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO.entities;

/**
 *
 * @author agond
 */
public class Airline {
    protected String airlineID;
    protected String airlineName;
    protected int isDelete = 0;

    public Airline() {
    }

    public Airline(String airlineID, String airlineName) {
        this.airlineID = airlineID;
        this.airlineName = airlineName;
    }

    public String getAirlineID() {
        return airlineID;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setAirlineID(String airlineID) {
        this.airlineID = airlineID;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }
    
}
