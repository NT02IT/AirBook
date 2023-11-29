/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO.entities;

import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author agond
 */
public abstract class Promotion {
    protected String promoID;
    protected String airlineID;
    protected String promoName;
    protected Date dateStart;
    protected Date dateEnd;
    protected int promoType;
    protected int decreased;
    protected int isDelete = 0;
    
    public abstract int reduce(int billValue);

    public Promotion() {
    }

    public Promotion(String promoID, String airlineID, String promoName, Date dateStart, Date dateEnd, int decreased) {
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

    public Date getDateStart() {
        return dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public int getDecreased() {
        return decreased;
    }

    public int getIsDelete() {
        return isDelete;
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

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public void setDecreased(int decreased) {
        this.decreased = decreased;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }
    
}
