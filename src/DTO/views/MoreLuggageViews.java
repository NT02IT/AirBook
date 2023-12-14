/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO.views;

import BUS.MoreLuggageBUS;
import DTO.entities.MoreLuggage;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class MoreLuggageViews {
    public class MoreLuggageView{

        public int GiaThanh;
        public int KhoiLuong;
        public String MaHangBay;

        public String getAirlineID(){
            return MaHangBay;
        }      
        public int getLuggageWeight(){
            return KhoiLuong;
        }        
        public int getPrice(){
            return GiaThanh;
        }        
    }
    public ArrayList<MoreLuggageView> list;
    private MoreLuggageBUS moreLuggageBUS;
    public MoreLuggageViews() throws ClassNotFoundException, SQLException, IOException {
        list = new ArrayList<>();
        moreLuggageBUS = new MoreLuggageBUS();
    }
    public MoreLuggageViews (ArrayList<MoreLuggage> moreLuggage) throws ClassNotFoundException, SQLException, IOException {
        list = new ArrayList<>();
        moreLuggageBUS = new MoreLuggageBUS();
        init(moreLuggage);
    }
    
    public ArrayList<MoreLuggageView> getList(){
        return list;
    }
        
    private ArrayList<MoreLuggageView> init(ArrayList<MoreLuggage> moreLuggages){
        for(MoreLuggage moreLuggage : moreLuggages){
            MoreLuggageView mlvItem = new MoreLuggageView();
            mlvItem.GiaThanh = moreLuggage.getPrice();
            mlvItem.KhoiLuong = moreLuggage.getLuggageWeight();
            mlvItem.MaHangBay = moreLuggage.getAirlineID();
            list.add(mlvItem);
        }
        return list;
    }
}
