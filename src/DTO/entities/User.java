/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO.entities;

import assets.EnumCheck.PwdValidStatus;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;

/**
 *
 * @author agond
 */
public class User extends Person{
    protected String roleID;    
    protected String username;
    protected String pwd;
    protected Date dateCreate;
    protected int isDelete = 0;

    public User() {
    }
    
    public User(User user){
        super(user.getID(), user.getName(), user.getGender(), user.getDoB(), user.getAddress(), user.getNation(), user.getPhoneNumber(), user.getCCCD(), user.getEmail());
        this.roleID = user.getRoleID();
        this.username = user.getUsername();
        this.pwd = user.getPwd();
        this.dateCreate = user.getDateCreate();
    }

    public User(String username, String pwd) {
        this.username = username;
        this.pwd = pwd;
    }

    public User(String roleID, String username, String pwd, Date dateCreate, String ID, String name, String gender, Date doB, String address, String nation, String phoneNumber, String CCCD, String email) {
        super(ID, name, gender, doB, address, nation, phoneNumber, CCCD, email);
        this.roleID = roleID;
        this.username = username;
        this.pwd = pwd;
        this.dateCreate = dateCreate;
    }

    public String getRoleID() {
        return roleID;
    }

    public String getUsername() {
        return username;
    }

    public String getPwd() {
        return pwd;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }
    
    // @Override
    // public String toString(){
    //     java.sql.Timestamp doB = new java.sql.Timestamp(this.doB.getTime());
    //     String sql ="INSERT INTO "
    //     + "users(User_ID, Role_ID, Username, Pwd, Real_name, DoB, Gender, Nation, User_address, Phone_number, CCCD, Email, Date_create) "
    //     + "VALUES "
    //     + "("
    //     + this.ID + this.roleID + this.username + this.pwd + this.name + doB + this.gender + this.nation + this.address + this.phoneNumber + this.CCCD + this.email + this.dateCreate
    //     + ")";
    //     return sql;
    // }
    
    public static String generateID(){
        long millis = System.currentTimeMillis();
        String time = String.valueOf(millis);
        String id = "AC" + time.substring(time.length()-8);
        return id;
    }
    
    public static String hashPassword(String password) throws NoSuchAlgorithmException {
        // Tạo một instance của MessageDigest với thuật toán SHA-256
        MessageDigest digest = MessageDigest.getInstance("SHA-256");

        // Tạo một byte array từ chuỗi mật khẩu
        byte[] bytes = password.getBytes(StandardCharsets.UTF_8);

        // Hash chuỗi mật khẩu
        byte[] hash = digest.digest(bytes);

        // Convert hash thành chuỗi thập lục phân
        String hashedPassword = Base64.getEncoder().encodeToString(hash);
        return hashedPassword;
    }
    
    public static PwdValidStatus checkPwdValid(String pwd){
        if(pwd.length()<8) return PwdValidStatus.VERYSHORT;
        
        boolean hasNumber = false;
        for(char c : pwd.toCharArray()){
            if(Character.isDigit(c)){
                hasNumber = true;
                break;
            }                
        }
        if(!hasNumber) return PwdValidStatus.MISSINGNUMBER;
        
        boolean hasLetter = false;
        for(char c: pwd.toCharArray()){
            if(Character.isLetter(c)){
                hasLetter = true;
                break;
            }
        }
        if(!hasLetter) return PwdValidStatus.MISSINGLETTER;
        return PwdValidStatus.VALID;
    }
}
