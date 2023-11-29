/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.entities.OrderDetail;
import DTO.entities.PromoCollection;
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
public class PromoCollectionDAO {
    protected ArrayList<PromoCollection> list;
    protected PromoCollection promoCollection;
    private ConnectDB connectDB;

    public PromoCollectionDAO() throws ClassNotFoundException, SQLException, IOException {
        connectDB = new ConnectDB();
        list = new ArrayList<>();
        promoCollection = new PromoCollection();
        read();
    }

    public ArrayList<PromoCollection> getList() {
        return list;
    }

    public ArrayList<PromoCollection> read() throws IOException, ClassNotFoundException, SQLException{
        String context = this.getClass().getName();
        connectDB.connect(context);
        try {
            String sql = "Select * from promo_collection";
            Statement stmt = connectDB.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                PromoCollection promoCollection = new PromoCollection();
                promoCollection.setPromo_collection_ID(rs.getString(1));
                promoCollection.setUser_ID(rs.getString(2));
                promoCollection.setPromo_ID(rs.getString(3));
                list.add(promoCollection);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PromoCollectionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        connectDB.disconnect(context);
        return list;
    }
    
    public boolean create(PromoCollection promoCollection) throws ClassNotFoundException, SQLException {
        String context = this.getClass().getName();
        connectDB.connect(context);
        try {
            String sql = "INSERT INTO promo_collection (Promo_collection_ID, User_ID, Promo_ID) "
                    + "VALUES (?, ?, ?)";
            PreparedStatement pstmt = connectDB.conn.prepareStatement(sql);
            pstmt.setString(1, promoCollection.getPromo_collection_ID());
            pstmt.setString(2, promoCollection.getUser_ID());
            pstmt.setString(3, promoCollection.getPromo_ID());
            pstmt.executeUpdate();
            list.add(promoCollection);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PromoCollectionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        connectDB.disconnect(context);
        return false;
    }
}
