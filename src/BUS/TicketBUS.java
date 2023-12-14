/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.TicketDAO;
import DTO.entities.Plane;
import DTO.entities.Seat;
import DTO.entities.Ticket;
import DTO.entities.TicketClass;
import DTO.entities.User;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author agond
 */
public class TicketBUS {
    protected static ArrayList<Ticket> list;
    protected static TicketDAO ticketDAO;
    private static int quantity = 0;

    public TicketBUS() throws ClassNotFoundException, SQLException, IOException {
        ticketDAO = new TicketDAO();
        list = new ArrayList<>(ticketDAO.getList());
        quantity = list.size();
    }

    public ArrayList<Ticket> getList() {
        return list;
    }
    
    public int getQuantity() {
        quantity = list.size();
        return quantity;
    }
    
    public Ticket getObjectbyID(String ID){
        for(Ticket ticket : list){
            if(ID.equals(ticket.getTicketID()))
                return ticket;
        }
        return null;
    }
    
    public Ticket getObjectByFlightIDSeatID(String FlightID, String SeatID) throws SQLException{
        return ticketDAO.getObjectByFlightIDSeatID(FlightID, SeatID);
    }
    
    public ArrayList<Ticket> setSoldout(String ID) throws ClassNotFoundException, SQLException, IOException {
        return ticketDAO.setSoldout(ID);
    }
    
    public ArrayList<Ticket> getAllUpcomingTickets(User user) throws SQLException{
        return ticketDAO.getAllUpcomingTickets(user);
    }
    
    public int getTotalSpending(User user) throws SQLException{
        return ticketDAO.getTotalSpending(user);
    }
    
    public ArrayList<Ticket> update(Ticket ticket) throws SQLException, IOException, ClassNotFoundException{
        return ticketDAO.update(ticket);
    }
    public boolean create(Ticket ticket, Plane plane, TicketClass ticketClass ) throws SQLException, IOException, ClassNotFoundException{
        SeatBUS seatBUS = new SeatBUS();
        ArrayList<Seat> seatList =  seatBUS.getSeatFromClass(ticketClass);
        
        for(Seat s : seatList){
            String ticketID = Ticket.generateID();
            ticket.setTicketID(ticketID);
            ticket.setSeatID(s.getSeatID());
            ticketDAO.create(ticket);
        }
        
        return true;
    }
}
