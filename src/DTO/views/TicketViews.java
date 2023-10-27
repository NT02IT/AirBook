/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO.views;

import BUS.AirlineBUS;
import BUS.AirportBUS;
import BUS.FlightBUS;
import BUS.PlaneBUS;
import BUS.SeatBUS;
import BUS.TicketClassBUS;
import DTO.entities.Ticket;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 *
 * @author agond
 */
public class TicketViews {
    public class TicketView{
        private String airline;
        private String flyingFrom;
        private String flyingTo;
        private LocalDateTime departureFlight;
        private int hoursFly;
        private int quantity;
        private int remain;    
        
        private ArrayList<String> classes;
        private Map<String, ArrayList<String>> seatsOnClass;
        private Map<String, Integer> pricebyClass;
        
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

        public void setClasses(ArrayList<String> classes) {
            this.classes = classes;
        }

        public void setSeatsOnClass(Map<String, ArrayList<String>> seatsOnClass) {
            this.seatsOnClass = seatsOnClass;
        }

        public void setPricebyClass(Map<String, Integer> pricebyClass) {
            this.pricebyClass = pricebyClass;
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

        public ArrayList<String> getClasses() {
            return classes;
        }

        public Map<String, ArrayList<String>> getSeatsOnClass() {
            return seatsOnClass;
        }

        public Map<String, Integer> getPricebyClass() {
            return pricebyClass;
        }   

        @Override
        public String toString() {
            return "TicketView{" + "airline=" + airline + ", flyingFrom=" + flyingFrom + ", flyingTo=" + flyingTo + ", departureFlight=" + departureFlight + ", hoursFly=" + hoursFly + ", quantity=" + quantity + ", remain=" + remain + ", classes=" + classes + ", seatsOnClass=" + seatsOnClass + ", pricebyClass=" + pricebyClass + '}';
        }
    }    
    
    private SeatBUS seatBUS;
    private TicketClassBUS ticketClassBUS;
    private PlaneBUS planeBUS;
    
    private ArrayList<TicketView> list;

    public TicketViews() throws ClassNotFoundException, SQLException, IOException {
        list = new ArrayList<>();
        this.seatBUS = new SeatBUS();
        this.ticketClassBUS = new TicketClassBUS();
        this.planeBUS = new PlaneBUS();
    }    
    public TicketViews(ArrayList<Ticket> tickets) throws ClassNotFoundException, SQLException, IOException {
        list = new ArrayList<>();
        this.seatBUS = new SeatBUS();
        this.ticketClassBUS = new TicketClassBUS();
        this.planeBUS = new PlaneBUS();
        init(tickets);
    }
    
    public ArrayList<TicketView> getList() {
        return list;
    }    
        
