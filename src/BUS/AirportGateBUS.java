/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DAO.AirportGateDAO;
import DTO.entities.AirportGate;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author WIN 10
 */
public class AirportGateBUS {
    protected static ArrayList<AirportGate> list;
    protected static AirportGateDAO airportDAO;
    private static int quantity = 0;
    
    public AirportGateBUS() throws ClassNotFoundException, SQLException, IOException {
        airportDAO = new AirportGateDAO();
        list = new ArrayList<>(airportDAO.getList());
        quantity = list.size();
    }
        
    public ArrayList<AirportGate> getList() {
        return list;
    }
    
    public int getQuantity() {
        quantity = list.size();
        return quantity;
    }
    
    public ArrayList<AirportGate> getAllGateByAirlineID(String ID) throws IOException, ClassNotFoundException, SQLException{
        return airportDAO.getAllGatesByAirportID(ID);
    }
}
