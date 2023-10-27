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

/**
 *
 * @author agond
 */
public class RoleDAO {
    public static Map<String, String> list = new HashMap<>();
    protected Role role;
    private ConnectDB connectDB;
    
    public RoleDAO() throws ClassNotFoundException, SQLException, IOException {
        connectDB = new ConnectDB();
        read();
    }
    
    public Map<String, String> getList() {
        return list;
    }
    
    public Map<String, String> read() throws IOException, ClassNotFoundException, SQLException{
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
                list.put(role.getRoleID(), role.getRoleName());
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
                    + "VALUES (?, ?, ?)";
            PreparedStatement pstmt = ConnectDB.conn.prepareStatement(sql);
            pstmt.setString(1, role.getRoleID());
            pstmt.setString(2, role.getRoleName());
            pstmt.setInt(3, role.getIsDelete());
            pstmt.executeUpdate();
            list.put(role.getRoleID(), role.getRoleName());
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(RoleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        connectDB.disconnect(context);
        return false;
    }
}
