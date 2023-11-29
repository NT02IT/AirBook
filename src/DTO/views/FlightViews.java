package DTO.views;
import BUS.AirportBUS;
import BUS.FlightBUS;
import DTO.entities.Flight;
import assets.DateTime;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
public class FlightViews {
    public class FlightView{
        public String GaDi;
        public String GaDen;
        public int SoGioBay;
        public LocalDateTime KhoiHanh;
    }
    public ArrayList<FlightView> list;
    private FlightBUS flightBUS;
    private AirportBUS airportBUS;
    public FlightViews() throws ClassNotFoundException, SQLException, IOException {
        list = new ArrayList<>();
        flightBUS = new FlightBUS();
        airportBUS = new AirportBUS();
    }
    public FlightViews(ArrayList<Flight> flights) throws ClassNotFoundException, SQLException, IOException {
        list = new ArrayList<>();
        flightBUS = new FlightBUS();
        airportBUS = new AirportBUS();
        init(flights);
    }
    public ArrayList<FlightView> getList(){
        return list;
    }
    private ArrayList<FlightView> init(ArrayList<Flight> flights){
        for(Flight flight : flights){
            FlightView fvItem = new FlightView();
            fvItem.GaDi = flight.getFlyingFrom();
            fvItem.GaDen = flight.getFlyingTo();
            fvItem.SoGioBay = flight.getHoursFly();
            fvItem.KhoiHanh = flight.getDepartureFlight();            
            list.add(fvItem);
        }
        return list;
    } 
}
