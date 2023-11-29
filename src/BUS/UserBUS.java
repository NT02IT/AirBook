/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.UserDAO;
import DTO.entities.Person;
import java.util.ArrayList;
import DTO.entities.User;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

/**
 *
 * @author agond
 */
public class UserBUS {
    protected static ArrayList<Person> list;
    protected static UserDAO userDAO;
    private static int quantity = 0;

    public UserBUS() throws ClassNotFoundException, SQLException, IOException {
        userDAO = new UserDAO();
        list = new ArrayList<>(userDAO.getList());
        quantity = list.size();
    }

    public ArrayList<Person> getList() {
        return list;
    }
    
    public int getQuantity() {
        quantity = list.size();
        return quantity;
    }    

    public User getByID (String ID) throws SQLException{
        return userDAO.getByID(ID);
    }
    public User getByUsername (String Username) throws SQLException{
        return userDAO.getByUserName(Username);
    }
    public int getTotalTypeAccountByRoleID(String roleID) throws SQLException{
        return userDAO.getTotalAccountByRoleID(roleID);
    }
    public User deleteUser (User user) throws SQLException{
        userDAO.delete(user);
        list.remove(user);
        return null;
    }
    public User signIn(User user) throws NoSuchAlgorithmException{
        user.setPwd(User.hashPassword(user.getPwd()));
        User temp;
        for(Person _user : list){
            temp = (User)_user;
            if(user.getEmail().equals(temp.getEmail()) && user.getPwd().equals(temp.getPwd())) return temp;
            if(user.getUsername().equals(temp.getUsername()) && user.getPwd().equals(temp.getPwd())) return temp;
        }
        return null;
    }
    
    public boolean checkUnique(User user){
        User temp;
        for(Person _user : list){
            temp = (User)_user;
            if(user.getEmail().equals(temp.getEmail())) return false;
            if(user.getUsername().equals(temp.getUsername())) return false;
        }
        return true;
    }
    
    public void signUp(User user) throws NoSuchAlgorithmException, ClassNotFoundException, SQLException{
        user.setPwd(User.hashPassword(user.getPwd()));
        userDAO.create(user);
        list.add(user);  
        quantity = list.size();
    }
    
    public boolean update(User user) throws SQLException, NoSuchAlgorithmException {
        user.setPwd(User.hashPassword(user.getPwd()));
        return userDAO.update(user);
    }
}
