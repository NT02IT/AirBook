/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import BUS.AirportBUS;
import DTO.entities.Airline;
import DTO.entities.Flight;
import assets.DateTime;
import java.sql.Timestamp;
import connection.ConnectDB;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author agond
 */
public class FlightDAO {
    protected ArrayList<Flight> list;
    protected Flight flight;
    protected AirportBUS airportBUS;
    private ConnectDB connectDB;

    public FlightDAO() throws ClassNotFoundException, SQLException, IOException {
        connectDB = new ConnectDB();
        list = new ArrayList<>();
        flight = new Flight();
        airportBUS = new AirportBUS();
        read();
    }

    public ArrayList<Flight> getList() {
        return list;
    }

    public ArrayList<Flight> read() throws IOException, ClassNotFoundException, SQLException{
        String context = this.getClass().getName();
        connectDB.connect(context);
        try {
            String sql = "Select * from flights WHERE IsDelete = 0";
            Statement stmt = connectDB.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Flight flight = new Flight();
                flight.setFlightID(rs.getString(1));
                flight.setFlyingFrom(rs.getString(2));
                flight.setFlyingTo(rs.getString(3));
                flight.setHoursFly(rs.getInt(4));
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
//                LocalDateTime departure = LocalDateTime.parse(rs.getString(5), formatter);
//                flight.setDepartureFlight(departure);
                flight.setDepartureFlight(rs.getTimestamp(5).toLocalDateTime());
                flight.setIsDelete(rs.getInt(6));
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
            String sql = "INSERT INTO flights(Flight_ID, Flying_from, Flying_to, Hours_fly, Departure_flight, IsDelete) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = connectDB.conn.prepareStatement(sql);
            pstmt.setString(1, flight.getFlightID());
            pstmt.setString(2, flight.getFlyingFrom());
            pstmt.setString(3, flight.getFlyingTo());
            pstmt.setInt(4, flight.getHoursFly());
            pstmt.setTimestamp(5, Timestamp.valueOf(flight.getDepartureFlight()));
            pstmt.setInt(6, flight.getIsDelete());
            pstmt.executeUpdate();
            list.add(flight);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(FlightDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        connectDB.disconnect(context);
        return false;
    }
    
    public String getIDByDetail(String FromAirport, String ToAirport, String Departure) throws IOException, ClassNotFoundException, SQLException, ParseException{
        FromAirport = "Noi Bai International Airport";
        ToAirport = "Tan Son Nhat International Airport";
        Departure = "30/09/2023 09:30";
            
        FromAirport = airportBUS.getIDByName(FromAirport);
        ToAirport = airportBUS.getIDByName(ToAirport);
        Departure = DateTime.convertFormat(Departure, "dd/MM/yyyy HH:mm", "yyyy-MM-dd HH:mm");
        String context = this.getClass().getName();
        connectDB.connect(context);
        String result = "---";
        try {
//            String sql = "SELECT flights.Flight_ID"
//                    + "FROM (flights, airports) "
//                    + "WHERE flights.Flying_from = '" + FromAirport + "' "
//                    + "AND flights.Flying_to = '" + ToAirport + "' "
//                    + "AND (airports.Airport_ID = flights.Flying_from OR airports.Airport_ID = flights.Flying_to) "
//                    + "AND flights.Departure_flight = '" + Departure + "' "
//                    + "GROUP BY flights.Flight_ID;";

            String sql = "SELECT flights.Flight_ID "
                    + "FROM flights "
                    + "JOIN airports AS flying_from ON flights.Flying_from = flying_from.Airport_ID "
                    + "JOIN airports AS flying_to ON flights.Flying_to = flying_to.Airport_ID "
                    + "WHERE flying_from.Airport_ID = '" + FromAirport + "' "
                    + "AND flying_to.Airport_ID = '" + ToAirport + "' "
                    + "AND flights.Departure_flight = '" + Departure + "'";

            Statement stmt = connectDB.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                result = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FlightDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        connectDB.disconnect(context);
        return result;
    }
    public ArrayList<Flight> getAllFlightOfAirline(Airline airline) throws SQLException{
        ArrayList<Flight> flights = new ArrayList<>();
        String context = this.getClass().getName();
        connectDB.connect(context);
        try {
            String sql = "SELECT f.Flight_ID, f.Flying_from, f.Flying_to, f.Hours_fly, f.Departure_flight, f.IsDelete FROM flights f \n" +
                "JOIN tickets t ON f.Flight_ID = t.Flight_ID\n" +
                "JOIN seats s ON t.Seat_ID = s.Seat_ID\n" +
                "JOIN ticket_classes tc ON s.Ticket_class_ID = tc.Ticket_class_ID\n" +
                "JOIN planes p ON tc.Plane_ID = p.Plane_ID\n" +
                "JOIN airlines a ON p.Airline_ID = a.Airline_ID\n" +
                "WHERE a.Airline_ID = '" + airline.getAirlineID() + "'\n" +
                "GROUP BY f.Flight_ID, f.Flying_from, f.Flying_to, f.Hours_fly, f.Departure_flight, f.IsDelete";
            Statement stmt = connectDB.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Flight flight = new Flight();
                flight.setFlightID(rs.getString(1));
                flight.setFlyingFrom(rs.getString(2));
                flight.setFlyingTo(rs.getString(3));
                flight.setHoursFly(rs.getInt(4));
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
//                LocalDateTime departure = LocalDateTime.parse(rs.getString(5), formatter);
//                flight.setDepartureFlight(departure);
                flight.setDepartureFlight(rs.getTimestamp(5).toLocalDateTime());
                flight.setIsDelete(rs.getInt(6));
                flights.add(flight);
            }
          return flights;
        }
        public boolean deleteFlight(Flight flight) throws ClassNotFoundException, SQLException {
        String context = this.getClass().getName();
        connectDB.connect(context);
        try {
            String updateSql = "UPDATE flights SET IsDelete = 1 WHERE Flight_ID = ?";
            PreparedStatement updateStmt = connectDB.conn.prepareStatement(updateSql);
            updateStmt.setString(1, flight.getFlightID());
            int rowsAffected = updateStmt.executeUpdate();
            if (rowsAffected > 0) {
                flight.setIsDelete(1);

                // Thực hiện truy vấn cập nhật để lưu thay đổi vào cơ sở dữ liệu
                String saveSql = "UPDATE flights SET IsDelete = 1 WHERE Flight_ID = ?";
                PreparedStatement saveStmt = connectDB.conn.prepareStatement(saveSql);
                saveStmt.setString(1, flight.getFlightID());
                saveStmt.executeUpdate();
            
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FlightDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        connectDB.disconnect(context);
        
        return false;
    }
    
       public boolean updateFlight(Flight flight) throws ClassNotFoundException, SQLException {
            String context = this.getClass().getName();
            connectDB.connect(context);
            try {
                String sql = "UPDATE airports SET Airport_name = ?, Province = ? WHERE Airport_ID = ?";
                PreparedStatement pstmt = connectDB.conn.prepareStatement(sql);
                //pstmt.setString(1, flight.getAirportName());
                //pstmt.setString(2, flight.getProvince());
                //pstmt.setString(3, flight.getAirportID());
                int rowsAffected = pstmt.executeUpdate();
                return rowsAffected > 0;
            } catch (SQLException ex) {
                Logger.getLogger(FlightDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                connectDB.disconnect(context);
            }
            return false;
        }
    
    public boolean existsFlightID(String flightID) {
        for (Flight flight : list) {
            if (flight.getFlightID().equals(flightID)) {
                return true;
            }
        }
        return false;
    }
}
