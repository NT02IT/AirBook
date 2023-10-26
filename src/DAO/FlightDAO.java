/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.entities.Flight;
import java.sql.Timestamp;
import connection.ConnectDB;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author agond
 */
public class FlightDAO {
    protected ArrayList<Flight> list = new ArrayList<>();
    protected Flight flight = new Flight();
    private ConnectDB connectDB;

    public FlightDAO() throws ClassNotFoundException, SQLException, IOException {
        connectDB = new ConnectDB();
        read();
    }

    public ArrayList<Flight> getList() {
        return list;
    }

    public ArrayList<Flight> read() throws IOException, ClassNotFoundException, SQLException{
        String context = this.getClass().getName();
        connectDB.connect(context);
        try {
            String sql = "Select * from users";
            Statement stmt = connectDB.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Flight flight = new Flight();
                flight.setFlightID(rs.getString(1));
                flight.setFlyingFrom(rs.getString(2));
                flight.setFlyingTo(rs.getString(3));
                flight.setHoursFly(rs.getInt(4));
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss.S");
                LocalDateTime departure = LocalDateTime.parse(rs.getString(5), formatter);
                flight.setDepartureFlight(departure);
                list.add(flight);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FlightDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        connectDB.disconnect(context);
        return list;
    }
    
    public boolean create(Flight flight) throws ClassNotFoundException, SQLException {
        String context = this.getClass().getName();
        connectDB.connect(context);
        try {
            String sql = "INSERT INTO flights(Flight_ID, Flying_from, Flying_to, Hours_fly, Departure_flight) "
                    + "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmt = connectDB.conn.prepareStatement(sql);
            pstmt.setString(1, flight.getFlightID());
            pstmt.setString(2, flight.getFlyingFrom());
            pstmt.setString(3, flight.getFlyingTo());
            pstmt.setInt(4, flight.getHoursFly());
            pstmt.setTimestamp(5, Timestamp.valueOf(flight.getDepartureFlight()));
            pstmt.executeUpdate();
            list.add(flight);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(FlightDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        connectDB.disconnect(context);
        return false;
    }
}
