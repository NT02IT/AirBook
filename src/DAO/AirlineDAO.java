/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.entities.Airline;
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
public class AirlineDAO {
    protected ArrayList<Airline> list = new ArrayList<>();
    protected Airline airline = new Airline();
    private ConnectDB connectDB;

    public AirlineDAO() throws ClassNotFoundException, SQLException, IOException {
        connectDB = new ConnectDB();
        read();
    }

    public ArrayList<Airline> getList() {
        return list;
    }

    public ArrayList<Airline> read() throws IOException, ClassNotFoundException, SQLException{
        String context = this.getClass().getName();
        connectDB.connect(context);
        try {
            String sql = "Select * from airlines";
            Statement stmt = connectDB.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Airline airline = new Airline();
                airline.setAirlineID(rs.getString(1));
                airline.setAirlineName(rs.getString(2));
                list.add(airline);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AirlineDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        connectDB.disconnect(context);
        return list;
    }
    
    public boolean create(Airline airline) throws ClassNotFoundException, SQLException {
        String context = this.getClass().getName();
        connectDB.connect(context);
        try {
            String sql = "INSERT INTO airlines(Airline_ID, Airline_name) "
                    + "VALUES (?, ?)";
            PreparedStatement pstmt = connectDB.conn.prepareStatement(sql);
            pstmt.setString(1, airline.getAirlineID());
            pstmt.setString(2, airline.getAirlineName());
            pstmt.executeUpdate();
            list.add(airline);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AirlineDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        connectDB.disconnect(context);
        return false;
    }
}
