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
            String lastID = getLastMoreLuggageID(); // Lấy ID cuối cùng từ CSDL
            String newID = generateNextMoreLuggageID(lastID); // Tạo ID mới dựa trên ID cuối cùng
            pstmt.setString(1, newID);
            pstmt.setString(2, moreLuggage.getAirlineID());
            pstmt.setInt(3, moreLuggage.getLuggageWeight());
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
    public String getLastMoreLuggageID() throws SQLException {
        String sql = "SELECT TOP 1 More_luggage_ID FROM more_luggage ORDER BY More_luggage_ID DESC";
        Statement stmt = connectDB.conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        if (rs.next()) {
            return rs.getString("More_luggage_ID");
        }
        return "MLG0000"; // Trả về ID mặc định nếu không có ID nào trong CSDL
    }

// Hàm tạo ID mới dựa trên ID cuối cùng
    public String generateNextMoreLuggageID(String lastID) {
        int number = Integer.parseInt(lastID.substring(5)); // Lấy phần số từ ID cuối cùng
        number++; // Tăng số lên 1
        String nextNumber = String.format("%04d", number); // Định dạng số thành chuỗi với độ dài 4 ký tự
        return "MLG" + nextNumber;
    }

    public String generateNewMoreLuggageID() throws SQLException {
        String lastID = getLastMoreLuggageID(); // Lấy ID cuối cùng từ CSDL
        String newID = generateNextMoreLuggageID(lastID); // Tạo ID mới dựa trên ID cuối cùng
        return newID;
    }
}
