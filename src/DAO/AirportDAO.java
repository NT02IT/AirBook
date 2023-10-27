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
    protected ArrayList<Airport> list = new ArrayList<>();
    protected Airport airport = new Airport();
    private ConnectDB connectDB;
    
    public AirportDAO() throws ClassNotFoundException, SQLException, IOException {
        connectDB = new ConnectDB();
        read();
    }

    public ArrayList<Airport> getList() {
        return list;
    }

    public ArrayList<Airport> read() throws IOException, ClassNotFoundException, SQLException{
        String context = this.getClass().getName();
        connectDB.connect(context);
        try {
            String sql = "Select * from airports";
            Statement stmt = connectDB.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
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
}
