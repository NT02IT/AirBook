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
    protected ArrayList<Person> list;    
    protected ArrayList<Person> searchList;

    protected Person user;
    private ConnectDB connectDB;

    public UserDAO() throws ClassNotFoundException, SQLException, IOException {
        connectDB = new ConnectDB();
        list = new ArrayList<>();
        
        user = new User();
        read();
    }

    public ArrayList<Person> getList() {
        return list;
    }

    public User getUser() {
        return (User)user;
    }

    public ArrayList<Person> read() throws IOException, ClassNotFoundException, SQLException{
        String context = this.getClass().getName();
        connectDB.connect(context);
        try {
            String sql = "Select * from users";
            Statement stmt = connectDB.conn.createStatement();
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
                user.setIsDelete(rs.getInt(14));
                list.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        connectDB.disconnect(context);
        return list;
    }
    
    public boolean create(User user) throws ClassNotFoundException, SQLException {
        String context = this.getClass().getName();
        connectDB.connect(context);
        try {
            String sql = "INSERT INTO users(User_ID, Role_ID, Username, Pwd, Real_name, DoB, Gender, Nation, User_address, Phone_number, CCCD, Email, Date_create, IsDelete) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = connectDB.conn.prepareStatement(sql);
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
            pstmt.setInt(14, user.getIsDelete());
            pstmt.executeUpdate();
            list.add(user);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        connectDB.disconnect(context);
        return false;
    }

    
    public boolean update(User user) throws SQLException {
        User tempUser = getObjectbyID(user.getID());
        
        String context = this.getClass().getName();
        connectDB.connect(context);
        try {
            String sql;
            if(user.getPwd().equals(tempUser.getPwd())){
                sql = "UPDATE users SET Role_ID = ?, Username = ?, Real_name = ?, DoB = ?, Gender = ?, Nation = ?, User_address = ?, Phone_number = ?, CCCD = ?, Email = ?, Date_create = ?, IsDelete = ? WHERE User_ID = ?;";
                PreparedStatement pstmt = connectDB.conn.prepareStatement(sql);
                pstmt.setString(1, user.getRoleID());
                pstmt.setString(2, user.getUsername());
                pstmt.setString(3, user.getName());
                java.sql.Timestamp doB = new java.sql.Timestamp(user.getDoB().getTime());
                pstmt.setTimestamp(4, doB);       
                pstmt.setString(5, user.getGender());
                pstmt.setString(6, user.getNation());
                pstmt.setString(7, user.getAddress());
                pstmt.setString(8, user.getPhoneNumber());
                pstmt.setString(9, user.getCCCD());
                pstmt.setString(10, user.getEmail());
                java.sql.Timestamp dateCreate = new java.sql.Timestamp(user.getDateCreate().getTime());
                pstmt.setTimestamp(11, dateCreate);
                pstmt.setInt(12, user.getIsDelete());
                pstmt.setString(13, user.getID());
                pstmt.executeUpdate();              
                list.set(getIndexbyID(user.getID()), user);
            }
            else{
                sql = "UPDATE users SET Role_ID = ?, Username = ?, Pwd = ?, Real_name = ?, DoB = ?, Gender = ?, Nation = ?, User_address = ?, Phone_number = ?, CCCD = ?, Email = ?, Date_create = ?, IsDelete = ? WHERE User_ID = ?;";
                PreparedStatement pstmt = connectDB.conn.prepareStatement(sql);
                pstmt.setString(1, user.getRoleID());
                pstmt.setString(2, user.getUsername());
                pstmt.setString(3, user.getPwd());
                pstmt.setString(4, user.getName());
                java.sql.Timestamp doB = new java.sql.Timestamp(user.getDoB().getTime());
                pstmt.setTimestamp(5, doB);       
                pstmt.setString(6, user.getGender());
                pstmt.setString(7, user.getNation());
                pstmt.setString(8, user.getAddress());
                pstmt.setString(9, user.getPhoneNumber());
                pstmt.setString(10, user.getCCCD());
                pstmt.setString(11, user.getEmail());
                java.sql.Timestamp dateCreate = new java.sql.Timestamp(user.getDateCreate().getTime());
                pstmt.setTimestamp(12, dateCreate);
                pstmt.setInt(13, user.getIsDelete());
                pstmt.setString(14, user.getID());
                pstmt.executeUpdate();              
                list.set(getIndexbyID(user.getID()), user);
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean delete(User data) throws SQLException {
        String context = this.getClass().getName();
        connectDB.connect(context);
        try {
            String sql = "UPDATE users SET IsDelete = 1 WHERE User_ID = ?;";
            PreparedStatement pstmt = ConnectDB.conn.prepareStatement(sql);
            pstmt.setString(1, data.getID());
            pstmt.executeUpdate();     
            list.remove(searchByID(data.getID()));
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<Person> search(String email,String name, String roleID ) throws IOException, ClassNotFoundException, SQLException{
        String context = this.getClass().getName();
        connectDB.connect(context);
        searchList = new ArrayList<>();
        try {
            String sql = "Select * from users ";
            boolean whereAdded = false; // Flag to track if "WHERE" clause is added
            if (!email.isEmpty()) {
                sql += " WHERE Email LIKE '%" + email + "%'";
                whereAdded = true;
            }
            if (!name.isEmpty()) {
                if (whereAdded) {
                    sql += " AND Real_name LIKE '%" + name + "%'";
                } else {
                    sql += " WHERE Real_name LIKE '%" + name + "%'";
                    whereAdded = true;
                }
            }
            if (!roleID.isEmpty()) {
                if (whereAdded) {
                    sql += " AND Role_ID  = '" + roleID + "'";
                } else {
                    sql += " WHERE Role_ID = '" + roleID + "'";
                }
            }
            Statement stmt = connectDB.conn.createStatement();
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
                user.setIsDelete(rs.getInt(14));
                searchList.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        connectDB.disconnect(context);
        return searchList;
    }
    public User getObjectbyID(String ID){
        for(Person u : list){
            if(ID.equals(u.getID())) return (User)u;
        }
        return null;
    }
    
    public int getIndexbyID(String ID){
        int i = 0;
        for(Person u : list){
            if(ID.equals(u.getID())) {
                return i;
            }
            i++;
        }
        return -1;
    }
   
    public User getByID (String userID) throws SQLException{
        String context = this.getClass().getName();
        connectDB.connect(context);
        User user = null;
        try {
            String sql = "Select * from users where User_ID = ?";
            PreparedStatement pstmt = connectDB.conn.prepareStatement(sql);
            pstmt.setString(1, userID);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()){
                user = new User();
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
                user.setIsDelete(rs.getInt(14));
                list.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        connectDB.disconnect(context);
        return user;
    }
    public int getTotalAccountByRoleID (String roleID) throws SQLException{
        String context = this.getClass().getName();
        connectDB.connect(context);
        int total = 0;
        String sql = "SELECT COUNT(*) AS TotalCount FROM users WHERE Role_ID = ?";
        PreparedStatement stmt = connectDB.conn.prepareStatement(sql);
        stmt.setString(1, roleID);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            total = rs.getInt("TotalCount");
        }
        connectDB.disconnect(context);
        return total;
        
    }
    public User getByUserName (String username) throws SQLException{
        String context = this.getClass().getName();
        connectDB.connect(context);
        User user = null;
        try {
            String sql = "Select * from users where Username = ?";
            PreparedStatement pstmt = connectDB.conn.prepareStatement(sql);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()){
                user = new User();
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
                user.setIsDelete(rs.getInt(14));
                list.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        connectDB.disconnect(context);
        return user;
    }
    public int searchByID(String ID) { // ID = MaKH
        int index = -1; // giá trị trả về mặc định nếu không tìm thấy
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getID().equals(ID)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public int countAccountsCreatedAfterDate() throws SQLException {
        int count = 0;
        String context = this.getClass().getName();
        connectDB.connect(context);
        try {
            String sql = "SELECT COUNT(*) FROM users WHERE Date_create > '2023-10-05 10:00:00' AND ROLE_ID = 'ROLE3'";
            PreparedStatement pstmt = connectDB.conn.prepareStatement(sql);
            ResultSet resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        } finally {
            connectDB.disconnect(context);
        }
        return count;
    }
    
}
