/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.OrderDAO;
import DTO.entities.Order;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author agond
 */
public class OrderBUS {
    protected static ArrayList<Order> list;
    protected static OrderDAO orderDAO;
    private static int quantity = 0;

    public OrderBUS() throws ClassNotFoundException, SQLException, IOException {
        orderDAO = new OrderDAO();
        list = new ArrayList<>(orderDAO.getList());
        quantity = list.size();
    }

    public ArrayList<Order> getList() {
        return list;
    }
    
    public int getQuantity() {
        quantity = list.size();
        return quantity;
    }
    
    public Order getObjectbyID(String ID){
        for(Order order : list){
            if(ID.equals(order.getOrderID()))
                return order;
        }
        return null;
    }
    
    public boolean create(Order order){
        try {
            orderDAO.create(order);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OrderBUS.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(OrderBUS.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
}
