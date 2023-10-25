/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO.entities;

import assets.EnumCheck;
import assets.EnumCheck.NumbersValidStatus;
import assets.EnumCheck.ValidStatus;
import java.awt.Checkbox;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author agond
 */
public abstract class Person {
    protected String ID;
    protected String name;
    protected String gender;
    protected Date doB;
    protected String address;
    protected String nation;
    protected String phoneNumber;
    protected String CCCD;
    protected String email;

    public Person() {
    }

    public Person(String ID, String name, String gender, Date doB, String address, String nation, String phoneNumber, String CCCD, String email) {
        this.ID = ID;
        this.name = name;
        this.gender = gender;
        this.doB = doB;
        this.address = address;
        this.nation = nation;
        this.phoneNumber = phoneNumber;
        this.CCCD = CCCD;
        this.email = email;
    }

    public Person(String ID, String name, String gender, Date doB, String address, String nation, String phoneNumber, String email) {
        this.ID = ID;
        this.name = name;
        this.gender = gender;
        this.doB = doB;
        this.address = address;
        this.nation = nation;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    
    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public Date getDoB() {
        return doB;
    }

    public String getAddress() {
        return address;
    }

    public String getNation() {
        return nation;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCCCD() {
        return CCCD;
    }

    public String getEmail() {
        return email;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDoB(Date doB) {
        this.doB = doB;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static NumbersValidStatus checkPhoneValid(String phoneNum){
        if(phoneNum.length()>11) return NumbersValidStatus.VERYLONG;
        if(phoneNum.length()<9) return NumbersValidStatus.VERYSHORT;
        for(char c: phoneNum.toCharArray()){
            if(Character.isLetter(c)) return NumbersValidStatus.HASLETTER;
        }        
        return NumbersValidStatus.VALID;
    }
    
    public static NumbersValidStatus checkCCCDValid(String CCCD){
        if(CCCD.length()>11) return NumbersValidStatus.VERYLONG;
        if(CCCD.length()<11) return NumbersValidStatus.VERYSHORT;
        for(char c: CCCD.toCharArray()){
            if(Character.isLetter(c)) return NumbersValidStatus.HASLETTER;
        } 
        return NumbersValidStatus.VALID;
    }
    
    public static ValidStatus checkEmailValid(String email){
        int checkEmail = email.indexOf('@');
        if(checkEmail == -1) return ValidStatus.INVALID;
        else return ValidStatus.VALID;
    }
    
    public static String formatName(String name){
        if(name.equals("")) return "";
        
        name = name.trim();
        name = name.replaceAll(" +", " ");
        String output = "";
        String[] words = name.split(" ");
        for (String word : words) {
            output += word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase() + " ";
        }
        return output.trim();
    }
}
