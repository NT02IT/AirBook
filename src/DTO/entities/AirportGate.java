/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO.entities;

/**
 *
 * @author agond
 */
public class AirportGate {
    protected String gateID;
    protected String airportID;
    protected String gateName;

    public AirportGate() {
    }

    public AirportGate(String gateID, String airportID, String gateName) {
        this.gateID = gateID;
        this.airportID = airportID;
        this.gateName = gateName;
    }

    public String getGateID() {
        return gateID;
    }

    public String getAirportID() {
        return airportID;
    }

    public String getGateName() {
        return gateName;
    }

    public void setGateID(String gateID) {
        this.gateID = gateID;
    }

    public void setAirportID(String airportID) {
        this.airportID = airportID;
    }

    public void setGateName(String gateName) {
        this.gateName = gateName;
    }
    
}
