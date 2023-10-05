/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO.entities;

/**
 *
 * @author agond
 */
public class UserType {
    public String userTypeID;
    public String userTypeName;

    public UserType() {
    }
    
    public UserType(UserType userType){
        this.userTypeID = userType.userTypeID;
        this.userTypeName = userType.userTypeName;
    }

    public UserType(String userTypeID, String userTypeName) {
        this.userTypeID = userTypeID;
        this.userTypeName = userTypeName;
    }
    
}
