/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO.entities;

import java.time.LocalDateTime;

/**
 *
 * @author agond
 */
public class Flight {
    protected String flightID;
    protected String flyingFrom;
    protected String flyingTo;
    protected int hoursFly;
    protected LocalDateTime departureFlight;

    public Flight() {
    }

    public Flight(String flightID, String flyingFrom, String flyingTo, int hoursFly, LocalDateTime departureFlight) {
        this.flightID = flightID;
        this.flyingFrom = flyingFrom;
        this.flyingTo = flyingTo;
        this.hoursFly = hoursFly;
        this.departureFlight = departureFlight;
    }

    public String getFlightID() {
        return flightID;
    }

    public String getFlyingFrom() {
        return flyingFrom;
    }

    public String getFlyingTo() {
        return flyingTo;
    }

    public int getHoursFly() {
        return hoursFly;
    }

    public LocalDateTime getDepartureFlight() {
        return departureFlight;
    }

    public void setFlightID(String flightID) {
        this.flightID = flightID;
    }

    public void setFlyingFrom(String flyingFrom) {
        this.flyingFrom = flyingFrom;
    }

    public void setFlyingTo(String flyingTo) {
        this.flyingTo = flyingTo;
    }

    public void setHoursFly(int hoursFly) {
        this.hoursFly = hoursFly;
    }

    public void setDepartureFlight(LocalDateTime departureFlight) {
        this.departureFlight = departureFlight;
    }
    
}
