/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.entities.FlatDiscount;
import DTO.entities.PercentDiscount;
import DTO.entities.Promotion;
import connection.ConnectDB;
import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author agond
 */
public class PromoDAO {
//    protected ArrayList<PercentDiscount> listPercentDiscount = new ArrayList<>();
//    protected ArrayList<FlatDiscount> listFlatDiscount = new ArrayList<>();
    protected ArrayList<Promotion> list;
    protected PercentDiscount percentDiscount;
    protected FlatDiscount flatDiscount;
    private ConnectDB connectDB;
    
    public PromoDAO() throws ClassNotFoundException, SQLException, IOException {
        connectDB = new ConnectDB();
        list = new ArrayList<>();
        read();
    }
    
    public ArrayList<Promotion> getList() {
        return list;
    }
    
    public ArrayList<Promotion> read() throws IOException, ClassNotFoundException, SQLException{
        String context = this.getClass().getName();
        connectDB.connect(context);
        try {
            String sql = "Select * from promotions";
            Statement stmt = connectDB.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                if(rs.getInt(4) == 1){ //Giam theo %
                    percentDiscount = new PercentDiscount();
                    percentDiscount.setPromoID(rs.getString(1));
                    percentDiscount.setAirlineID(rs.getString(2));
                    percentDiscount.setPromoName(rs.getString(3));
                    percentDiscount.setDateStart(rs.getDate(5));
                    percentDiscount.setDateEnd(rs.getDate(6));
                    percentDiscount.setDecreased(rs.getInt(7));
                    percentDiscount.setIsDelete(rs.getInt(8));
                    list.add(percentDiscount);
                }
                else if(rs.getInt(4) == 2){ //Giam tien
                    flatDiscount = new FlatDiscount();
                    flatDiscount.setPromoID(rs.getString(1));
                    flatDiscount.setAirlineID(rs.getString(2));
                    flatDiscount.setPromoName(rs.getString(3));
                    flatDiscount.setDateStart(rs.getDate(5));
                    flatDiscount.setDateEnd(rs.getDate(6));
                    flatDiscount.setDecreased(rs.getInt(7));
                    flatDiscount.setIsDelete(rs.getInt(8));
                    list.add(flatDiscount);
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(PromoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        connectDB.disconnect(context);
        return list;
    }
    public boolean createPercent(PercentDiscount promo) throws ClassNotFoundException, SQLException {
        String context = this.getClass().getName();
        connectDB.connect(context);
        try {
            String sql = "INSERT INTO promotions(Promo_ID,Promo_name,Promo_type,Decreased,Date_start, Date_end, Airline_ID, IsDelete) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, 0)";
            PreparedStatement pstmt = connectDB.conn.prepareStatement(sql);
            pstmt.setString(1, promo.getPromoID());
            pstmt.setString(2, promo.getPromoName());
            pstmt.setInt(3, 1);
            pstmt.setInt(4, promo.getDecreased());
            java.sql.Timestamp dataStart = new java.sql.Timestamp(promo.getDateStart().getTime());
            pstmt.setTimestamp(5, dataStart);   
            java.sql.Timestamp dateEnd = new java.sql.Timestamp(promo.getDateEnd().getTime());
            pstmt.setTimestamp(6, dateEnd); 
            pstmt.setString(7, promo.getAirlineID());
            pstmt.executeUpdate();
            
            list.add(promo);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        connectDB.disconnect(context);
        return false;
    }
    public boolean createFlat(FlatDiscount promo) throws ClassNotFoundException, SQLException {
        String context = this.getClass().getName();
        connectDB.connect(context);
        try {
            String sql = "INSERT INTO promotions(Promo_ID,Promo_name,Promo_type,Decreased,Date_start, Date_end, Airline_ID, IsDelete) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, 0)";
            PreparedStatement pstmt = connectDB.conn.prepareStatement(sql);
            pstmt.setString(1, promo.getPromoID());
            pstmt.setString(2, promo.getPromoName());
            pstmt.setInt(3, 2);
            pstmt.setInt(4, promo.getDecreased());
            java.sql.Timestamp dataStart = new java.sql.Timestamp(promo.getDateStart().getTime());
            pstmt.setTimestamp(5, dataStart);   
            java.sql.Timestamp dateEnd = new java.sql.Timestamp(promo.getDateEnd().getTime());
            pstmt.setTimestamp(6, dateEnd); 
            pstmt.setString(7, promo.getAirlineID());
            pstmt.executeUpdate();
            
            list.add(promo);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        connectDB.disconnect(context);
        return false;
    }
    public boolean update(Promotion promo, int promoType) throws SQLException {
            String context = this.getClass().getName();
            connectDB.connect(context);
            try {
                String sql = "UPDATE promotions SET Promo_name = ? , Promo_type = ? ,Decreased=?, Date_end=? , Date_start=?"
                        + "WHERE Promo_ID = ?";
                PreparedStatement pstmt = ConnectDB.conn.prepareStatement(sql);
                pstmt.setString(1, promo.getPromoName());
                pstmt.setInt(2, promoType);
                java.sql.Timestamp dateEnd = new java.sql.Timestamp(promo.getDateEnd().getTime());
                pstmt.setTimestamp(3, dateEnd);
                java.sql.Timestamp dateStart = new java.sql.Timestamp(promo.getDateStart().getTime());
                pstmt.setTimestamp(4, dateStart);
                pstmt.setString(5, promo.getPromoID());
                pstmt.executeUpdate();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(PermissionDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            connectDB.disconnect(context);
            return false;
        }
    
    public boolean delete(String promoID) throws SQLException{
        String context = this.getClass().getName();
        connectDB.connect(context);
        try {
            String sql = "UPDATE promotions SET IsDelete = 1 WHERE Promo_ID = ?";
            PreparedStatement pstmt = ConnectDB.conn.prepareStatement(sql);
            pstmt.setString(1, promoID);
            pstmt.executeUpdate();        
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(RoleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }
}
