/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO.entities;

import java.util.Date;

/**
 *
 * @author agond
 */
public class Receiver extends Person{
    protected String userCreateID;

    public Receiver() {
    }

    public Receiver(String receiverID, String receiverName, String gender, Date doB, String receiverAddress, String nation, String phoneNumber, String CCCD, String email, String userCreateID) {
        super(receiverID, receiverName, gender, doB, receiverAddress, nation, phoneNumber, CCCD, email);
        this.userCreateID = userCreateID;
    }

    public Receiver(String receiverID, String receiverName, String gender, Date doB, String receiverAddress, String nation, String phoneNumber, String email, String userCreateID) {
        super(receiverID, receiverName, gender, doB, receiverAddress, nation, phoneNumber, email);
        this.userCreateID = userCreateID;
    }
    
    public Receiver(String receiverID, User user){
        super(receiverID, user.getName(), user.getGender(), user.getDoB(), user.getAddress(), user.getNation(), user.getPhoneNumber(), user.getCCCD(), user.getEmail());
        this.userCreateID = user.getID();
    }

    public String getUserID() {
        return userCreateID;
    }
    
    public void setUserID(String userCreateID) {
        this.userCreateID = userCreateID;
    }  
    
    public static String generateID(){
        long millis = System.currentTimeMillis();
        String time = String.valueOf(millis);
        String id = "REC" + time.substring(time.length()-8);
        return id;
    }
}
