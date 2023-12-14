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

    public ArrayList<TicketClass> getList() {
        return list;
    }
    
    public int getQuantity() {
        quantity = list.size();
        return quantity;
    }
    
    public TicketClass getObjectbyID(String ID){
        for(TicketClass ticketClass : list){
            if(ID.equals(ticketClass.getTicketClassID()))
                return ticketClass;
        }
        return null;
    }
    public ArrayList<TicketClass> getAllClassNameByAirlineIDFlightID(String Airline_ID, String Flight_ID) throws SQLException{
        return ticketClassDAO.getAllClassNameByAirlineIDFlightID(Airline_ID, Flight_ID);
    }
    public TicketClass getObjectByPlaneIDClassName(String PlaneID, String ClassName) throws SQLException{
        return ticketClassDAO.getObjectByPlaneIDClassName(PlaneID, ClassName);
    }
    public ArrayList<String> getAllClassName() throws SQLException{
        return ticketClassDAO.getAllClassNameClasses();
    }
    public ArrayList<TicketClass> getAllByPlaneID(String planeID) throws SQLException{
        return ticketClassDAO.getAllByPlaneID(planeID);
    }
}
