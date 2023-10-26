/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO.views;

import BUS.AirportBUS;
import BUS.FlightBUS;
import BUS.SeatBUS;
import BUS.TicketBUS;
import BUS.TicketClassBUS;
import DTO.entities.Flight;
import DTO.entities.Ticket;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;


/**
 *
 * @author agond
 */
public class TicketView {
    protected String airline;
    protected String flyingFrom;
    protected String flyingTo;
    protected LocalDateTime departureFlight;
    protected int hoursFly;
    protected int quantity;
    protected int remain;
    
    private ArrayList<String> classes;
    private Map<String, ArrayList<String>> seatsOnClass;
    private Map<String, Integer> pricebyClass;
    public ArrayList<TicketView> ticketViews = new ArrayList<>();

    public TicketView() {
    }

    public String getAirline() {
        return airline;
    }

    public String getFlyingFrom() {
        return flyingFrom;
    }

    public String getFlyingTo() {
        return flyingTo;
    }

    public LocalDateTime getDepartureFlight() {
        return departureFlight;
    }

    public int getHoursFly() {
        return hoursFly;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getRemain() {
        return remain;
    }

    public ArrayList<TicketView> getTicketViews() {
        return ticketViews;
    }
    
    public void setAirline(String airline) {
        this.airline = airline;
    }

    public void setFlyingFrom(String flyingFrom) {
        this.flyingFrom = flyingFrom;
    }

    public void setFlyingTo(String flyingTo) {
        this.flyingTo = flyingTo;
    }

    public void setDepartureFlight(LocalDateTime departureFlight) {
        this.departureFlight = departureFlight;
    }

    public void setHoursFly(int hoursFly) {
        this.hoursFly = hoursFly;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setRemain(int remain) {
        this.remain = remain;
    }

    public void setTicketViews(ArrayList<TicketView> ticketViews) {
        this.ticketViews = ticketViews;
    }
        
    public ArrayList<TicketView> initTicketView(ArrayList<Ticket> tickets) {     
        for (Ticket ticket : tickets) {
            //tìm tên class -> tìm classID -> tìm ID ghế -> tìm vé
            String seatID = TicketBUS.getObjectbyID(ticket.getTicketID()).getSeatID();
            String ticketClassID = SeatBUS.getObjectbyID(seatID).getTicketClassID();
            String ticketClass = TicketClassBUS.getObjectbyID(ticketClassID).getClassName();
            
            classes = new ArrayList<>();
            classes.add(ticketClass);
            
            ArrayList<String> seats = new ArrayList<>();
            String seatName = SeatBUS.getObjectbyID(seatID).getSeatName();
            seats.add(seatName); 
            seatsOnClass.put(ticketClass, seats);
            pricebyClass.put(ticketClass, ticket.getPrice());
                    
            int count = 0;
            int dontSoldOut = 0;
            
            for (Ticket otherTicket : tickets){
                String seatID_OtherTK = TicketBUS.getObjectbyID(ticket.getTicketID()).getSeatID();
                String ticketClassID_OtherTK = SeatBUS.getObjectbyID(seatID_OtherTK).getTicketClassID();
                String ticketClass_OtherTK = TicketClassBUS.getObjectbyID(ticketClassID_OtherTK).getClassName();
                String seatName_OtherTK = SeatBUS.getObjectbyID(seatID_OtherTK).getSeatName();
                
                if(otherTicket.getFlightID().equals(ticket.getFlightID())){ 
                    count++; //quantity
                    if(ticket.getSoldout() == 0) dontSoldOut++; //remain                    
                    
                    //thêm các ghế thuộc các class trên chuyến bay này
                    int have = 0;
                    for (String _class : classes){
                        if(_class.equals(ticketClass_OtherTK)){
                            have = 1;
                            seatsOnClass.get(_class).add(seatName_OtherTK);
                        } 
                    }
                    if(have == 0){
                        classes.add(ticketClass_OtherTK);
                        seats.add(seatName_OtherTK);
                        seatsOnClass.put(ticketClass_OtherTK, seats);
                        pricebyClass.put(ticketClass_OtherTK, otherTicket.getPrice());
                    }
                                      
                }
                
            }            
            TicketView ticketView = new TicketView();
            
            // tìm tên hãng bay
            
            //tìm tên airport -> mã airport -> mã chuyến bay -> ticket
            String airportFromID = FlightBUS.getObjectbyID(ticket.getFlightID()).getFlyingFrom();
            ticketView.setFlyingFrom(AirportBUS.getObjectbyID(airportFromID).getAirportName());
            String airportToID = FlightBUS.getObjectbyID(ticket.getFlightID()).getFlyingTo();
            ticketView.setFlyingTo(AirportBUS.getObjectbyID(airportToID).getAirportName());

            //tìm departureFlight -> mã flight -> ticket
            ticketView.setDepartureFlight(FlightBUS.getObjectbyID(ticket.getFlightID()).getDepartureFlight());
            
            //tìm hoursFly -> mã flight -> ticket
            ticketView.setHoursFly(FlightBUS.getObjectbyID(ticket.getFlightID()).getHoursFly());
            
            ticketView.setQuantity(count);
            ticketView.setRemain(dontSoldOut);
            
            ticketViews.add(ticketView);
        }
        return ticketViews;
    }
    
    public static void getClasses(){
        
    }
    
    
}
