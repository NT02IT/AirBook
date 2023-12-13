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
    protected ArrayList<Plane> list;
    protected Plane plane;
    private ConnectDB connectDB;

    public PlaneDAO() throws ClassNotFoundException, SQLException, IOException {
        connectDB = new ConnectDB();
        list = new ArrayList<>();
        plane = new Plane();
        read();
    }

    public ArrayList<Plane> getList() {
        return list;
    }

    public ArrayList<Plane> read() throws IOException, ClassNotFoundException, SQLException{
        String context = this.getClass().getName();
        connectDB.connect(context);
        try {
            String sql = "Select * from planes WHERE IsDelete = 0";
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
            // Tìm mã máy bay lớn nhất trong cùng hãng
            String maxPlaneIDQuery = "SELECT MAX(Plane_ID) FROM planes WHERE Airline_ID = ?";
            PreparedStatement maxPlaneIDStmt = connectDB.conn.prepareStatement(maxPlaneIDQuery);
            maxPlaneIDStmt.setString(1, plane.getAirlineID());
            ResultSet maxPlaneIDResult = maxPlaneIDStmt.executeQuery();
            String maxPlaneID = null;
            if (maxPlaneIDResult.next()) {
                maxPlaneID = maxPlaneIDResult.getString(1);
            }
        
            // Tạo mã máy bay mới
            String newPlaneID = generateNewPlaneID(maxPlaneID);        
            String sql = "INSERT INTO planes(Plane_ID, Airline_ID, Plane_name, Seats, Plane_desc, IsDelete) "
                        + "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = connectDB.conn.prepareStatement(sql);
            pstmt.setString(1, newPlaneID);
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
    
    public int getNumberOfPlanesByAirlineID(String airlineID) throws ClassNotFoundException, SQLException {
        String context = this.getClass().getName();
        connectDB.connect(context);
        try {
            String sql = "SELECT COUNT(*) FROM planes WHERE Airline_ID = ?";
            PreparedStatement pstmt = connectDB.conn.prepareStatement(sql);
            pstmt.setString(1, airlineID);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlaneDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        connectDB.disconnect(context);
        return 0;
    }
    
    public ArrayList<Plane> getPlaneListByAirlineID(String airlineID) throws ClassNotFoundException, SQLException {
        String context = this.getClass().getName();
        connectDB.connect(context);
        ArrayList<Plane> planeList = new ArrayList<>(); 
        try {
            // Tìm mã máy bay lớn nhất trong cùng hãng
            String maxPlaneIDQuery = "SELECT MAX(Plane_ID) FROM planes WHERE Airline_ID = ?";
            PreparedStatement maxPlaneIDStmt = connectDB.conn.prepareStatement(maxPlaneIDQuery);
            maxPlaneIDStmt.setString(1, plane.getAirlineID());
            ResultSet maxPlaneIDResult = maxPlaneIDStmt.executeQuery();
            String maxPlaneID = null;
            if (maxPlaneIDResult.next()) {
                maxPlaneID = maxPlaneIDResult.getString(1);
            }
        // Tạo mã máy bay mới
        String newPlaneID = generateNewPlaneID(maxPlaneID);
            String sql = "SELECT * FROM planes WHERE Airline_ID = ?";
            PreparedStatement pstmt = connectDB.conn.prepareStatement(sql);
            pstmt.setString(1, airlineID);
            ResultSet rs = pstmt.executeQuery();       
            while (rs.next()) {
                Plane plane = new Plane();
                plane.setPlaneID(rs.getString(1));
                plane.setAirlineID(rs.getString(2));
                plane.setPlaneName(rs.getString(3));
                plane.setSeats(rs.getInt(4));
                plane.setPlaneDesc(rs.getString(5));
                plane.setIsDelete(rs.getInt(6));
                planeList.add(plane);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlaneDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        connectDB.disconnect(context);
        return planeList;
    }
    private String generateNewPlaneID(String maxPlaneID) {
        if (maxPlaneID == null) {
        // Không có mã máy bay trong cùng hãng
            return "01"; // Hoặc giá trị khởi tạo tùy chọn khác
        }

        // Tách các phần của mã máy bay hiện tại
        String[] parts = maxPlaneID.split("-");
        String airlineCode = parts[0];
        String airlineID = parts[1];
        String currentNumber = parts[2];

        // Tăng giá trị số cuối cùng lên một đơn vị
        int newNumber = Integer.parseInt(currentNumber) + 1;

        // Tạo mã máy bay mới
        String newPlaneID = airlineCode + "-" + airlineID + "-" + String.format("%02d", newNumber);

        return newPlaneID;
    }

    public boolean deletePlane(Plane plane) throws ClassNotFoundException, SQLException {
        String context = this.getClass().getName();
        connectDB.connect(context);
        try {
            String updateSql = "UPDATE planes SET IsDelete = 1 WHERE Plane_ID = ?";
            PreparedStatement updateStmt = connectDB.conn.prepareStatement(updateSql);
            updateStmt.setString(1, plane.getPlaneID());
            int rowsAffected = updateStmt.executeUpdate();
            if (rowsAffected > 0) {
                plane.setIsDelete(1);
                // Thực hiện truy vấn cập nhật để lưu thay đổi vào cơ sở dữ liệu
                String saveSql = "UPDATE planes SET IsDelete = 1 WHERE Plane_ID = ?";
                PreparedStatement saveStmt = connectDB.conn.prepareStatement(saveSql);
                saveStmt.setString(1, plane.getPlaneID());
                saveStmt.executeUpdate();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlaneDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        connectDB.disconnect(context);
        return false;
    }  
       public boolean updatePlane(Plane plane) throws ClassNotFoundException, SQLException {
            String context = this.getClass().getName();
            connectDB.connect(context);
            try {
                String sql = "UPDATE planes SET Plane_name = ?, Seats = ? WHERE Plane_ID = ?";
                PreparedStatement pstmt = connectDB.conn.prepareStatement(sql);
                pstmt.setString(1, plane.getPlaneName());
                pstmt.setInt(2, plane.getSeats());
                pstmt.setString(3, plane.getPlaneID());
                int rowsAffected = pstmt.executeUpdate();
                return rowsAffected > 0;
            } catch (SQLException ex) {
                Logger.getLogger(AirportDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                connectDB.disconnect(context);
            }
            return false;
        }    
    
}
