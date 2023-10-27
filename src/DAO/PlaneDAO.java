/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.entities.Plane;
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
public class PlaneDAO {
    protected ArrayList<Plane> list = new ArrayList<>();
    protected Plane plane = new Plane();
    private ConnectDB connectDB;

    public PlaneDAO() throws ClassNotFoundException, SQLException, IOException {
        connectDB = new ConnectDB();
        read();
    }

    public ArrayList<Plane> getList() {
        return list;
    }

    public ArrayList<Plane> read() throws IOException, ClassNotFoundException, SQLException{
        String context = this.getClass().getName();
        connectDB.connect(context);
        try {
            String sql = "Select * from planes";
            Statement stmt = connectDB.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Plane plane = new Plane();
                plane.setPlaneID(rs.getString(1));
                plane.setAirlineID(rs.getString(2));
                plane.setPlaneName(rs.getString(3));
                plane.setSeats(rs.getInt(4));
                plane.setPlaneDesc(rs.getString(5));
                plane.setIsDelete(rs.getInt(6));
                list.add(plane);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlaneDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        connectDB.disconnect(context);
        return list;
    }
    
    public boolean create(Plane plane) throws ClassNotFoundException, SQLException {
        String context = this.getClass().getName();
        connectDB.connect(context);
        try {
            String sql = "INSERT INTO planes(Plane_ID, Airline_ID, Plane_name, Seats, Plane_desc, IsDelete) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = connectDB.conn.prepareStatement(sql);
            pstmt.setString(1, plane.getPlaneID());
            pstmt.setString(2, plane.getAirlineID());
            pstmt.setString(3, plane.getPlaneName());
            pstmt.setInt(4, plane.getSeats());
            pstmt.setString(5, plane.getPlaneDesc());       
            pstmt.setInt(6, plane.getIsDelete());
            pstmt.executeUpdate();
            list.add(plane);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PlaneDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        connectDB.disconnect(context);
        return false;
    }
}
