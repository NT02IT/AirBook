/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.entities.Person;
import DTO.entities.Receiver;
import java.util.ArrayList;
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
public class ReceiverDAO {
    protected ArrayList<Person> list;
    protected Person receiver;
    private ConnectDB connectDB;

    public ReceiverDAO() throws ClassNotFoundException, SQLException, IOException {
        connectDB = new ConnectDB();
        list = new ArrayList<>();
        receiver = new Receiver();
        read();
    }

    public ArrayList<Person> getList() {
        return list;
    }

    public Receiver getUser() {
        return (Receiver)receiver;
    }

    public ArrayList<Person> read() throws IOException, ClassNotFoundException, SQLException{
        String context = this.getClass().getName();
        connectDB.connect(context);
        try {
            String sql = "Select * from receivers";
            Statement stmt = connectDB.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Receiver receiver = new Receiver();
                receiver.setID(rs.getString(1));
                receiver.setName(rs.getString(2));
                receiver.setGender(rs.getString(3));
                receiver.setDoB(rs.getDate(4));
                receiver.setAddress(rs.getString(5));
                receiver.setNation(rs.getString(6));                
                receiver.setPhoneNumber(rs.getString(7));
                receiver.setCCCD(rs.getString(8));
                receiver.setEmail(rs.getString(9));
                receiver.setUserCreateID(rs.getString(10));
                receiver.setIsDelete(rs.getInt(11));
                list.add(receiver);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReceiverDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        connectDB.disconnect(context);
        return list;
    }
    
    public boolean create(Receiver receiver) throws ClassNotFoundException, SQLException {
        String context = this.getClass().getName();
        connectDB.connect(context);
        try {
            String sql = "INSERT INTO receivers(Receiver_ID, Receiver_name, Gender, DoB, Receiver_address, Nation, Phone_number, CCCD, Email, User_ID, IsDelete) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = connectDB.conn.prepareStatement(sql);
            pstmt.setString(1, receiver.getID());
            pstmt.setString(2, receiver.getName());
            pstmt.setString(3, receiver.getGender());
            java.sql.Timestamp doB = new java.sql.Timestamp(receiver.getDoB().getTime());
            pstmt.setTimestamp(4, doB);
            pstmt.setString(5, receiver.getAddress());              
            pstmt.setString(6, receiver.getNation());            
            pstmt.setString(7, receiver.getPhoneNumber());
            pstmt.setString(8, receiver.getCCCD());
            pstmt.setString(9, receiver.getEmail());
            pstmt.setString(10, receiver.getUserCreateID());
            pstmt.setInt(11, receiver.getIsDelete());
            pstmt.executeUpdate();
            list.add(receiver);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ReceiverDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        connectDB.disconnect(context);
        return false;
    }
}
