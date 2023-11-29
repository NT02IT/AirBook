/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO.entities;

import assets.EnumCheck.DiscountType;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author agond
 */
public class FlatDiscount extends Promotion{
    public static final DiscountType type = DiscountType.FLAT;

    public FlatDiscount() {
    }

    public FlatDiscount(String promoID, String airlineID, String promoName, Date dateStart, Date dateEnd, int decreased) {
        super(promoID, airlineID, promoName, dateStart, dateEnd, decreased);
    }
    
    public int reduce(int billValue){
        if (decreased < billValue) {
            return decreased;
        }
        else return billValue;
    }
}
