/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.entities.Ticket;
import DTO.entities.User;
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
    protected static ArrayList<Ticket> list;
    protected ArrayList<Ticket> upcomingTickets;
    protected Ticket ticket;
    private ConnectDB connectDB;

    public TicketDAO() throws ClassNotFoundException, SQLException, IOException {
        connectDB = new ConnectDB();
        list = new ArrayList<>();
        upcomingTickets = new ArrayList<>();
        ticket = new Ticket();
        read();
    }

    public ArrayList<Ticket> getList() {
        for(Ticket tk : list){
            System.out.println(tk.getTicketID());
        }
        return list;
    }
    
    public ArrayList<Ticket> getUpcomingList() {
        for(Ticket tk : upcomingTickets){
            System.out.println(tk.getTicketID());
        }
        return upcomingTickets;
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
                ticket.setImportPrice(rs.getInt(5));
                ticket.setSellingPrice(rs.getInt(6));
                ticket.setSoldout(rs.getInt(7));
                ticket.setIsDelete(rs.getInt(8));
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
            String sql = "INSERT INTO tickets(Ticket_ID, Flight_ID, Gate_ID, Seat_ID, Import_price, Selling_price, Sold_out, IsDelete) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = connectDB.conn.prepareStatement(sql);
            pstmt.setString(1, ticket.getTicketID());
            pstmt.setString(2, ticket.getFlightID());
            pstmt.setString(3, ticket.getGateID());
            pstmt.setString(4, ticket.getSeatID());
            pstmt.setInt(5, ticket.getImportPrice());   
            pstmt.setInt(6, ticket.getSellingPrice());   
            pstmt.setInt(7, ticket.getSoldout()); 
            pstmt.setInt(8, ticket.getIsDelete()); 
            pstmt.executeUpdate();
            list.add(ticket);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TicketDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        connectDB.disconnect(context);
        return false;
    }
    
    public Ticket getObjectByFlightIDSeatID(String FlightID, String SeatID) throws SQLException{
        String context = this.getClass().getName();
        connectDB.connect(context);
        try {
            String sql = "Select * from tickets, flights, seats "
                    + "Where tickets.Seat_ID=seats.Seat_ID "
                    + "AND tickets.Flight_ID=flights.Flight_ID";
            Statement stmt = connectDB.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Ticket ticket = new Ticket();
                ticket.setTicketID(rs.getString(1));
                ticket.setFlightID(rs.getString(2));
                ticket.setGateID(rs.getString(3));
                ticket.setSeatID(rs.getString(4));
                ticket.setImportPrice(rs.getInt(5));
                ticket.setSellingPrice(rs.getInt(6));
                ticket.setSoldout(rs.getInt(7));
                ticket.setIsDelete(rs.getInt(8));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TicketDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        connectDB.disconnect(context);
        return ticket;
    }
    
    public ArrayList<Ticket> setSoldout(String ID) throws ClassNotFoundException, SQLException, IOException {
        String context = this.getClass().getName();
        connectDB.connect(context);
        try {
            String sql = "UPDATE tickets "
                    + "SET Sold_out = 1 "
                    + "WHERE Ticket_ID='" + ID + "'";
            PreparedStatement pstmt = connectDB.conn.prepareStatement(sql);
            pstmt.executeUpdate();
            return read();
        } catch (SQLException ex) {
            Logger.getLogger(TicketDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        connectDB.disconnect(context);
        return null;
    }
    
    public ArrayList<Ticket> getAllUpcomingTickets(User user) throws SQLException{
        String context = this.getClass().getName();
        connectDB.connect(context);
        try {
            String sql = "SELECT t.* FROM tickets t "
                    + "JOIN order_details od ON t.Ticket_ID = od.Ticket_ID "
                    + "JOIN orders o ON od.Order_ID = o.Order_ID "
                    + "JOIN flights f ON t.Flight_ID = f.Flight_ID "
                    + "WHERE o.User_ID = '" + user.getID() + "' "
                    + "AND od.NotPaid = 0 "
                    + "AND f.Departure_flight > GETDATE();";
            Statement stmt = connectDB.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Ticket ticket = new Ticket();
                ticket.setTicketID(rs.getString(1));
                ticket.setFlightID(rs.getString(2));
                ticket.setGateID(rs.getString(3));
                ticket.setSeatID(rs.getString(4));
                ticket.setImportPrice(rs.getInt(5));
                ticket.setSellingPrice(rs.getInt(6));
                ticket.setSoldout(rs.getInt(7));
                ticket.setIsDelete(rs.getInt(8));
                upcomingTickets.add(ticket);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TicketDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        connectDB.disconnect(context);
        return upcomingTickets;
    }
    
    public int getTotalSpending(User user) throws SQLException{
        int totalSpending = 0;
        String context = this.getClass().getName();
        connectDB.connect(context);
        try {
            String sql = "SELECT SUM(t.Selling_price) FROM tickets t "
                    + "JOIN order_details od ON t.Ticket_ID = od.Ticket_ID "
                    + "JOIN orders o ON od.Order_ID = o.Order_ID "
                    + "JOIN flights f ON t.Flight_ID = f.Flight_ID "
                    + "WHERE o.User_ID = '" + user.getID() + "' "
                    + "AND od.NotPaid = 0; ";
            Statement stmt = connectDB.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                totalSpending = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TicketDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        connectDB.disconnect(context);
        return totalSpending;
    }
    
    public ArrayList<Ticket> update(Ticket ticket) throws SQLException, IOException, ClassNotFoundException{
        String context = this.getClass().getName();
        connectDB.connect(context);
        try {
            String sql = "UPDATE dbo.tickets "
                    + "SET Flight_ID = ?, Gate_ID = ?, Seat_ID = ?, Import_price = ?, Selling_price = ?, Sold_out = ?, IsDelete = ? "
                    + "WHERE Ticket_ID = ?";
            PreparedStatement pstmt = connectDB.conn.prepareStatement(sql);
            pstmt.setString(1, ticket.getFlightID());
            pstmt.setString(2, ticket.getGateID());
            pstmt.setString(3, ticket.getSeatID());
            pstmt.setInt(4, ticket.getImportPrice());   
            pstmt.setInt(5, ticket.getSellingPrice());   
            pstmt.setInt(6, ticket.getSoldout()); 
            pstmt.setInt(7, ticket.getIsDelete()); 
            pstmt.setString(8, ticket.getTicketID());
            pstmt.executeUpdate();
            return read();
        } catch (SQLException ex) {
            Logger.getLogger(TicketDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        connectDB.disconnect(context);
        return null;
    }
    
    public int getTicketSellingPrice(String ticketID) {
        int sellingPrice = 0;    
        for (Ticket ticket : list) {
            if (ticket.getTicketID().equals(ticketID)) {
                sellingPrice = ticket.getSellingPrice();
                break;
            }
        }    
        return sellingPrice;
    }
    public boolean delete(Ticket ticket) throws SQLException{
        String context = this.getClass().getName();
        connectDB.connect(context);
        try {
            String sql = "UPDATE tickets SET IsDelete = 1 WHERE Ticket_ID = ?";
            PreparedStatement pstmt = ConnectDB.conn.prepareStatement(sql);
            pstmt.setString(1, ticket.getTicketID());
            pstmt.executeUpdate();        
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(RoleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }
}
