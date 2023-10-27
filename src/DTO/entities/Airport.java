/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO.entities;

/**
 *
 * @author agond
 */
public class Airport {
    protected String airportID;
    protected String airportName;
    protected String province;
    protected int isDelete = 0;

    public Airport() {
    }

    public Airport(String airportID, String airportName, String province) {
        this.airportID = airportID;
        this.airportName = airportName;
        this.province = province;
    }

    public String getAirportID() {
        return airportID;
    }

    public String getAirportName() {
        return airportName;
    }

    public String getProvince() {
        return province;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setAirportID(String airportID) {
        this.airportID = airportID;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }
    
}
