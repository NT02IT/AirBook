/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO.views;

import BUS.PlaneBUS;
import DTO.entities.Plane;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Admin
 */
public class PlaneViews {
        public class PlaneView{
        public String MaMayBay;
        public String TenMayBay;
        public int SoGhe;
        public String MaHangBay;
        @Override
        public String toString() {
            return MaMayBay;
        } 
        public String getAirlineID(){
            return MaHangBay;
        }
        public String getPlaneID(){
            return MaMayBay;
        }        
        public String getPlaneName(){
            return TenMayBay;
        }        
        public int getSeats(){
            return SoGhe;
        }        
    }
    public ArrayList<PlaneView> list;
    private PlaneBUS planeBUS;
    public PlaneViews() throws ClassNotFoundException, SQLException, IOException {
        list = new ArrayList<>();
        planeBUS = new PlaneBUS();
    }
    public PlaneViews (ArrayList<Plane> planes) throws ClassNotFoundException, SQLException, IOException {
        list = new ArrayList<>();
        planeBUS = new PlaneBUS();
        init(planes);
    }
    
    public ArrayList<PlaneView> getList(){
        return list;
    }
        
    private ArrayList<PlaneView> init(ArrayList<Plane> planes){
        for(Plane plane : planes){
            PlaneView pvItem = new PlaneView();
            pvItem.MaMayBay = plane.getPlaneID();
            pvItem.TenMayBay = plane.getPlaneName();
            pvItem.SoGhe = plane.getSeats();
            pvItem.MaHangBay = plane.getAirlineID();
            list.add(pvItem);
        }
        return list;
    }
}
