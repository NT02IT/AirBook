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
import DAO.TicketClassDAO;
import DTO.entities.Ticket;
import DTO.entities.TicketClass;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Map;


/**
 *
 * @author agond
 */
public class TicketViewsOLD {
    public class TicketView{
        public String airline;
        public String flyingFrom;
        public String flyingTo;
        public LocalDateTime departureFlight;
        public int hoursFly;
        public int quantity;
        public int remain;    
        
        public ArrayList<String> classes;
        public Map<String, ArrayList<String>> seatsOnClass;
        public Map<String, Integer> pricebyClass;

        @Override
        public String toString() {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            String departureFlightCustom = departureFlight.format(formatter);
            return airline + flyingFrom + flyingTo + departureFlightCustom;
        }
    }    
    
    private SeatBUS seatBUS;
    private TicketClassBUS ticketClassBUS;
    private PlaneBUS planeBUS;
    
    private ArrayList<TicketView> list;

//    public TicketViews() throws ClassNotFoundException, SQLException, IOException {
//        list = new ArrayList<>();
//        this.seatBUS = new SeatBUS();
//        this.ticketClassBUS = new TicketClassBUS();
//        this.planeBUS = new PlaneBUS();
//    }    
//    public TicketViews(ArrayList<Ticket> tickets) throws ClassNotFoundException, SQLException, IOException {
//        list = new ArrayList<>();
//        this.seatBUS = new SeatBUS();
//        this.ticketClassBUS = new TicketClassBUS();
//        this.planeBUS = new PlaneBUS();
//        init(tickets);
//    }
    
    public ArrayList<TicketView> getList() {
        return list;
    }    
        
    public ArrayList<TicketView> init(ArrayList<Ticket> tickets) throws ClassNotFoundException, SQLException, IOException {
        TicketClassDAO ticketClassDAO = new TicketClassDAO();
        for (Ticket currentTicket : tickets) { 
            if(currentTicket.getIsDelete() == 0){
                TicketView tvItem = new TicketView();

                String seatID_currentTK = currentTicket.getSeatID();
                String flightID_currentTK = currentTicket.getFlightID();            
                String classID_currentTK = seatBUS.getObjectbyID(seatID_currentTK).getTicketClassID();

                String planeID_currentTK = ticketClassBUS.getObjectbyID(classID_currentTK).getPlaneID();
                String airlineID_currentTK = planeBUS.getObjectbyID(planeID_currentTK).getAirlineID();

//                String className_currentTK = ticketClassBUS.getObjectbyID(classID_currentTK).getClassName();
//                ArrayList<String> classes = new ArrayList<>();
//                classes.add(className_currentTK);     
//                tvItem.classes = classes;
                ArrayList<TicketClass> ticketClasses = ticketClassDAO.getAllClassNameByAirlineIDFlightID(airlineID_currentTK, flightID_currentTK);
                tvItem.classes = new ArrayList<>();
                for(TicketClass ticketClass : ticketClasses){
                    tvItem.classes.add(ticketClass.getClassName());
                }

//                String seatName_currentTK = seatBUS.getObjectbyID(seatID_currentTK).getSeatName();
//                ArrayList<String> seats = new ArrayList<>();
//                seats.add(seatName_currentTK);
//                Map<String, ArrayList<String>> seatsOnClass = new LinkedHashMap<>();
//                seatsOnClass.put(className_currentTK, seats);
//                tvItem.seatsOnClass = seatsOnClass;

//                Map<String, Integer> pricebyClass = new LinkedHashMap<>();
//                int price_currentTK = currentTicket.getImportPrice();
//                pricebyClass.put(className_currentTK, price_currentTK);
//                tvItem.pricebyClass = pricebyClass;

                int quantity = 0;
                int remain = 0;
                for (Ticket otherTicket : tickets){
                    //So sánh Flight và Airline của currentTicket và các otherTicket 
                    //      -> nếu trùng 
                    //          -> tăng quantity lên (với isDelete == false)
                    //          -> tăng remain lên (với soldout == false)
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
//                        String className_otherTK = ticketClassBUS.getObjectbyID(classID_otherTK).getClassName();
//                        String seatName_otherTK = seatBUS.getObjectbyID(seatID_otherTK).getSeatName();
//                        boolean haveClass = false;
//                        for(String _class : classes){
//                            if(_class.equals(className_otherTK)){
//                                haveClass = true;
//                                seatsOnClass.get(_class).add(seatName_otherTK);
//                            }
//                        }
//                        if(!haveClass){
//                            int price_otherTK = otherTicket.getImportPrice();
//                            classes.add(className_otherTK);
//                            seats = new ArrayList<>();
//                            seats.add(seatName_otherTK);
//                            seatsOnClass.put(className_otherTK, seats);
//                            pricebyClass.put(className_otherTK, price_otherTK);
//                        }
                    }                
                } 
                tvItem.quantity = quantity;
                tvItem.remain = remain;

                AirlineBUS airline = new AirlineBUS();
                String airlineName = airline.getObjectbyID(airlineID_currentTK).getAirlineName();
                tvItem.airline = airlineName;

                FlightBUS flightBUS = new FlightBUS();
                AirportBUS airportBUS = new AirportBUS();
                String flyingFromID = flightBUS.getObjectbyID(flightID_currentTK).getFlyingFrom();
                String flyingFrom = airportBUS.getObjectbyID(flyingFromID).getAirportName();
                tvItem.flyingFrom = flyingFrom;

                String flyingToID = flightBUS.getObjectbyID(flightID_currentTK).getFlyingTo();
                String flyingTo = airportBUS.getObjectbyID(flyingToID).getAirportName();
                tvItem.flyingTo = flyingTo;

                LocalDateTime departureFlight = flightBUS.getObjectbyID(flightID_currentTK).getDepartureFlight();
                tvItem.departureFlight = departureFlight;    

                int hoursFly = flightBUS.getObjectbyID(flightID_currentTK).getHoursFly();            
                tvItem.hoursFly = hoursFly;
                list.add(tvItem);
            }
        }
        
        for(int i = 0; i < list.size(); i++){
            //Lọc trùng
            for(int j = i+1; j<list.size(); j++)
                if(list.get(i).toString().equals(list.get(j).toString()))
                    list.remove(j);
            //Thêm các hạng vé
            
        }

        return list;
    }
    
    public TicketView findObjectByPatternUnique(String patternUnique){
//        for(TicketView tkView : list){
//            System.out.println(tkView);
//            if(patternUnique.equals(tkView)) return tkView;            
//        }
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).toString().equals(patternUnique)) return list.get(i);
        }
        return null;
    }
}
