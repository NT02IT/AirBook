
package DTO.views;
import BUS.AirlineBUS;
import BUS.TicketBUS;
import BUS.PlaneBUS;
import DAO.PlaneDAO;
import DTO.entities.Plane;
import DAO.AirlineDAO;
import DTO.entities.Airline;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AirlineViews {
   public class AirlineView{
        public String MaHangMayBay;
        public String TenHangBay;
        public int SoMayBay;
        public int DoanhThu;
        @Override
        public String toString() {
            return MaHangMayBay;
        }
    }
    public ArrayList<AirlineView> list;
    private AirlineBUS airlineBUS;
    private PlaneBUS planeBUS;
    public AirlineViews() throws ClassNotFoundException, SQLException, IOException {
        list = new ArrayList<>();
        airlineBUS = new AirlineBUS();
    }
    public AirlineViews(ArrayList<Airline> airlines) throws ClassNotFoundException, SQLException, IOException {
        list = new ArrayList<>();
        airlineBUS = new AirlineBUS();
        init(airlines);
    }
    
    public ArrayList<AirlineView> getList(){
        return list;
    }  
    
    private ArrayList<AirlineView> init(ArrayList<Airline> airlines){
        for(Airline airline : airlines){
            AirlineView alItem = new AirlineView();
            alItem.MaHangMayBay = airline.getAirlineID();
            alItem.TenHangBay = airline.getAirlineName();
            alItem.SoMayBay = airline.getTotalPlanesByAirlineID(airline.getAirlineID());
            list.add(alItem);
        }
           return list;
    }

    
}
