/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.SeatDAO;
import DTO.entities.Seat;
import DTO.entities.TicketClass;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author agond
 */
public class SeatBUS {
    protected static ArrayList<Seat> list;
    protected static SeatDAO seatDAO;
    private static int quantity = 0;

    public SeatBUS() throws ClassNotFoundException, SQLException, IOException {
        seatDAO = new SeatDAO();
        list = new ArrayList<>(seatDAO.getList());
        quantity = list.size();
    }

    public ArrayList<Seat> getList() {
        return list;
    }
    
    public int getQuantity() {
        quantity = list.size();
        return quantity;
    }
    
    public Seat getObjectbyID(String ID){
        for(Seat seat : list){
            if(ID.equals(seat.getSeatID()))
                return seat;
        }
        return null;
    }
    
    public ArrayList<Seat> getAllByTicketDetail(String Airline, String Flight_ID, String Ticket_Class) throws IOException, ClassNotFoundException, SQLException{
        ArrayList<Seat> result = seatDAO.getAllByTicketDetail(Airline, Flight_ID, Ticket_Class);        
        return result;
    }
    
    public ArrayList<Seat> getSeatFromClass (TicketClass tkClass) throws SQLException{
        return seatDAO.getSeatFromClass(tkClass);
    }
}
