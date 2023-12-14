/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.entities.Seat;
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
import org.eclipse.persistence.internal.queries.ArrayListContainerPolicy;

/**
 *
 * @author agond
 */
public class SeatDAO {
    protected static ArrayList<Seat> list;
    protected Seat seat;
    private ConnectDB connectDB;

    public SeatDAO() throws ClassNotFoundException, SQLException, IOException {
        connectDB = new ConnectDB();
        list = new ArrayList<>();
        seat = new Seat();
        read();
    }

    public ArrayList<Seat> getList() {
        return list;
    }

    public ArrayList<Seat> read() throws IOException, ClassNotFoundException, SQLException{
        String context = this.getClass().getName();
        connectDB.connect(context);
        try {
            String sql = "Select * from seats";
            Statement stmt = connectDB.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Seat seat = new Seat();
                seat.setSeatID(rs.getString(1));
                seat.setTicketClassID(rs.getString(2));
                seat.setSeatName(rs.getString(3));
                seat.setIsDelete(rs.getInt(4));
                list.add(seat);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SeatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        connectDB.disconnect(context);
        return list;
    }
    
    public boolean create(Seat seat) throws ClassNotFoundException, SQLException {
        String context = this.getClass().getName();
        connectDB.connect(context);
        try {
            String sql = "INSERT INTO seats(Seat_ID, Ticket_class_ID, Seat_name, IsDelete) "
                    + "VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = connectDB.conn.prepareStatement(sql);
            pstmt.setString(1, seat.getSeatID());
            pstmt.setString(2, seat.getTicketClassID());
            pstmt.setString(3, seat.getSeatName());
            pstmt.setInt(4, seat.getIsDelete());
            pstmt.executeUpdate();
            list.add(seat);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SeatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        connectDB.disconnect(context);
        return false;
    }
    
    public ArrayList<Seat> getAllByTicketDetail(String Airline, String Flight_ID, String Ticket_Class) throws IOException, ClassNotFoundException, SQLException{
        String context = this.getClass().getName();
        connectDB.connect(context);
        ArrayList<Seat> result = new ArrayList<>();
        try {
            String sql = "SELECT seats.Seat_ID, seats.Ticket_class_ID, seats.Seat_name, seats.IsDelete "
                    + "FROM seats "
                    + "INNER JOIN ticket_classes ON seats.Ticket_class_ID = ticket_classes.Ticket_class_ID "
                    + "INNER JOIN tickets ON tickets.Seat_ID = seats.Seat_ID "
                    + "INNER JOIN flights ON flights.Flight_ID = tickets.Flight_ID "
                    + "INNER JOIN planes ON planes.Plane_ID = ticket_classes.Plane_ID "
                    + "INNER JOIN airlines ON airlines.Airline_ID = planes.Airline_ID "
                    + "WHERE ticket_classes.Class_name = '" + Ticket_Class + "' "
                    + "AND seats.IsDelete=0 "
                    + "AND airlines.Airline_name='" + Airline + "' "
                    + "AND flights.Flight_ID='" + Flight_ID + "';";
            Statement stmt = connectDB.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Seat seat = new Seat();
                seat.setSeatID(rs.getString(1));
                seat.setTicketClassID(rs.getString(2));
                seat.setSeatName(rs.getString(3));
                seat.setIsDelete(rs.getInt(4));
                result.add(seat);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SeatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        connectDB.disconnect(context);
        return result;
    }
    
    public Seat getObjectByNameTicketClass(String seatName, String ticketClassID) throws SQLException{
        String context = this.getClass().getName();
        connectDB.connect(context);
        try {
            String sql = "SELECT * FROM seats "
                    + "WHERE seats.Ticket_class_ID='" + ticketClassID + "' "
                    + "AND seats.Seat_name='" + seatName + "'";
            Statement stmt = connectDB.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Seat seat = new Seat();
                seat.setSeatID(rs.getString(1));
                seat.setTicketClassID(rs.getString(2));
                seat.setSeatName(rs.getString(3));
                seat.setIsDelete(rs.getInt(4));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SeatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        connectDB.disconnect(context);
        return seat;
    }
    
    public ArrayList<Seat> getSeatFromClass (TicketClass tkClass) throws SQLException{
        ArrayList<Seat> result = new ArrayList();
        String context = this.getClass().getName();
        connectDB.connect(context);
        try {
            String sql = "Select s.* FROM seats s, ticket_classes tkC "
                    + "Where s.Ticket_class_ID=tkC.Ticket_class_ID "
                    + "And tkC.Ticket_class_ID='" + tkClass.getTicketClassID() + "'";
            Statement stmt = connectDB.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Seat seat = new Seat();
                seat.setSeatID(rs.getString(1));
                seat.setTicketClassID(rs.getString(2));
                seat.setSeatName(rs.getString(3));
                seat.setIsDelete(rs.getInt(4));
                result.add(seat);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SeatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        connectDB.disconnect(context);
        return result;
    }
}
