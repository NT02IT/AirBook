/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.RoleDAO;
import DTO.entities.Role;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

/**
 *
 * @author WIN 10
 */
public class RoleBUS {
    protected  static Map<String, String> list;
    protected  static RoleDAO roleDAO;
    private static int quantity = 0;
    
    public RoleBUS() throws ClassNotFoundException, SQLException, IOException {
        roleDAO = new RoleDAO();
        list =  roleDAO.getList();
        quantity = list.size();
    }

    public Map<String, String> getList() {
        return list;
    }
}
