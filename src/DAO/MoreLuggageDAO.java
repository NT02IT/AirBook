/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.entities.MoreLuggage;
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
public class MoreLuggageDAO {
    protected ArrayList<MoreLuggage> list;
    protected MoreLuggage moreLuggage;
    private ConnectDB connectDB;

    public MoreLuggageDAO() throws ClassNotFoundException, SQLException, IOException {
        connectDB = new ConnectDB();
        list = new ArrayList<>();
        moreLuggage = new MoreLuggage();
        read();
    }

    public ArrayList<MoreLuggage> getList() {
        return list;
    }

    public ArrayList<MoreLuggage> read() throws IOException, ClassNotFoundException, SQLException{
        String context = this.getClass().getName();
        connectDB.connect(context);
        try {
            String sql = "Select * from more_luggage";
            Statement stmt = connectDB.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                MoreLuggage moreLuggage = new MoreLuggage();
                moreLuggage.setMoreLuggageID(rs.getString(1));
                moreLuggage.setAirlineID(rs.getString(2));
                moreLuggage.setLuggageWeight(rs.getInt(3));
                moreLuggage.setPrice(rs.getInt(4));
                moreLuggage.setIsDelete(rs.getInt(5));
                list.add(moreLuggage);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MoreLuggageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        connectDB.disconnect(context);
        return list;
    }
    
    public boolean create(MoreLuggage moreLuggage) throws ClassNotFoundException, SQLException {
        String context = this.getClass().getName();
        connectDB.connect(context);
        try {
            String sql = "INSERT INTO more_luggage(More_luggage_ID, Airline_ID, Luggage_weight, Price, IsDelete) "
                    + "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmt = connectDB.conn.prepareStatement(sql);
            pstmt.setString(1, moreLuggage.getMoreLuggageID());
            pstmt.setString(2, moreLuggage.getAirlineID());
            pstmt.setString(3, moreLuggage.getMoreLuggageID());
            pstmt.setInt(4, moreLuggage.getPrice());
            pstmt.setInt(5, moreLuggage.getIsDelete());
            pstmt.executeUpdate();
            list.add(moreLuggage);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MoreLuggageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        connectDB.disconnect(context);
        return false;
    }
}
