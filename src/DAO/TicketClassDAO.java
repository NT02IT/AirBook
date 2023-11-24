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
    protected ArrayList<TicketClass> list;
    protected TicketClass ticketClass;
    private ConnectDB connectDB;

    public TicketClassDAO() throws ClassNotFoundException, SQLException, IOException {
        connectDB = new ConnectDB();
        list = new ArrayList<>();
        ticketClass = new TicketClass();
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
    
    public ArrayList<TicketClass> getAllClassNameByAirlineIDFlightID(String Airline_ID, String Flight_ID) throws SQLException{
        String context = this.getClass().getName();
        ArrayList<TicketClass> result = new ArrayList<>();
        connectDB.connect(context);
        try {
            String sql = "SELECT DISTINCT ticket_classes.Ticket_class_ID, "
                    + "ticket_classes.Plane_ID, "
                    + "ticket_classes.Class_name, "
                    + "ticket_classes.Seats_quantity, "
                    + "ticket_classes.IsDelete "
                    + "FROM airlines "
                    + "INNER JOIN planes ON airlines.Airline_ID = planes.Airline_ID "
                    + "INNER JOIN ticket_classes ON planes.Plane_ID = ticket_classes.Plane_ID "
                    + "INNER JOIN seats ON ticket_classes.Ticket_class_ID = seats.Ticket_class_ID "
                    + "INNER JOIN tickets ON seats.Seat_ID = tickets.Seat_ID "
                    + "INNER JOIN flights ON tickets.Flight_ID = flights.Flight_ID "
                    + "WHERE airlines.Airline_ID='" + Airline_ID.trim() + "' AND flights.Flight_ID='" + Flight_ID.trim() + "';";

            //String sql = "SELECT DISTINCT ticket_classes.Ticket_class_ID, ticket_classes.Plane_ID, ticket_classes.Class_name, ticket_classes.Seats_quantity, ticket_classes.IsDelete FROM airlines INNER JOIN planes ON airlines.Airline_ID = planes.Airline_ID INNER JOIN ticket_classes ON planes.Plane_ID = ticket_classes.Plane_ID INNER JOIN seats ON ticket_classes.Ticket_class_ID = seats.Ticket_class_ID INNER JOIN tickets ON seats.Seat_ID = tickets.Seat_ID INNER JOIN flights ON tickets.Flight_ID = flights.Flight_ID WHERE airlines.Airline_ID='VN' AND flights.Flight_ID='VN1003';";
            Statement stmt = connectDB.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                TicketClass ticketClass = new TicketClass();
                ticketClass.setTicketClassID(rs.getString(1));
                ticketClass.setPlaneID(rs.getString(2));
                ticketClass.setClassName(rs.getString(3));
                ticketClass.setSeatsQuantity(rs.getInt(4));
                ticketClass.setIsDelete(rs.getInt(5));
                result.add(ticketClass);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TicketClassDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        connectDB.disconnect(context);
        return result;
    }
    
    public TicketClass getObjectByPlaneIDClassName(String PlaneID, String ClassName) throws SQLException{
        String context = this.getClass().getName();
        connectDB.connect(context);
        try {
            String sql = "SELECT * FROM ticket_classes "
                    + "WHERE ticket_classes.PlaneID='" + PlaneID + "' "
                    + "AND ticket_classes.Class_name='" + ClassName + "'";
            Statement stmt = connectDB.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                TicketClass ticketClass = new TicketClass();
                ticketClass.setTicketClassID(rs.getString(1));
                ticketClass.setPlaneID(rs.getString(2));
                ticketClass.setClassName(rs.getString(3));
                ticketClass.setSeatsQuantity(rs.getInt(4));
                ticketClass.setIsDelete(rs.getInt(5));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TicketClassDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        connectDB.disconnect(context);
        return ticketClass;
    }
}
