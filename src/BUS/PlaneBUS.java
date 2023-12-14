/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.PlaneDAO;
import DAO.TicketDAO;
import DTO.entities.Plane;
import DTO.entities.Ticket;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author agond
 */
public class PlaneBUS {
    protected static ArrayList<Plane> list;
    protected static PlaneDAO planeDAO;
    private static int quantity = 0;

    public PlaneBUS() throws ClassNotFoundException, SQLException, IOException {
        planeDAO = new PlaneDAO();
        list = new ArrayList<>(planeDAO.getList());
        quantity = list.size();
    }

    public ArrayList<Plane> getList() {
        return list;
    }
    
    public int getQuantity() {
        quantity = list.size();
        return quantity;
    }
    
    public Plane getObjectbyID(String ID){
        for(Plane plane : list){
            if(ID.equals(plane.getPlaneID()))
                return plane;
        }
        return null;
    }

    public ArrayList<Plane> getAllPlaneByAirline(String airlineID ) throws ClassNotFoundException, SQLException{
        return planeDAO.getPlaneListByAirlineID(airlineID);
    }

    
    public boolean delete(Plane plane) throws ClassNotFoundException, SQLException{
        return planeDAO.deletePlane(plane);
    }

    public boolean create(Plane plane) throws ClassNotFoundException, SQLException{
        return planeDAO.create(plane);
    }

    public boolean update(Plane plane) throws ClassNotFoundException, SQLException{
        return planeDAO.updatePlane(plane);
    }    

}
