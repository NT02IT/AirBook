/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO.views;

import BUS.AirportBUS;
import DAO.AirportDAO;
import DTO.entities.Airport;
import assets.DateTime;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
public class AirportViews {
    public class AirportView{
        public String MaCang;
        public String TenCang;
        public String ThanhPho;
        @Override
        public String toString() {
            return MaCang;
        } 
    }
    public ArrayList<AirportView> list;
    private AirportBUS airportBUS;
    public AirportViews() throws ClassNotFoundException, SQLException, IOException {
        list = new ArrayList<>();
        airportBUS = new AirportBUS();
    }
    public AirportViews(ArrayList<Airport> airports) throws ClassNotFoundException, SQLException, IOException {
        list = new ArrayList<>();
        airportBUS = new AirportBUS();
        init(airports);
    }
    
    public ArrayList<AirportView> getList(){
        return list;
    }
    
    private ArrayList<AirportView> init(ArrayList<Airport> airports){
        for(Airport airport : airports){
            AirportView avItem = new AirportView();
            avItem.MaCang = airport.getAirportID();
            avItem.TenCang = airport.getAirportName();
            avItem.ThanhPho = airport.getProvince();
            list.add(avItem);
        }
        return list;
    }        
}
