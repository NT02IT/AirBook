/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.ReceiverDAO;
import DTO.entities.Person;
import DTO.entities.Receiver;
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
public class ReceiverBUS {
    protected static ArrayList<Person> list;
    protected static ReceiverDAO receiverDAO;
    private static int quantity = 0;

    public ReceiverBUS() throws ClassNotFoundException, SQLException, IOException {
        receiverDAO = new ReceiverDAO();
        list = new ArrayList<>(receiverDAO.getList());
        quantity = list.size();
    }

    public ArrayList<Person> getList() {
        return list;
    }
    
    public int getQuantity() {
        quantity = list.size();
        return quantity;
    }
    
    public int create(Receiver data){
        try {
            receiverDAO.create(data);
            list.add(data);
            return 0; //Thêm thành công
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReceiverBUS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ReceiverBUS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1; //Thêm không thành công
    }
    
    public int create(User data){
        try {
            Receiver receiver = new Receiver(data);
            receiverDAO.create(receiver);
            list.add(receiver);
            return 0; //Thêm thành công
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReceiverBUS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ReceiverBUS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1; //Thêm không thành công
    }
    
    public ArrayList<Receiver> getListFromUser(User user){
        Receiver receiver;
        ArrayList<Receiver> result = new ArrayList<>();
        for(Person r : list){
            receiver = (Receiver)r;
            if(user.getID().equals(receiver.getUserCreateID())){
                result.add(receiver);
            }
        }
        return result;
    }
    
    public static Person getObjectByID(String ID){
        for(Person r : list){
            if (r.getID().equals(ID)) {
                return r;
            }
        }
        return null;
    }
}
