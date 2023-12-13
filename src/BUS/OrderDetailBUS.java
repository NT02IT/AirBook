/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.OrderDetailDAO;
import DTO.entities.OrderDetail;
import DTO.entities.User;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author agond
 */
public class OrderDetailBUS {
    protected static ArrayList<OrderDetail> list;
    protected static OrderDetailDAO orderDetailDAO;
    private static int quantity = 0;

    public OrderDetailBUS() throws ClassNotFoundException, SQLException, IOException {
        orderDetailDAO = new OrderDetailDAO();
        list = new ArrayList<>(orderDetailDAO.getList());
        quantity = list.size();
    }

    public ArrayList<OrderDetail> getList() {
        return list;
    }
    
    public int getQuantity() {
        quantity = list.size();
        return quantity;
    }
    
    public OrderDetail getObjectbyID(String ID){
        for(OrderDetail od : list){
            if(ID.equals(od.getOrderDetailID()))
                return od;
        }
        return null;
    }
    
    public boolean create(OrderDetail data){
        try {
            orderDetailDAO.create(data);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OrderDetailBUS.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(OrderDetailBUS.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
    public ArrayList<OrderDetail> update(OrderDetail orderDetail) throws SQLException, IOException, ClassNotFoundException{
        return orderDetailDAO.update(orderDetail);
    }
       
    public int getQuantityTicketPaidOf(User user) throws SQLException{
        return orderDetailDAO.getQuantityTicketPaidOf(user);
    }
    
    public int getNumberOfOrders() throws SQLException {
        return orderDetailDAO.countOrders();
    }
    
    public int getTotalSelling() throws SQLException{
        return orderDetailDAO.calculateTotalSellingPrice();
    }
    
}
