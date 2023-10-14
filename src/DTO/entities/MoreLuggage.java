/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO.entities;

/**
 *
 * @author agond
 */
public class MoreLuggage {
    protected String moreLuggageID;
    protected String airlineID;
    protected int luggageWeight;
    protected int price;

    public MoreLuggage() {
    }

    public MoreLuggage(String moreLuggageID, String airlineID, int luggageWeight, int price) {
        this.moreLuggageID = moreLuggageID;
        this.airlineID = airlineID;
        this.luggageWeight = luggageWeight;
        this.price = price;
    }

    public String getMoreLuggageID() {
        return moreLuggageID;
    }

    public String getAirlineID() {
        return airlineID;
    }

    public int getLuggageWeight() {
        return luggageWeight;
    }

    public int getPrice() {
        return price;
    }

    public void setMoreLuggageID(String moreLuggageID) {
        this.moreLuggageID = moreLuggageID;
    }

    public void setAirlineID(String airlineID) {
        this.airlineID = airlineID;
    }

    public void setLuggageWeight(int luggageWeight) {
        this.luggageWeight = luggageWeight;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
}
