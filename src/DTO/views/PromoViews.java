/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO.views;

import BUS.AirlineBUS;
import BUS.PromoBUS;
import DTO.entities.FlatDiscount;
import DTO.entities.PercentDiscount;
import DTO.entities.Promotion;
import assets.DateTime;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author agond
 */
public class PromoViews {
    public class PromoView{
        public String MaKhuyenMai;
        public String HangBay;
        public String NgayKetThuc;
        public String KhuyenMai;

        @Override
        public String toString() {
            return MaKhuyenMai;
        } 
    }
    
    public ArrayList<PromoView> list;
    private PromoBUS promoBUS;
    private AirlineBUS airlineBUS;

    public PromoViews() throws ClassNotFoundException, SQLException, IOException {
        list = new ArrayList<>();
        promoBUS = new PromoBUS();
        airlineBUS = new AirlineBUS();
    }
    public PromoViews(ArrayList<Promotion> promotions) throws ClassNotFoundException, SQLException, IOException {
        list = new ArrayList<>();
        promoBUS = new PromoBUS();
        airlineBUS = new AirlineBUS();
        init(promotions);
    }
    
    public ArrayList<PromoView> getList(){
        return list;
    }
    
    private ArrayList<PromoView> init(ArrayList<Promotion> promotions){
        for(Promotion promotion : promotions){
            PromoView pvItem = new PromoView();
            if(promotion instanceof FlatDiscount){
                try {
                    pvItem.MaKhuyenMai = promotion.getPromoID();
                    pvItem.HangBay = promotion.getAirlineID();
                    pvItem.NgayKetThuc = DateTime.convertFormat(promotion.getDateEnd().toString(), "yyyy-MM-dd", "dd/MM/yyyy");
                    pvItem.KhuyenMai = ((FlatDiscount)promotion).getDecreased() + "đ";
                    list.add(pvItem);
                } catch (ParseException ex) {
                    Logger.getLogger(PromoViews.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                try {
                    pvItem.MaKhuyenMai = promotion.getPromoID();
                    pvItem.HangBay = promotion.getAirlineID();
                    pvItem.NgayKetThuc = DateTime.convertFormat(promotion.getDateEnd().toString(), "yyyy-MM-dd", "dd/MM/yyyy");
                    pvItem.KhuyenMai = ((PercentDiscount)promotion).getDecreased() + "%";
                    list.add(pvItem);
                } catch (ParseException ex) {
                    Logger.getLogger(PromoViews.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list;
    }
}
