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
public abstract class User {
    protected String userID;
    protected UserType userType;
    protected String username;
    protected String realName;
    protected Date userDoB;
    protected String userNationality;
    protected String userAddress;
    protected String CCCD;
    protected String pwd;
    protected String phoneNumber;
    protected String email;

    public User() {
    }
    
    public User(String userID, UserType userType, String username, String realName, Date userDoB, String userNationality, String userAddress, String CCCD, String pwd, String phoneNumber, String email) {
        this.userID = userID;
        this.userType = new UserType(userType);
        this.username = username;
        this.realName = realName;
        this.userDoB = userDoB;
        this.userNationality = userNationality;
        this.userAddress = userAddress;
        this.CCCD = CCCD;
        this.pwd = pwd;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getUserID() {
        return userID;
    }

    public UserType getUserType() {
        return userType;
    }

    public String getUsername() {
        return username;
    }

    public String getRealName() {
        return realName;
    }

    public Date getUserDoB() {
        return userDoB;
    }

    public String getUserNationality() {
        return userNationality;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public String getCCCD() {
        return CCCD;
    }

    public String getPwd() {
        return pwd;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setUserType(UserType userType) {
        this.userType = new UserType(userType);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public void setUserDoB(Date userDoB) {
        this.userDoB = userDoB;
    }

    public void setUserNationality(String userNationality) {
        this.userNationality = userNationality;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }    
}
