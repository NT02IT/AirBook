/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.SeatDAO;
import DAO.TicketDAO;
import DTO.entities.Seat;
import DTO.entities.Ticket;
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

    public static ArrayList<Seat> getList() {
        return list;
    }
    
    public static int getQuantity() {
        quantity = list.size();
        return quantity;
    }
    
    public static Seat getObjectbyID(String ID){
        for(Seat seat : list){
            if(ID.equals(seat.getSeatID()))
                return seat;
        }
        return null;
    }
}
