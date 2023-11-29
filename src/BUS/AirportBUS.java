/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.AirportDAO;
import DAO.UserDAO;
import DTO.entities.Airport;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author agond
 */
public class AirportBUS {
    protected static ArrayList<Airport> list;
    protected static AirportDAO airportDAO;
    private static int quantity = 0;
    
    public AirportBUS() throws ClassNotFoundException, SQLException, IOException {
        airportDAO = new AirportDAO();
        list = new ArrayList<>(airportDAO.getList());
        quantity = list.size();
    }
        
    public ArrayList<Airport> getList() {
        return list;
    }
    
    public int getQuantity() {
        quantity = list.size();
        return quantity;
    }
    
    public Airport getObjectbyID(String ID){
        for(Airport airport : list){
            if(ID.equals(airport.getAirportID()))
                return airport;
        }
        return null;
    }
    
    public String getIDByName(String airportName) throws SQLException{
    } 

}
