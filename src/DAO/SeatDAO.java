/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.entities.Seat;
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
}
