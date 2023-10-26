/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.entities.Ticket;
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
public class TicketDAO {
    protected ArrayList<Ticket> list = new ArrayList<>();
    protected Ticket ticket = new Ticket();
    private ConnectDB connectDB;

    public TicketDAO() throws ClassNotFoundException, SQLException, IOException {
        connectDB = new ConnectDB();
        read();
    }

    public ArrayList<Ticket> getList() {
        return list;
    }

    public ArrayList<Ticket> read() throws IOException, ClassNotFoundException, SQLException{
        String context = this.getClass().getName();
        connectDB.connect(context);
        try {
            String sql = "Select * from tickets";
            Statement stmt = connectDB.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Ticket ticket = new Ticket();
                ticket.setTicketID(rs.getString(1));
                ticket.setFlightID(rs.getString(2));
                ticket.setGateID(rs.getString(3));
                ticket.setSeatID(rs.getString(4));
                ticket.setPrice(rs.getInt(5));
                ticket.setSoldout(rs.getInt(6));
                list.add(ticket);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TicketDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        connectDB.disconnect(context);
        return list;
    }
    
    public boolean create(Ticket ticket) throws ClassNotFoundException, SQLException {
        String context = this.getClass().getName();
        connectDB.connect(context);
        try {
            String sql = "INSERT INTO tickets(Ticket_ID, Flight_ID, Gate_ID, Seat_ID, Price, Sold_out) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = connectDB.conn.prepareStatement(sql);
            pstmt.setString(1, ticket.getTicketID());
            pstmt.setString(2, ticket.getFlightID());
            pstmt.setString(3, ticket.getGateID());
            pstmt.setString(4, ticket.getSeatID());
            pstmt.setInt(5, ticket.getPrice());            
            pstmt.setInt(6, ticket.getSoldout()); 
            pstmt.executeUpdate();
            list.add(ticket);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TicketDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        connectDB.disconnect(context);
        return false;
    }
}
