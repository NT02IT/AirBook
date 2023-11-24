/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO.views;

import DTO.entities.Ticket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author agond
 */
public class TicketView {
    Map<String, ArrayList<Ticket>> list;
    
    public TicketView(ArrayList<Ticket> listTicket){
        list = new HashMap<>();
        ArrayList<Ticket> tickets;
        for(Ticket ticket : listTicket){
            String key = ticket.getFlightIDGateID();
            if(!list.containsKey(key)){
                tickets = new ArrayList<>();
                tickets.add(ticket);
                list.put(key, tickets);
            } else{
                list.get(key).add(ticket);
            }
        }
    }
    
    public Map<String, ArrayList<Ticket>> getList(){
        return list;
    }
}
