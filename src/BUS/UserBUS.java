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
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author agond
 */
public class UserBUS {
    protected ArrayList<Person> list;
    protected UserDAO userDAO;
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
    
    public User signIn(User user){
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
    
    public void create(User user){
        userDAO.create(user);
        list.add(user);  
        quantity = list.size();
    }
}
