/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.AirlineDAO;
import DTO.entities.Airline;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author agond
 */
public class AirlineBUS {
    protected static ArrayList<Airline> list;
    protected static AirlineDAO airlineDAO;
    private static int quantity = 0;

    public AirlineBUS() throws ClassNotFoundException, SQLException, IOException {
        airlineDAO = new AirlineDAO();
        list = new ArrayList<>(airlineDAO.getList());
        quantity = list.size();
    }

    public ArrayList<Airline> getList() {
        return list;
    }
    
    public int getQuantity() {
        quantity = list.size();
        return quantity;
    }
    
    public Airline getObjectbyID(String ID){
        for(Airline airline : list){
            if(ID.equals(airline.getAirlineID()))
                return airline;
        }
        return null;
    }
}
