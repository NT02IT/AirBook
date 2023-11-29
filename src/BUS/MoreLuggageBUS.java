/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.MoreLuggageDAO;
import DTO.entities.MoreLuggage;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author agond
 */
public class MoreLuggageBUS {
    protected static ArrayList<MoreLuggage> list;
    protected static MoreLuggageDAO moreLuggageDAO;
    private static int quantity = 0;
    
    public MoreLuggageBUS() throws ClassNotFoundException, SQLException, IOException {
        moreLuggageDAO = new MoreLuggageDAO();
        list = new ArrayList<>(moreLuggageDAO.getList());
        quantity = list.size();
    }
    
    public ArrayList<MoreLuggage> getList() {
        return list;
    }
    
    public int getQuantity() {
        quantity = list.size();
        return quantity;
    }
    
    public MoreLuggage getObjectbyID(String ID){
        for(MoreLuggage moreLuggage : list){
            if(ID.equals(moreLuggage.getMoreLuggageID()))
                return moreLuggage;
        }
        return null;
    }
    
    public ArrayList<MoreLuggage> getObjectbyAirlineID(String Airline_ID){
        ArrayList<MoreLuggage> result = new ArrayList<>();
        for(MoreLuggage ml : list){
            if (Airline_ID.equals(ml.getAirlineID())) {
                result.add(ml);
            }
        }
        return result;
    }
    
    public MoreLuggage getObjectbyWeight(int weight){
        for(MoreLuggage ml : list){
            if(weight == ml.getLuggageWeight())
                return ml;
        }
        return null;
    }
}