    public ArrayList<TicketView> init(ArrayList<Ticket> tickets) throws ClassNotFoundException, SQLException, IOException {
        for (Ticket currentTicket : tickets) { 
            TicketView tvItem = new TicketView();
            //tìm airlineName <- airline_ID <- Plane_ID <- ticket_class_id <- seat_ID <- TICKET OBJ
            //tìm fromAirport <- flyingFromID <- flight_ID <- TICKET OBJ
            //tìm toAirport <- flyingToID <- flight_ID <- TICKET OBJ
            //tìm departureFlight <- flight_ID <- TICKET OBJ
            //tìm hoursFly <- flight_ID <- TICKET OBJ
            //tìm quantity <- ticket_isdelete <- TICKET OBJ
            //tìm remain <- ticket_soldout <- TICKET OBJ
            //tìm classes <- ticket_class <- ticket_class_id <- seat_id <- TICKET OBJ
            //tìm seatsOnClass <- seatName <- seat_ID <- TICKET OBJ
            //tìm pricebyClass <- ticketclassID <- seat_id <- TICKET OBJ
            
            String seatID_currentTK = currentTicket.getSeatID();
            String flightID_currentTK = currentTicket.getFlightID();            
            String classID_currentTK = seatBUS.getObjectbyID(seatID_currentTK).getTicketClassID();
            
            String planeID_currentTK = ticketClassBUS.getObjectbyID(classID_currentTK).getPlaneID();
            String airlineID_currentTK = planeBUS.getObjectbyID(planeID_currentTK).getAirlineID();
            
            String className_currentTK = ticketClassBUS.getObjectbyID(classID_currentTK).getClassName();
            ArrayList<String> classes = new ArrayList<>();
            classes.add(className_currentTK);     
            
            String seatName_currentTK = seatBUS.getObjectbyID(seatID_currentTK).getSeatName();
            ArrayList<String> seats = new ArrayList<>();
            seats.add(seatName_currentTK);
            Map<String, ArrayList<String>> seatsOnClass = new LinkedHashMap<>();
            seatsOnClass.put(className_currentTK, seats);
            
            Map<String, Integer> pricebyClass = new LinkedHashMap<>();
            int price_currentTK = currentTicket.getPrice();
            pricebyClass.put(className_currentTK, price_currentTK);
            
            int quantity = 0;
            int remain = 0;
            for (Ticket otherTicket : tickets){
                //So sánh Flight và Airline của currentTicket và các otherTicket 
                //      -> nếu trùng 
                //          -> tăng quantity lên (với isDelete == false)
                //          -> tăng remain lên (với soldout == false)
                //          -> thêm các ghế thuộc các class trên chuyến bay này
                String seatID_otherTK = otherTicket.getSeatID();
                String classID_otherTK = seatBUS.getObjectbyID(seatID_otherTK).getTicketClassID();
                    
                String planeID_otherTK = ticketClassBUS.getObjectbyID(classID_otherTK).getPlaneID();
                String airlineID_otherTK = planeBUS.getObjectbyID(planeID_otherTK).getAirlineID();
                String flightID_otherTK = otherTicket.getFlightID();
                if(flightID_otherTK.equals(flightID_currentTK) && airlineID_otherTK.equals(airlineID_currentTK)){
                    if(otherTicket.getIsDelete() == 0)
                        quantity++;
                    if(otherTicket.getSoldout() == 0)
                        remain++;
                    
                    //so sánh tkClass của otherTK với các tkClass đã có 
                    //          -> nếu trùng thì thêm ghế của otherTK vào tkClass này
                    //          -> nếu không trùng thì thêm tkClass của otherTK vào classes và thêm ghế + giá vào
                    String className_otherTK = ticketClassBUS.getObjectbyID(classID_otherTK).getClassName();
                    String seatName_otherTK = seatBUS.getObjectbyID(seatID_otherTK).getSeatName();
                    boolean haveClass = false;
                    for(String _class : classes){
                        if(_class.equals(className_otherTK)){
                            haveClass = true;
                            seatsOnClass.get(_class).add(seatName_otherTK);
                        }
                    }
                    if(!haveClass){
                        int price_otherTK = otherTicket.getPrice();
                        classes.add(className_otherTK);
                        seats = new ArrayList<>();
                        seats.add(seatName_otherTK);
                        seatsOnClass.put(className_otherTK, seats);
                        pricebyClass.put(className_otherTK, price_otherTK);
                    }
                }                
            } 
            tvItem.setQuantity(quantity);
            tvItem.setRemain(remain);
            
            AirlineBUS airline = new AirlineBUS();
            String airlineName = airline.getObjectbyID(airlineID_currentTK).getAirlineName();
            tvItem.setAirline(airlineName);
            
            FlightBUS flightBUS = new FlightBUS();
            AirportBUS airportBUS = new AirportBUS();
            String flyingFromID = flightBUS.getObjectbyID(flightID_currentTK).getFlyingFrom();
            String flyingFrom = airportBUS.getObjectbyID(flyingFromID).getAirportName();
            tvItem.setFlyingFrom(flyingFrom);
            
            String flyingToID = flightBUS.getObjectbyID(flightID_currentTK).getFlyingTo();
            String flyingTo = airportBUS.getObjectbyID(flyingToID).getAirportName();
            tvItem.setFlyingTo(flyingTo);
            
            LocalDateTime departureFlight = flightBUS.getObjectbyID(flightID_currentTK).getDepartureFlight();
            tvItem.setDepartureFlight(departureFlight);    
            
            int hoursFly = flightBUS.getObjectbyID(flightID_currentTK).getHoursFly();            
            tvItem.setHoursFly(hoursFly);
            list.add(tvItem);
        }
        
        //Lọc trùng
        for(int i = 0; i < list.size(); i++){
            for(int j = i+1; j<list.size(); j++)
                if(list.get(i).toString().equals(list.get(j).toString()))
                    list.remove(j);
        }

        return list;
    }
}
