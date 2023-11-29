/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.entities.Airport;
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
public class AirportDAO {
    protected ArrayList<Airport> list;
    protected Airport airport;
    private ConnectDB connectDB;
    
    public AirportDAO() throws ClassNotFoundException, SQLException, IOException {
        connectDB = new ConnectDB();
        list = new ArrayList<>();
        airport = new Airport();
        read();
    }

    public ArrayList<Airport> getList() {
        return list;
    }

    public ArrayList<Airport> read() throws IOException, ClassNotFoundException, SQLException {
        String context = this.getClass().getName();
        connectDB.connect(context);
        try {
            String sql = "SELECT * FROM airports WHERE IsDelete = 0";
            Statement stmt = connectDB.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Airport airport = new Airport();
                airport.setAirportID(rs.getString(1));
                airport.setAirportName(rs.getString(2));
                airport.setProvince(rs.getString(3));
                airport.setIsDelete(rs.getInt(4));
                list.add(airport);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AirportDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        connectDB.disconnect(context);
        return list;
    }
    
    public boolean create(Airport airport) throws ClassNotFoundException, SQLException {
        String context = this.getClass().getName();
        connectDB.connect(context);
        try {
            String sql = "INSERT INTO airports(Airport_ID, Airport_name, Province, IsDelete) "
                    + "VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = connectDB.conn.prepareStatement(sql);
            pstmt.setString(1, airport.getAirportID());
            pstmt.setString(2, airport.getAirportName());
            pstmt.setString(3, airport.getProvince());
            pstmt.setInt(4, airport.getIsDelete());
            pstmt.executeUpdate();
            list.add(airport);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AirportDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        connectDB.disconnect(context);
        return false;
    }
    
    public String getIDByName(String airportName) throws SQLException{
        String result = "---";
        String context = this.getClass().getName();
        connectDB.connect(context);
        try {
            String sql = "SELECT airports.Airport_ID FROM airports WHERE Airport_name = '" + airportName + "'";
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
    public boolean deleteAirport(Airport airport) throws ClassNotFoundException, SQLException {
        String context = this.getClass().getName();
        connectDB.connect(context);
        try {
            String updateSql = "UPDATE airports SET IsDelete = 1 WHERE Airport_ID = ?";
            PreparedStatement updateStmt = connectDB.conn.prepareStatement(updateSql);
            updateStmt.setString(1, airport.getAirportID());
            int rowsAffected = updateStmt.executeUpdate();
            if (rowsAffected > 0) {
                airport.setIsDelete(1);

                // Thực hiện truy vấn cập nhật để lưu thay đổi vào cơ sở dữ liệu
                String saveSql = "UPDATE airports SET IsDelete = 1 WHERE Airport_ID = ?";
                PreparedStatement saveStmt = connectDB.conn.prepareStatement(saveSql);
                saveStmt.setString(1, airport.getAirportID());
                saveStmt.executeUpdate();
            
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AirportDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        connectDB.disconnect(context);
        return false;
    }
    
       public boolean updateAirport(Airport airport) throws ClassNotFoundException, SQLException {
            String context = this.getClass().getName();
            connectDB.connect(context);
            try {
                String sql = "UPDATE airports SET Airport_name = ?, Province = ? WHERE Airport_ID = ?";
                PreparedStatement pstmt = connectDB.conn.prepareStatement(sql);
                pstmt.setString(1, airport.getAirportName());
                pstmt.setString(2, airport.getProvince());
                pstmt.setString(3, airport.getAirportID());
                int rowsAffected = pstmt.executeUpdate();
                return rowsAffected > 0;
            } catch (SQLException ex) {
                Logger.getLogger(AirportDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                connectDB.disconnect(context);
            }
            return false;
        }
    
    public boolean existsAirportID(String airportID) {
        for (Airport airport : list) {
            if (airport.getAirportID().equals(airportID)) {
                return true;
            }
        }
        return false;
    }
}
