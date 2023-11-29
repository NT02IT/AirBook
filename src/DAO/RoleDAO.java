/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.entities.Role;
import connection.ConnectDB;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.ArrayList;

/**
 *
 * @author agond
 */
public class RoleDAO {
    public static ArrayList<Role> list;

    protected Role role;
    private ConnectDB connectDB;
    
    public RoleDAO() throws ClassNotFoundException, SQLException, IOException {
        connectDB = new ConnectDB();
        list = new ArrayList<>();
        read();
    }
    
    public ArrayList<Role> getList() {
        return list;
    }
    
    public ArrayList<Role> read() throws IOException, ClassNotFoundException, SQLException{
        String context = this.getClass().getName();
        connectDB.connect(context);
        try {
            String sql = "Select * from roles";
            Statement stmt = ConnectDB.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Role role = new Role();
                role.setRoleID(rs.getString(1));
                role.setRoleName(rs.getString(2));     
                role.setIsDelete(rs.getInt(3));     
                list.add(role);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        connectDB.disconnect(context);
        return list;
    }
    
    public boolean create(Role role) throws SQLException {
        String context = this.getClass().getName();
        connectDB.connect(context);
        try {
            String sql = "INSERT INTO roles(Role_ID, Role_name, IsDelete) "
                    + "VALUES (?, ?, 0)";
            PreparedStatement pstmt = ConnectDB.conn.prepareStatement(sql);
            pstmt.setString(1, role.getRoleID());
            pstmt.setString(2, role.getRoleName());
            pstmt.executeUpdate();
            list.add(role);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(RoleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        connectDB.disconnect(context);
        return false;
    }
    public boolean delete(Role role) throws SQLException{
        String context = this.getClass().getName();
        connectDB.connect(context);
        try {
            String sql = "UPDATE roles SET IsDelete = 1 WHERE Role_ID = ?";
            PreparedStatement pstmt = ConnectDB.conn.prepareStatement(sql);
            pstmt.setString(1, role.getRoleID());
            pstmt.executeUpdate();        
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(RoleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }
    
}
