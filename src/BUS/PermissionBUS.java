/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.PermissionDAO;
import DTO.entities.Permission;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import java.util.ArrayList;
/**
 *
 * @author WIN 10
 */
public class PermissionBUS {
    protected static ArrayList<Permission> list;
    protected static ArrayList<Permission> canAccess;
    protected static PermissionDAO permissionDAO;
    private static int quantity = 0;
    
    public PermissionBUS() throws ClassNotFoundException, SQLException, IOException {
        permissionDAO = new PermissionDAO();
        list = new ArrayList<>(permissionDAO.getList());
        quantity = list.size();
    }

    public ArrayList<Permission> getList() {
        return list;
    }
    
    public int getQuantity() {
        quantity = list.size();
        return quantity;
    }           
    public ArrayList<Integer> hasPermission(String roleID,String action_ID , ArrayList<Permission> canAccess) throws ClassNotFoundException, SQLException, IOException, NoSuchAlgorithmException{
        ArrayList<Integer> listpermission = new ArrayList<>();
        for (Permission permission : canAccess) {
            if (permission.getActionID().equals(action_ID)){ 
                listpermission.add(permission.getPerAccess());
                listpermission.add(permission.getPerCreate());                
                listpermission.add(permission.getPerView());
                listpermission.add(permission.getPerEdit());
                listpermission.add(permission.getPerDelete());
            }
        }
        return listpermission;
    }
    public boolean hasPerAccess(String roleID, String action_ID){
        for(Permission permission : list){
            if(permission.getRoleID().equals(roleID) && permission.getActionID().equals(action_ID)){
                System.out.println("Done");
                return permission.getPerAccess() == 1;
            }
        }
        return false;
    }
    public boolean hasPerCreate(String roleID, String action_ID){
        for(Permission permission : list){
            if(permission.getRoleID().equals(roleID) && permission.getActionID().equals(action_ID)){
                return permission.getPerCreate() == 1;
            }
        }
        return false;
    }
    public boolean hasPerView(String roleID, String action_ID){
        for(Permission permission : list){
            if(permission.getRoleID().equals(roleID) && permission.getActionID().equals(action_ID)){
                return permission.getPerView() == 1;
            }
        }
        return false;
    }
    public boolean hasPerEdit(String roleID, String action_ID){
        for(Permission permission : list){
            if(permission.getRoleID().equals(roleID) && permission.getActionID().equals(action_ID)){
                return permission.getPerEdit() == 1;
            }
        }
        return false;
    }
    public boolean hasPerDelete(String roleID, String action_ID){
        for(Permission permission : list){
            if(permission.getRoleID().equals(roleID) && permission.getActionID().equals(action_ID)){
                return permission.getPerDelete()== 1;
            }
        }
        return false;
    }
    public static ArrayList<Permission> canAccessForm(String roleID) throws IOException, ClassNotFoundException, SQLException {
        canAccess =  permissionDAO.getPermissonByRoleID(roleID);
        return canAccess;
    }
}
