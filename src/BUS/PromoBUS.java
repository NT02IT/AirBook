/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.PromoDAO;
import DTO.entities.FlatDiscount;
import DTO.entities.PercentDiscount;
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
    public boolean createNewPromoPer(PercentDiscount p) throws ClassNotFoundException, SQLException{
        return promoDAO.createPercent(p);
    }
    public boolean createNewPromoFlat(FlatDiscount p) throws ClassNotFoundException, SQLException{
        return promoDAO.createFlat(p);
    }
    public boolean updatePromo(PercentDiscount p, int promoType) throws ClassNotFoundException, SQLException{
        return promoDAO.update(p, promoType);
    }
    public boolean deletePromo(String id) throws ClassNotFoundException, SQLException{
        return promoDAO.delete(id);
    }
}
