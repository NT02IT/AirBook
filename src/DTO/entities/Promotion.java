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
public abstract class Promotion {
    protected String promoID;
    protected String airlineID;
    protected String promoName;
    protected LocalDateTime dateStart;
    protected LocalDateTime dateEnd;
    protected int decreased;
    
    public abstract int reduce(int billValue);

    public Promotion() {
    }

    public Promotion(String promoID, String airlineID, String promoName, LocalDateTime dateStart, LocalDateTime dateEnd, int decreased) {
        this.promoID = promoID;
        this.airlineID = airlineID;
        this.promoName = promoName;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.decreased = decreased;
    }

    public String getPromoID() {
        return promoID;
    }

    public String getAirlineID() {
        return airlineID;
    }

    public String getPromoName() {
        return promoName;
    }

    public LocalDateTime getDateStart() {
        return dateStart;
    }

    public LocalDateTime getDateEnd() {
        return dateEnd;
    }

    public int getDecreased() {
        return decreased;
    }

    public void setPromoID(String promoID) {
        this.promoID = promoID;
    }

    public void setAirlineID(String airlineID) {
        this.airlineID = airlineID;
    }

    public void setPromoName(String promoName) {
        this.promoName = promoName;
    }

    public void setDateStart(LocalDateTime dateStart) {
        this.dateStart = dateStart;
    }

    public void setDateEnd(LocalDateTime dateEnd) {
        this.dateEnd = dateEnd;
    }

    public void setDecreased(int decreased) {
        this.decreased = decreased;
    }
    
}
