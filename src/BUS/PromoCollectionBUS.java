/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.PromoCollectionDAO;
import DTO.entities.Airline;
import DTO.entities.PromoCollection;
import DTO.entities.User;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author agond
 */
public class PromoCollectionBUS {
    protected static ArrayList<PromoCollection> list;
    protected static PromoCollectionDAO promoCollectionDAO;
    private static int quantity = 0;

    public PromoCollectionBUS() throws ClassNotFoundException, SQLException, IOException {
        promoCollectionDAO = new PromoCollectionDAO();
        list = new ArrayList<>(promoCollectionDAO.getList());
        quantity = list.size();
    }

    public ArrayList<PromoCollection> getList() {
        return list;
    }
    
    public int getQuantity() {
        quantity = list.size();
        return quantity;
    }
    
    public PromoCollection getObjectbyID(String ID){
        for(PromoCollection pc : list){
            if(ID.equals(pc.getPromo_collection_ID()))
                return pc;
        }
        return null;
    }
    
    public ArrayList<PromoCollection> getList(User user){
        ArrayList<PromoCollection> result = new ArrayList<>();
        for(PromoCollection pc : list){
            if(pc.getUser_ID().equals(user.getID())) result.add(pc);
        }
        return result;
    }
    
    public ArrayList<PromoCollection> getList(User user, Airline airline){
        ArrayList<PromoCollection> result = new ArrayList<>();
        try {
            PromoBUS promoBUS = new PromoBUS();            
            String airlineID;
            for(PromoCollection pc : list){
                airlineID = promoBUS.getObjectbyID(pc.getPromo_ID()).getAirlineID();
                if(pc.getUser_ID().equals(user.getID()) && airlineID.equals(airline.getAirlineID())) result.add(pc);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PromoCollectionBUS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PromoCollectionBUS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PromoCollectionBUS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public boolean create(PromoCollection prmc) throws ClassNotFoundException, SQLException{
        for(PromoCollection item : list){
            if(item.getPromo_ID().equals(prmc.getPromo_ID()) && item.getUser_ID().equals(prmc.getUser_ID())) return false;
        }
        return promoCollectionDAO.create(prmc);
    }
}
