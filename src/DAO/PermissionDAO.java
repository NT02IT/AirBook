/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.entities.Permission;
import connection.ConnectDB;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author agond
 */
public class PermissionDAO {
    protected ArrayList<Permission> list;
    protected Permission per;
    private ConnectDB connectDB;
    
    public PermissionDAO() throws ClassNotFoundException, SQLException, IOException {
        ConnectDB connectDB = new ConnectDB();
        list = new ArrayList<>();
        per = new Permission();
        read();
    }
    
    public ArrayList<Permission> getList() {
        return list;
    }
    
    public ArrayList<Permission> read() throws IOException, ClassNotFoundException, SQLException{
        String context = this.getClass().getName();
        connectDB.connect(context);
        try {
            String sql = "Select * from permission";
            Statement stmt = ConnectDB.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Permission per = new Permission();
                per.setPerID(rs.getString(1));
                per.setRoleID(rs.getString(2));
                per.setActionID(rs.getString(3));
                per.setPerAccess(rs.getInt(4));
                per.setPerCreate(rs.getInt(5));
                per.setPerView(rs.getInt(6));
                per.setPerEdit(rs.getInt(7));
                per.setPerDelete(rs.getInt(8));  
                per.setIsDelete(rs.getInt(9));       
                list.add(per);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PermissionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        connectDB.disconnect(context);
        return list;
    }
    
    public boolean create(Permission per) throws SQLException {
        String context = this.getClass().getName();
        connectDB.connect(context);
        try {
            String sql = "INSERT INTO permission(Per_ID, Role_ID, Action_ID, Per_access, Per_create, Per_view, Per_edit, Per_delete, IsDelete) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = ConnectDB.conn.prepareStatement(sql);
            pstmt.setString(1, per.getPerID());
            pstmt.setString(2, per.getRoleID());
            pstmt.setString(3, per.getActionID());
            pstmt.setInt(4, per.getPerAccess());
            pstmt.setInt(5, per.getPerCreate());            
            pstmt.setInt(6, per.getPerView());            
            pstmt.setInt(7, per.getPerEdit());
            pstmt.setInt(8, per.getPerDelete());
            pstmt.setInt(9, per.getIsDelete());
            pstmt.executeUpdate();
            list.add(per);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PermissionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        connectDB.disconnect(context);
        return false;
    }
}
