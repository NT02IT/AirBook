/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.TicketClassDAO;
import DAO.TicketDAO;
import DTO.entities.Ticket;
import DTO.entities.TicketClass;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author agond
 */
public class TicketClassBUS {
    protected static ArrayList<TicketClass> list;
    protected static TicketClassDAO ticketClassDAO;
    private static int quantity = 0;

    public TicketClassBUS() throws ClassNotFoundException, SQLException, IOException {
        ticketClassDAO = new TicketClassDAO();
        list = new ArrayList<>(ticketClassDAO.getList());
        quantity = list.size();
    }

    public static ArrayList<TicketClass> getList() {
        return list;
    }
    
    public static int getQuantity() {
        quantity = list.size();
        return quantity;
    }
    
    public static TicketClass getObjectbyID(String ID){
        for(TicketClass ticketClass : list){
            if(ID.equals(ticketClass.getTicketClassID()))
                return ticketClass;
        }
        return null;
    }
}
