/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.entities.Action;
import connection.ConnectDB;
import java.util.ArrayList;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author WIN 10
 */
public class ActionDAO {
    public static ArrayList<Action> list;
    private ConnectDB connectDB;
    protected Action action;
    
    public ActionDAO() throws ClassNotFoundException, SQLException, IOException {
        connectDB = new ConnectDB();
        list = new ArrayList<>();
        action = new Action();
        read();
    }

    public ArrayList<Action> getList() {
        return list;
    }

    public Action getAction() {
        return action;
    }
    public ArrayList<Action> read() throws IOException, ClassNotFoundException, SQLException{
        String context = this.getClass().getName();
        connectDB.connect(context);
        try {
            String sql = "Select * from actions";
            Statement stmt = connectDB.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Action action = new Action();
                action.setActionID(rs.getString(1));
                action.setActionName(rs.getString(2));
                action.setInfo(rs.getString(3));
                action.setIsDelete(rs.getInt(4));
                list.add(action);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        connectDB.disconnect(context);
        return list;
    }
    
    public boolean create(Action action) throws ClassNotFoundException, SQLException {
        String context = this.getClass().getName();
        connectDB.connect(context);
        try {
            String sql = "INSERT INTO actions(Action_ID,Action_name,Info,IsDelete) "
                    + "VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = connectDB.conn.prepareStatement(sql);
            pstmt.setString(1, action.getActionID());
            pstmt.setString(2, action.getActionName());
            pstmt.setString(3, action.getInfo());
            pstmt.setInt(4, action.getIsDelete());           
            pstmt.executeUpdate();
            list.add(action);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        connectDB.disconnect(context);
        return false;
    }
    public boolean update(Action action) throws SQLException {
            String context = this.getClass().getName();
            connectDB.connect(context);
            try {
                String sql = "UPDATE actions SET Action_Name = ? , Info = ?  "
                        + "WHERE Action_ID = ?";
                PreparedStatement pstmt = ConnectDB.conn.prepareStatement(sql);
                pstmt.setString(1, action.getActionName());
                pstmt.setString(2, action.getInfo());
                pstmt.setString(3, action.getActionID());
                pstmt.executeUpdate();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(PermissionDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            connectDB.disconnect(context);
            return false;
        }
    public boolean delete(Action action) throws SQLException{
        String context = this.getClass().getName();
        connectDB.connect(context);
        try {
            String sql = "UPDATE actions SET IsDelete = 1 WHERE Action_ID = ?";
            PreparedStatement pstmt = ConnectDB.conn.prepareStatement(sql);
            pstmt.setString(1, action.getActionID());
            pstmt.executeUpdate();        
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(RoleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }
}
