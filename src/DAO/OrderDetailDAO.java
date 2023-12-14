/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.entities.OrderDetail;
import DTO.entities.Ticket;
import DTO.entities.User;
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
public class OrderDetailDAO {
    protected ArrayList<OrderDetail> list;
    protected OrderDetail orderDetail;
    private ConnectDB connectDB;
    private Ticket ticket;

    public OrderDetailDAO() throws ClassNotFoundException, SQLException, IOException {
        connectDB = new ConnectDB();
        list = new ArrayList<>();
        orderDetail = new OrderDetail();
        read();
    }

    public ArrayList<OrderDetail> getList() {
        return list;
    }

    public OrderDetail getUser() {
        return (OrderDetail)orderDetail;
    }

    public ArrayList<OrderDetail> read() throws IOException, ClassNotFoundException, SQLException{
        String context = this.getClass().getName();
        connectDB.connect(context);
        try {
            String sql = "Select * from order_details";
            Statement stmt = connectDB.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setOrderDetailID(rs.getString(1));
                orderDetail.setOrderID(rs.getString(2));
                orderDetail.setMoreLuggageID(rs.getString(3));
                orderDetail.setReceiverID(rs.getString(4));
                orderDetail.setTicketID(rs.getString(5));
                orderDetail.setPromoID(rs.getString(6));                
                orderDetail.setNotPaid(rs.getInt(7));
                orderDetail.setIsDelete(rs.getInt(8));
                list.add(orderDetail);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        connectDB.disconnect(context);
        return list;
    }
    
    public boolean create(OrderDetail orderDetail) throws ClassNotFoundException, SQLException {
        String context = this.getClass().getName();
        connectDB.connect(context);
        try {
            String sql = "INSERT INTO order_details (Order_detail_ID, Order_ID, More_luggage_ID, Receiver_ID, Ticket_ID, Promo_ID, NotPaid, IsDelete) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = connectDB.conn.prepareStatement(sql);
            pstmt.setString(1, orderDetail.getOrderDetailID());
            pstmt.setString(2, orderDetail.getOrderID());
            pstmt.setString(3, orderDetail.getMoreLuggageID());
            pstmt.setString(4, orderDetail.getReceiverID());
            pstmt.setString(5, orderDetail.getTicketID());              
            pstmt.setString(6, orderDetail.getPromoID());            
            pstmt.setInt(7, orderDetail.getNotPaid());
            pstmt.setInt(8, orderDetail.getIsDelete());
            pstmt.executeUpdate();
            list.add(orderDetail);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(OrderDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        connectDB.disconnect(context);
        return false;
    }
    
    public ArrayList<OrderDetail> update(OrderDetail orderDetail) throws SQLException, IOException, ClassNotFoundException{
        String context = this.getClass().getName();
        connectDB.connect(context);
        try {
            String sql = "UPDATE dbo.order_details "
                    + "SET Order_ID = ?, More_luggage_ID = ?, Receiver_ID = ?, Ticket_ID = ?, Promo_ID = ?, NotPaid = ?, IsDelete = ? "
                    + "WHERE  Order_detail_ID = ?";
            PreparedStatement pstmt = connectDB.conn.prepareStatement(sql);
            pstmt.setString(8, orderDetail.getOrderDetailID());
            pstmt.setString(1, orderDetail.getOrderID());
            pstmt.setString(2, orderDetail.getMoreLuggageID());
            pstmt.setString(3, orderDetail.getReceiverID());
            pstmt.setString(4, orderDetail.getTicketID());              
            pstmt.setString(5, orderDetail.getPromoID());            
            pstmt.setInt(6, orderDetail.getNotPaid());
            pstmt.setInt(7, orderDetail.getIsDelete());
            pstmt.executeUpdate();
            return read();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        connectDB.disconnect(context);
        return null;
    }
    
    public int getQuantityTicketPaidOf(User user) throws SQLException{
        int quantity = -1;
        String context = this.getClass().getName();
        connectDB.connect(context);
        try {
            String sql = "SELECT COUNT(od.Order_detail_ID) AS NumberOfRows FROM order_details od "
                    + "JOIN orders o ON od.Order_ID = o.Order_ID "
                    + "WHERE od.NotPaid = 0 AND o.User_ID = '" + user.getID() + "';";
            Statement stmt = connectDB.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                quantity = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        connectDB.disconnect(context);
        return quantity;
    }
    
    public int countOrders() throws SQLException {
        int count = 0;
        String context = this.getClass().getName();
        connectDB.connect(context);
        try {
            String sql = "SELECT COUNT(*) AS NumberOfOrders FROM order_details WHERE IsDelete = 0";
            Statement stmt = connectDB.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                count = rs.getInt("NumberOfOrders");
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        connectDB.disconnect(context);
        return count;
    }
    
    public int calculateTotalSellingPrice() throws SQLException {
        int totalSellingPrice = 0;
        String context = this.getClass().getName();
        connectDB.connect(context);
        try {
            String sql = "SELECT od.Ticket_ID, od.NotPaid, t.Selling_price " +
                        "FROM order_details od " +
                        "JOIN tickets t ON od.Ticket_ID = t.Ticket_ID " +
                        "WHERE od.IsDelete = 0";
            Statement stmt = connectDB.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int notPaid = rs.getInt("NotPaid");
                int sellingPrice = rs.getInt("Selling_price");
                if (notPaid == 0) {
                    totalSellingPrice += sellingPrice;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        connectDB.disconnect(context);
        return totalSellingPrice;
    }

}
