/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO.entities;

import java.util.ArrayList;

/**
 *
 * @author agond
 */
public class Airline {
    protected String airlineID;
    protected String airlineName;
    protected int isDelete = 0;
    protected ArrayList<Plane> planes;
    protected ArrayList<Ticket> tickets;    
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
    
    public void setPlanes(ArrayList<Plane> planes) {
        this.planes = planes;
    }
    public ArrayList<Plane> getPlanes() {
        return planes;
    }    
    public int getTotalPlanesByAirlineID(String airlineID) {
        int totalPlanes = 0;
        //String airlineID = this.airlineID;
        System.out.println(airlineID);
        if (planes != null) {
            for (Plane plane : planes) {
                if (plane.getAirlineID().equals(airlineID)) {
                    totalPlanes++;
                }
            }
        }
        return totalPlanes;
    }

//    public double getTotalRevenueByAirlineID(String airlineID) {
//        double totalRevenue = 0;
//        if (tickets != null) {
//            for (Ticket ticket : tickets) {
//                if (ticket.getAirlineID().equals(airlineID)) {
//                    totalRevenue += ticket.getTicketPrice();
//                }
//            }
//        }
//        return totalRevenue;
//    }    
    
}
