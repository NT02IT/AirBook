/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.entities.Person;
import java.util.ArrayList;
import DTO.entities.User;
import connection.ConnectDB;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author agond
 */
public class UserDAO {
    protected ArrayList<Person> list = new ArrayList<>();
    protected Person user = new User();

    public UserDAO() throws ClassNotFoundException, SQLException, IOException {
        ConnectDB connectDB = new ConnectDB();
        read();
    }

    public ArrayList<Person> getList() {
        return list;
    }

    public User getUser() {
        return (User)user;
    }

    public ArrayList<Person> read() throws IOException, ClassNotFoundException{
        try {
            String sql = "Select * from users";
            Statement stmt = ConnectDB.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                User user = new User();
                user.setID(rs.getString(1));
                user.setRoleID(rs.getString(2));
                user.setUsername(rs.getString(3));
                user.setPwd(rs.getString(4));
                user.setName(rs.getString(5));
                user.setDoB(rs.getDate(6));
                user.setGender(rs.getString(7));
                user.setNation(rs.getString(8));
                user.setAddress(rs.getString(9));
                user.setPhoneNumber(rs.getString(10));
                user.setCCCD(rs.getString(11));
                user.setEmail(rs.getString(12));
                user.setDateCreate(rs.getDate(13));
                list.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public boolean create(User user) {
        try {
            String sql = "INSERT INTO users(User_ID, Role_ID, Username, Pwd, Real_name, DoB, Gender, Nation, User_address, Phone_number, CCCD, Email, Date_create) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = ConnectDB.conn.prepareStatement(sql);
            pstmt.setString(1, user.getID());
            pstmt.setString(2, user.getRoleID());
            pstmt.setString(3, user.getUsername());
            pstmt.setString(4, user.getPwd());
            pstmt.setString(5, user.getName());            
            java.sql.Timestamp doB = new java.sql.Timestamp(user.getDoB().getTime());
            pstmt.setTimestamp(6, doB);            
            pstmt.setString(7, user.getGender());
            pstmt.setString(8, user.getNation());
            pstmt.setString(9, user.getAddress());
            pstmt.setString(10, user.getPhoneNumber());
            pstmt.setString(11, user.getCCCD());
            pstmt.setString(12, user.getEmail());
            java.sql.Timestamp dateCreate = new java.sql.Timestamp(user.getDateCreate().getTime());
            pstmt.setTimestamp(13, dateCreate);
            pstmt.executeUpdate();
            list.add(user);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
