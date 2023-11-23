/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.PromoDAO;
import DTO.entities.Promotion;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author agond
 */
public class PromoBUS {
    protected static ArrayList<Promotion> list;
    protected static PromoDAO promoDAO;
    private static int quantity = 0;
    
    public PromoBUS() throws ClassNotFoundException, SQLException, IOException {
        promoDAO = new PromoDAO();
        list = new ArrayList<>(promoDAO.getList());
        quantity = list.size();
    }
    
    public ArrayList<Promotion> getList() {
        return list;
    }
    
    public int getQuantity() {
        quantity = list.size();
        return quantity;
    }
}
