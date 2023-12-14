/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.FlightDAO;
import DTO.entities.Airline;
import DTO.entities.Flight;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author agond
 */
public class FlightBUS {
    protected static ArrayList<Flight> list;
    protected static FlightDAO flightDAO;
    private static int quantity = 0;

    public FlightBUS() throws ClassNotFoundException, SQLException, IOException {
        flightDAO = new FlightDAO();
        list = new ArrayList<>(flightDAO.getList());
        quantity = list.size();
    }

    public ArrayList<Flight> getList() {
        return list;
    }
    
    public int getQuantity() {
        quantity = list.size();
        return quantity;
    }
    
    public Flight getObjectbyID(String ID){
        for(Flight flight : list){
            if(ID.equals(flight.getFlightID()))
                return flight;
        }
        return null;
    }
    
    public String getIDByDetail(String FromAirport, String ToAirport, String Departure) throws IOException, ClassNotFoundException, SQLException, ParseException{
        String result = flightDAO.getIDByDetail(FromAirport, ToAirport, Departure);
        return result;        
    }
    
    public static ArrayList<Flight> getReturnFlight(Flight flight, Airline airline) throws SQLException{
        ArrayList<Flight> result = new ArrayList<>();
        ArrayList<Flight> allFlight = flightDAO.getAllFlightOfAirline(airline);
        for(Flight fl : allFlight){
            if(fl.getFlyingFrom().equals(flight.getFlyingTo()) && fl.getFlyingTo().equals(flight.getFlyingFrom())){
                result.add(fl);
            }
        }
        return result;
    }
    public ArrayList<Flight> getAllFlightOfAirline(Airline airline) throws SQLException{
        return flightDAO.getAllFlightOfAirline(airline);
    }
    
}
