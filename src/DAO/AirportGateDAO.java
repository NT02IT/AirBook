package DAO;

import DTO.entities.AirportGate;
import connection.ConnectDB;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author WIN 10
 */
public class AirportGateDAO {
    protected ArrayList<AirportGate> list;
    protected AirportGate airportGate;
    private ConnectDB connectDB;
    
    public AirportGateDAO() throws ClassNotFoundException, SQLException, IOException {
        connectDB = new ConnectDB();
        list = new ArrayList<>();
        airportGate = new AirportGate();
        read();
    }

    public ArrayList<AirportGate> getList() {
        return list;
    }

    public ArrayList<AirportGate> read() throws IOException, ClassNotFoundException, SQLException {
        String context = this.getClass().getName();
        connectDB.connect(context);
        try {
            String sql = "SELECT * FROM airport_gates WHERE IsDelete = 0";
            Statement stmt = connectDB.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                AirportGate airportGate = new AirportGate();
                airportGate.setGateID(rs.getString(1));
                airportGate.setAirportID(rs.getString(2));
                airportGate.setGateName(rs.getString(3));
                airportGate.setIsDelete(rs.getInt(4));
                list.add(airportGate);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AirportDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        connectDB.disconnect(context);
        return list;
    }
    public ArrayList<AirportGate> getAllGatesByAirportID(String airportID) throws IOException, ClassNotFoundException, SQLException {
        String context = this.getClass().getName();
        connectDB.connect(context);
        ArrayList<AirportGate> result = new ArrayList<>();
        try {
            String sql = "SELECT * FROM airport_gates WHERE IsDelete = 0 AND Airport_ID = '"+ airportID+"';";
            Statement stmt = connectDB.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                AirportGate airportGate = new AirportGate();
                airportGate.setGateID(rs.getString(1));
                airportGate.setAirportID(rs.getString(2));
                airportGate.setGateName(rs.getString(3));
                airportGate.setIsDelete(rs.getInt(4));
                result.add(airportGate);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AirportDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        connectDB.disconnect(context);
        return result;
    }
}
