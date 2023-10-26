/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import static BUS.UserBUS.userDAO;
import DAO.AirportDAO;
import DAO.UserDAO;
import DTO.entities.Airport;
import DTO.entities.Person;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author agond
 */
public class AirportBUS {
    protected static ArrayList<Airport> list;
    protected static AirportDAO airportDAO;
    private static int quantity = 0;
    
    public AirportBUS() throws ClassNotFoundException, SQLException, IOException {
        userDAO = new UserDAO();
        list = new ArrayList<>(airportDAO.getList());
        quantity = list.size();
    }
    
    public static ArrayList<Airport> getList() {
        return list;
    }
    
    public static int getQuantity() {
        quantity = list.size();
        return quantity;
    }
    
    public static Airport getObjectbyID(String ID){
        for(Airport airport : list){
            if(ID.equals(airport.getAirportID()))
                return airport;
        }
        return null;
    }
    
}
