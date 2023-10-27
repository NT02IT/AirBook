/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.entities.TicketClass;
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
public class TicketClassDAO {
    protected ArrayList<TicketClass> list = new ArrayList<>();
    protected TicketClass ticketClass = new TicketClass();
    private ConnectDB connectDB;

    public TicketClassDAO() throws ClassNotFoundException, SQLException, IOException {
        connectDB = new ConnectDB();
        read();
    }

    public ArrayList<TicketClass> getList() {
        return list;
    }

    public ArrayList<TicketClass> read() throws IOException, ClassNotFoundException, SQLException{
        String context = this.getClass().getName();
        connectDB.connect(context);
        try {
            String sql = "Select * from ticket_classes";
            Statement stmt = connectDB.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                TicketClass ticketClass = new TicketClass();
                ticketClass.setTicketClassID(rs.getString(1));
                ticketClass.setPlaneID(rs.getString(2));
                ticketClass.setClassName(rs.getString(3));
                ticketClass.setSeatsQuantity(rs.getInt(4));
                ticketClass.setIsDelete(rs.getInt(5));
                list.add(ticketClass);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TicketClassDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        connectDB.disconnect(context);
        return list;
    }
    
    public boolean create(TicketClass ticketClass) throws ClassNotFoundException, SQLException {
        String context = this.getClass().getName();
        connectDB.connect(context);
        try {
            String sql = "INSERT INTO ticket_classes(Ticket_class_ID, Plane_ID, Class_name, Seats_quantity, IsDelete) "
                    + "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmt = connectDB.conn.prepareStatement(sql);
            pstmt.setString(1, ticketClass.getTicketClassID());
            pstmt.setString(2, ticketClass.getPlaneID());
            pstmt.setString(3, ticketClass.getClassName());
            pstmt.setInt(4, ticketClass.getSeatsQuantity());
            pstmt.setInt(5, ticketClass.getIsDelete());
            pstmt.executeUpdate();
            list.add(ticketClass);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TicketClassDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        connectDB.disconnect(context);
        return false;
    }
}
