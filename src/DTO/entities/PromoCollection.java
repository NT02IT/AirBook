/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO.entities;

/**
 *
 * @author agond
 */
public class PromoCollection {
    private String Promo_collection_ID;
    private String User_ID;
    private String Promo_ID;
    
    public PromoCollection(){
    }

    public PromoCollection(String Promo_collection_ID, String User_ID, String Promo_ID) {
        this.Promo_collection_ID = Promo_collection_ID;
        this.User_ID = User_ID;
        this.Promo_ID = Promo_ID;
    }

    public String getPromo_collection_ID() {
        return Promo_collection_ID;
    }

    public void setPromo_collection_ID(String Promo_collection_ID) {
        this.Promo_collection_ID = Promo_collection_ID;
    }

    public String getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(String User_ID) {
        this.User_ID = User_ID;
    }

    public String getPromo_ID() {
        return Promo_ID;
    }

    public void setPromo_ID(String Promo_ID) {
        this.Promo_ID = Promo_ID;
    }
    
    public static String generateID(){
        long millis = System.currentTimeMillis();
        String time = String.valueOf(millis);
        String id = "PRC" + time.substring(time.length()-8);
        return id;
    }
    
}
