/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO.entities;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author agond
 */
public class Receiver extends Person{
    protected String userCreateID;
    protected int isDelete = 0;

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
    
    public Receiver(User user){
        super(user.getName(), user.getGender(), user.getDoB(), user.getAddress(), user.getNation(), user.getPhoneNumber(), user.getCCCD(), user.getEmail());
        this.userCreateID = user.getID();
        super.setID(generateID());
    }

    public String getUserCreateID() {
        return userCreateID;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setUserCreateID(String userCreateID) {
        this.userCreateID = userCreateID;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }
    
    public static String generateID(){
        long millis = System.currentTimeMillis();
        String time = String.valueOf(millis);
        String id = "REC" + time.substring(time.length()-8);
        return id;
    }
}
